package epam.alsab.dao.user;

import epam.alsab.dao.JdbcDaoSupport;
import epam.alsab.model.User;
import epam.alsab.service.AddressService;

import java.util.List;



public class UserJdbcDAO extends JdbcDaoSupport implements UserDAO {

    static final String CREATE_SQL = "INSERT INTO aleksei.user (first_name, last_name, address_id) VALUES (?, ?, ?);";
    static final String READ_SQL = "SELECT user_id, first_name, last_name, address_id FROM aleksei.user WHERE user_id = ?";
    static final String UPDATE_SQL = "UPDATE aleksei.user SET first_name=?, last_name=?, address_id=? WHERE user_id = ?";
    static final String DELETE_SQL = "DELETE FROM aleksei.user WHERE user_id= ?";
    static final String FIND_ALL_SQL = "SELECT user_id, first_name, last_name, address_id FROM aleksei.user";
    static final String FIND_USER_BY_FIRST_NAME_SQL = "SELECT user_id, first_name, last_name, address_id FROM aleksei.user WHERE first_name = ?";

    private JdbcDaoSupport.Mapper<User> mapper = rs -> {
        User user = new User(
                rs.getLong("user_id"),
                rs.getString("last_name"),
                rs.getString("last_name"),
                AddressService.getAddressById(rs.getLong("address_id"))
        );
        return user;
    };

    @Override
    public List<User> findAll() {
        return selectList(FIND_ALL_SQL, mapper);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return selectList(FIND_USER_BY_FIRST_NAME_SQL, mapper, firstName);
    }

    @Override
    public boolean isExist(String name) {
        return !(findByFirstName(name).isEmpty());
    }

    @Override
    public void create(User user) {
        update(CREATE_SQL, user.getFirstName(), user.getLastName(), user.getAddress().getAddressId());
    }

    @Override
    public User read(Long userId) {
        return select(READ_SQL, mapper, userId);
    }

    @Override
    public void update(User user) {
        update(UPDATE_SQL, user.getFirstName(), user.getLastName(), user.getAddress().getAddressId(), user.getUserID());
    }

    @Override
    public void delete(Long userId) {
        update(DELETE_SQL, userId);
    }
}
