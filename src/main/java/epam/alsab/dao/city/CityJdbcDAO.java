package epam.alsab.dao.city;

import epam.alsab.dao.JdbcDaoSupport;
import epam.alsab.model.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CityJdbcDAO extends JdbcDaoSupport implements CityDAO {

    static final String CREATE_SQL = "INSERT INTO aleksei.city(name) VALUES(?)";
    static final String READ_SQL = "SELECT city_id, name FROM aleksei.city WHERE city_id = ?";
    static final String UPDATE_SQL = "UPDATE aleksei.city SET name = ? WHERE city_id = ?";
    static final String DELETE_SQL = "DELETE FROM aleksei.city WHERE city_id= ?";
    static final String FIND_ALL_SQL = "SELECT * FROM aleksei.city";
    static final String FIND_BY_NAME_SQL = "SELECT * FROM aleksei.city where name= ?";


    private JdbcDaoSupport.Mapper<City> mapper = new JdbcDaoSupport.Mapper<City>() {
        @Override
        public City rowmap(ResultSet rs) throws SQLException {
            City city = new City(
                    rs.getLong("city_id"),
                    rs.getString("name")
            );
            return city;
        }
    };

    @Override
    public void create(City city) {
        update(CREATE_SQL, city.getName());
    }

    @Override
    public City read(Long id) {
        return select(READ_SQL, mapper, id);
    }

    @Override
    public void update(City city) {
        update(UPDATE_SQL, city.getName(), city.getCityId());
    }

    @Override
    public void delete(Long id) {
        update(DELETE_SQL, id);
    }

    @Override
    public List<City> findAll() {
        return selectList(FIND_ALL_SQL, mapper);
    }

    @Override
    public List<City> findByName(String name) {
        return selectList(FIND_BY_NAME_SQL, mapper, name);
    }

    @Override
    public boolean isExist(String name) {
        return !(findByName(name).isEmpty());
    }
}
