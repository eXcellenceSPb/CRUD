package dbservice.DAO;

import dbservice.DBService;
import dbservice.executor.Executor;
import dbservice.userDataSet.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;
    private Executor executor;

    public UserDAO() {
        connection = DBService.getH2Connection();
    }

//    public UserDAO(){
//        this.executor = new Executor(DBService.getH2Connection());
//    }

//    public User get(int id) throws SQLException {
//        return executor.execQuery("select * from qwert where id="+
//                id,result->{
//            result.next();
//            return new User(result.getInt(1),
//                    result.getString(2),
//                    result.getString(3),
//                    result.getString(4));
//        });
//    }

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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

//    public User getUserById2(int id) throws SQLException{
//        User user = new User();
//        return executor.execQuery("select * from qwert where id='"+id+"'",
//                result->{
//            if(result.next()){
//                user.setId(result.getInt("id"));
//                user.setName(result.getString("name"));
//                user.setPass((result.getString("pass")));
//                user.setLogin(result.getString("login"));
//            }
//            return user;
//                });
//    }
//    public void delUser(int id)throws SQLException{
//        executor.execUpdate("delete from qwert WHERE id='"+id+"'");
//    }
//
//    public void insertUser(String name,String pass,String login) throws SQLException{
//        executor.execUpdate("insert into qwert (name,pass,login) VALUES ('"+name+","+pass+","+login+"')");
//    }

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
                    .prepareStatement("INSERT into qwert(id,name,pass,login) values (?,?,?,?)");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPass());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE qwert set id=?, name=?, pass=?, login=?" +
                            "where id=?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPass());
            preparedStatement.setString(4, user.getLogin());
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
