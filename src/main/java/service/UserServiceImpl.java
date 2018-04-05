package service;

import DAO.UserDAO;
import DAO.UserDaoImpl;
import model.User;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDAO userDao;

    {
        try {
            userDao = new UserDaoImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
