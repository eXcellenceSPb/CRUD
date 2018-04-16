package service;

import model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User getUserById(int userId);
    List<User> getAll();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getUserByLogin(String login);

}
