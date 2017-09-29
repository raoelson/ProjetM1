/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Config.HibernateUtil;
import com.Models.Client;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DjazzJah
 */
public class ClientImpl implements ClientDAO {

    @Override
    public List<Client> affichageClient() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        List<Client> clients = new ArrayList<Client>();
        try {
            tr = session.beginTransaction();
            Query query = session.createQuery("from Client c");            
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
    public void modificationClient(Client cl) {
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
    public void suppressionClient(int id) {
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
    public void ajoutClient(Client cl) {
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
    public List<Client> rechercheClient(String cle,String ob) {
       SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        List<Client> clients = new ArrayList<Client>();
        try {
            tr = session.beginTransaction();
            Criteria criteria =  session.createCriteria(Client.class);
            criteria.add(Restrictions.like(ob,cle+"%"));
            clients = criteria.list();
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
}
