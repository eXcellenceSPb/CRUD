package DAO;

import model.User;
import org.hibernate.SessionFactory;

import java.util.List;

public interface UserDAO {
    public User getUserById(int userId);
    public List<User> getAll();
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}
