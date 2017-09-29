/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Config.HibernateUtil;
import com.Models.User;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DjazzJah
 */
public class UserImpl implements UserDAO {

    @Override
    public List<User> affichageUser() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        List<User> users = new ArrayList<User>();
        try {
            tr = session.beginTransaction();
            Query query = session.createQuery("from User u");
            users = query.list();
            session.flush();
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
        sf.close();
        return users;
    }

    @Override
    public void modificationUser(User us) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            User user = (User) session.get(User.class, us.getId());
            user.setLogin(us.getLogin());
            user.setPassword(SHAConverter(us.getPassword()));
            session.update(user);
            session.flush();
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
        sf.close();
    }

    @Override
    public void suppressionUser(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            session.flush();
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
        sf.close();
    }

    @Override
    public void ajoutUser(User us) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(us);
            session.flush();
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
        sf.close();
    }

    @Override
    public User verificationUser(String login, String password) {
        User us = null;
        String hash_password = SHAConverter(password);
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        List<User> users = new ArrayList<User>();
        try {
            tr = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", login));
            criteria.add(Restrictions.eq("password", hash_password));
            users = criteria.list();
            for (Object ob : users) {
                us = (User) ob;
            }
            session.flush();
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
        sf.close();
        return us;
    }

    public String SHAConverter(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(password.getBytes("UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                stringBuilder.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
            Logger.getLogger(UserImpl.class.getName()).log(Level.SEVERE, null, "SHAConverter.getAsObject:" + unsupportedEncodingException);
            return "";
        }
    }
}
