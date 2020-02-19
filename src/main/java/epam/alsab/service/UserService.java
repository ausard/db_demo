package epam.alsab.service;

import epam.alsab.dao.user.UserJdbcDAO;
import epam.alsab.model.User;

import java.util.List;

public class UserService {

    private static final UserJdbcDAO userJdbcDAO = new UserJdbcDAO();

    public static void createUser(User user) {
        userJdbcDAO.create(user);
    }

    public static User getUserById(Long userId) {
        return userJdbcDAO.read(userId);
    }

    public static List<User> getAllUsers() {
        return userJdbcDAO.findAll();
    }

    public static void updateUser(User user) {
        userJdbcDAO.update(user);
    }

    public static void deleteUser(Long userId) {
        userJdbcDAO.delete(userId);
    }

    public static List<User> findByName(String name) {
        return userJdbcDAO.findByFirstName(name);
    }

    public static boolean isExist(String name) {
        return userJdbcDAO.isExist(name);
    }
}
