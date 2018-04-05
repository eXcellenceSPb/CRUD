package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static util.DbUtil.getConfiguration;


public class UserDaoImpl implements UserDAO {
    private Transaction tx;
    private static SessionFactory sessionFactory;

    public UserDaoImpl() throws IOException {
        Configuration configuration = getConfiguration();
        sessionFactory = createSessionFactory(configuration);
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public User getUserById(int userId) {
        tx = null;
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from User where id='" + userId + "'");
            user = (User) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from User").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return list;
    }

    public void addUser(User user) {
        tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.update(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteUser(User user) {
        tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.delete(user);
            tx.commit();
        }
    }
}
