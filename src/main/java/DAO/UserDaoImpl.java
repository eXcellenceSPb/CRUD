package DAO;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import java.util.ArrayList;
import java.util.List;



public class UserDaoImpl implements UserDAO{
    private Transaction tx;
    private static SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        UserDaoImpl.sessionFactory = sessionFactory;
        sessionFactory.openSession();
    }

    public static SessionFactory createSessionFactory(Configuration configuration) {
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

    public User getUserByLogin(String login) {
        tx = null;
        User user = null;
        try{
         Session session = sessionFactory.openSession();
            tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("FROM User WHERE login='" + login + "'");
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
//    public User getUserByLogin(String login){
//        try {
//            return (User) sessionFactory.getCurrentSession()
//                    .createQuery("FROM USER where login='"+login +"'")
//                    .getSingleResult();
//        }
//        catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
