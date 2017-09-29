/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Models.Client;
import java.util.List;

/**
 *
 * @author DjazzJah
 */
public interface ClientDAO {

    List<Client> affichageClient();

    void modificationClient(Client cl);

    void suppressionClient(int id);

    void ajoutClient(Client cl);
    
    List<Client> rechercheClient(String cle,String ob);
}
