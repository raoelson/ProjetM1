/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Model.Client;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author DjazzJah
 */
public interface ClientDAO {

    List<Client> getListAll();

    void createClient(Client client);

    void deleteClient(Client client);

    void updateClient(Client client);

    void createFilexml(String action, String id, String nom, String adresse, String bourse);
//    
//    Client getClient(Node node);
//    
//    String getTagValue(String tag, Element element);
}
