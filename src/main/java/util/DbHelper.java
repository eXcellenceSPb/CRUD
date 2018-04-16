package util;

import DAO.UserDaoImpl;
import model.User;
import org.hibernate.cfg.Configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbHelper{

   @SuppressWarnings("deprecation")
   public static Connection getConnection(){
       try {
       DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
       StringBuilder url = new StringBuilder();
       url.
               append("jdbc:mysql://").
               append("localhost:").
               append("3306/").
               append("qwert?").
               append("user=root&").
               append("password=root");
       System.out.println("URL: " + url + "\n");
       return DriverManager.getConnection(url.toString());

   } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
       e.printStackTrace();
   }
       return null;
   }

    public static Configuration getConfiguration() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File("/home/excellence/IdeaProjects/qwert/src/main/resources/db.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.setProperty("hibernate.dialect", props.getProperty("Dialect"));
        configuration.setProperty("hibernate.connection.driver_class", props.getProperty("Driver"));
        configuration.setProperty("hibernate.connection.url", props.getProperty("URL"));
        configuration.setProperty("hibernate.connection.username", props.getProperty("User"));
        configuration.setProperty("hibernate.connection.password", props.getProperty("Pass"));
        return configuration;
    }
}
