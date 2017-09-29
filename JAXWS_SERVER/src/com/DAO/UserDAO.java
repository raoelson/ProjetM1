/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Models.User;
import java.util.List;

/**
 *
 * @author DjazzJah
 */
public interface UserDAO {

    List<User> affichageUser();

    void modificationUser(User us);

    void suppressionUser(int id);

    void ajoutUser(User us);

    User verificationUser(String login, String password);

    String SHAConverter(String password);
    
}
