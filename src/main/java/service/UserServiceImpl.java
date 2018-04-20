package service;

import DAO.UserDAO;
import model.User;
import util.UserDaoFactory;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDAO userDao = UserDaoFactory.getUserDao();

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    public String getUserRole(String login) {
        return userDao.getUserRole(login);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
