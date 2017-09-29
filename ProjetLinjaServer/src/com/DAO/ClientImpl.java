/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Model.Client;
import com.Outil.HibernateUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author DjazzJah
 */
public class ClientImpl implements ClientDAO {

    @Override
    public List<Client> getListAll() {
        int rep = 0;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        List<Client> clients = new ArrayList<Client>();
        try {
            tr = session.beginTransaction();
            Query query = session.createQuery("from Client c order by c.id ASC");
            clients = query.list();
            session.flush();
            tr.commit();
        } catch (Exception e) {
            rep= 1;
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
    public void createClient(Client client) {
        String v = null;
        Client cl = new Client(client.getNom(), client.getAdresse(), client.getSolde());        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            session.save(cl);
            session.flush();
            tr.commit();
        } catch (Exception e) {            
            //createFilexml("ajout", v.valueOf(client.getId()), client.getNom(), client.getAdresse(), v.valueOf(client.getSolde()));
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
        sf.close();        
    }

    @Override
    public void deleteClient(Client client_) {
        String v = null;
        int rep = 0;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            Client client = (Client) session.get(Client.class, client_.getId());
            session.delete(client);
            session.flush();
            tr.commit();
        } catch (Exception e) {

            createFilexml("suppression", v.valueOf(client_.getId()), client_.getNom(), client_.getAdresse(), v.valueOf(client_.getSolde()));
            
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
        sf.close();
        
    }

    @Override
    public void updateClient(Client client) {
        String v = null;        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            Client client_ = (Client) session.get(Client.class, client.getId());
            client_.setNom(client.getNom());
            client_.setAdresse(client.getAdresse());
            client_.setSolde(client.getSolde());
            session.update(client_);
            session.flush();
            tr.commit();
        } catch (Exception e) {
            //createFilexml("modif", v.valueOf(client.getId()), client.getNom(), client.getAdresse(), v.valueOf(client.getSolde()));            
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
        sf.close();        
    }

    @Override
    public void createFilexml(String action, String id, String nom, String adresse, String bourse) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
           
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("root");
            doc.appendChild(rootElement);

            // staff elements
            Element staff = doc.createElement("etudiant");
            rootElement.appendChild(staff);

            // set attribute to staff element
            Attr attr = doc.createAttribute("action");
            attr.setValue(action);
            staff.setAttributeNode(attr);
            attr = doc.createAttribute("id");
            attr.setValue(id);
            staff.setAttributeNode(attr);
            // shorten way
            // staff.setAttribute("id", "1");

            // firstname elements
            Element firstname = doc.createElement("nom");
            firstname.appendChild(doc.createTextNode(nom));
            staff.appendChild(firstname);

            // lastname elements
            Element lastname = doc.createElement("adresse");
            lastname.appendChild(doc.createTextNode(adresse));
            staff.appendChild(lastname);

            // nickname elements
            Element nickname = doc.createElement("bourse");
            nickname.appendChild(doc.createTextNode(bourse));
            staff.appendChild(nickname);




            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\file.xml"));

            // Output to console for testing             
            transformer.transform(source, result);

            System.out.println("File saved!");
        } catch (Exception e) {
        }
    }
    
}
