package dbservice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
    private static Connection connection;

    public DBService() {
        connection = getH2Connection();
    }

//    public User getUser(int id) throws DBException {
//        try {
//            return (new UserDAO(connection).get(id));
//        } catch (SQLException e) {
//            throw new DBException(e);
//        }
//    }
//
//    public long addUser(String name, String pass, String login) throws DBException {
//        try {
//            connection.setAutoCommit(false);
//            UserDAO dao = new UserDAO(connection);
//            dao.createTable();
//            dao.insertUser(name, pass, login);
//            connection.commit();
//            return dao.getUserId(name);
//        } catch (SQLException e) {
//            try {
//                connection.rollback();
//            } catch (SQLException ignore) {
//            }
//            throw new DBException(e);
//        } finally {
//            try {
//                connection.setAutoCommit(true);
//            } catch (SQLException ignore) {
//            }
//        }
//    }

    public static Connection getH2Connection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").
                    append("localhost:").
                    append("3306/").
                    append("qwert?").
                    append("user=root&").
                    append("password=");
            System.out.println("URL: " + url + "\n");
            Connection connection = DriverManager.getConnection(url.toString());
            return connection;

        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


//    public static Connection getConnection() throws IOException {
//        if (connection != null)
//            return connection;
//        else {
//            try {
//                Properties prop = new Properties();
//                InputStream inputStream = DBService.class.getClassLoader().getResourceAsStream("/db.properties");
//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                String url = prop.getProperty("url");
//                String user = prop.getProperty("user");
//                String password = prop.getProperty("password");
//                Class.forName(driver);
//                connection = DriverManager.getConnection(url, user, password);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return connection;
//        }
//
//    }
}
