package service;

import model.User;

import java.util.List;

public interface UserService {
    public User getUserById(int userId);
    public List<User> getAll();
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}
