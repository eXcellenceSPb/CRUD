package DAO;

import model.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int userId);
    List<User> getAll();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUserByLogin(String login);

}
