package DAO;

import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDAO{
    private Connection connection;

    public UserDaoJDBCImpl(Connection connection) {
        this.connection = connection;
    }

    public User getUserById(int userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from qwert where id=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("pass"));
                user.setLogin(rs.getString("login"));
                user.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from qwert");
            while (result.next()) {
                User user = new User();
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setPass((result.getString("pass")));
                user.setLogin(result.getString("login"));
                user.setType(result.getString("type"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT into qwert(name,pass,login) values (?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE qwert set name=?, pass=?, login=?, type=?" +
                            "where id=?");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getType());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE from qwert where id=?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByLogin(String login) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from qwert where login=?");
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("pass"));
                user.setLogin(rs.getString("login"));
                user.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

//
//    public void createTable() throws SQLException {
//        executor.execUpdate("create table if not exists qwert (id int auto_increment, name varchar(256)," +
//                "pass varchar(256),login varchar(256), primary key (id))");
//    }
//
//    public void dropTable() throws SQLException {
//        executor.execUpdate("drop table qwert");
//    }
}