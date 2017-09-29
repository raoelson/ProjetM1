/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Models.Client;
import com.Models.User;
import java.util.List;

/**
 *
 * @author DjazzJah
 */
public interface ClientDAO {

    List<Client> affichage(String req);

    List<Client> getAll();

    void modification(Client cl);

    void supprimer(int id);

    void ajout(Client cl);

    User verification(String login, String password);
    
}
