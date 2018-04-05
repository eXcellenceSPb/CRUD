package util;

import model.User;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;


public class DbUtil {
    public static Configuration getConfiguration() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(new File("C:\\Users\\vserg\\qwert\\src\\main\\resources\\db.properties")));
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
