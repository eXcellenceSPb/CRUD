package util;

import DAO.UserDAO;
import DAO.UserDaoImpl;
import DAO.UserDaoJDBCImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static DAO.UserDaoImpl.createSessionFactory;

public class UserDaoFactory {
    public static UserDAO getUserDao(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(
                    "/home/excellence/IdeaProjects/qwert/src/main/resources/db.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (properties.getProperty("Dao").equals("Hibernate")){
          return new UserDaoImpl(createSessionFactory(DbHelper.getConfiguration()));
        }
        else
           return new UserDaoJDBCImpl(DbHelper.getConnection());
    }
}
