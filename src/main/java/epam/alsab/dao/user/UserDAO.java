package epam.alsab.dao.user;

import java.util.List;

import epam.alsab.dao.CrudDao;
import epam.alsab.model.User;

public interface UserDAO extends CrudDao<User, Long> {

    List<User> findAll();

    List<User> findByFirstName(String firstName);

    boolean isExist(String name);
}
