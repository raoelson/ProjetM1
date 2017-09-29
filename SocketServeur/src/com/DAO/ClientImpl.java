/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Config.HibernateUtil;
import com.Models.Client;
import com.Models.User;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
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
public class ClientImpl implements ClientDAO {

    @Override
    public List<Client> affichage(String req) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        List<Client> clients = new ArrayList<Client>();
        try {
            tr = session.beginTransaction();
            Query query = session.createQuery(req);            
            clients = query.list();
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
        return clients;
    }

    @Override
    public void modification(Client cl) {
          SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            Client client = (Client) session.get(Client.class, cl.getId());
            client.setNom(cl.getNom());
            client.setAdresse(cl.getAdresse());
            client.setSolde(cl.getSolde());
            session.update(client);
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
    public void supprimer(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            Client client = (Client) session.get(Client.class, id);
            session.delete(client);
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
    public void ajout(Client cl) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(cl);
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
    public List<Client> getAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        List<Client> clients = new ArrayList<Client>();
        try {
            tr = session.beginTransaction();
            Query query = session.createQuery("SELECT c FROM Client c");            
            clients = query.list();
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
        return clients;
    }

    @Override
    public User verification(String login, String password) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        List<User> users = new ArrayList<User>();
        User user = null;        
        try {
            tr = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("login", login));
            criteria.add(Restrictions.eq("password", password));
            users = criteria.list();
            for (Object ob : users) {
                user = (User) ob;
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
        return user;
    }
     
}
