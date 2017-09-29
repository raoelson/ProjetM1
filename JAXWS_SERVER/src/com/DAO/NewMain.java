/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Models.Client;
import java.util.Iterator;

/**
 *
 * @author DjazzJah
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       String url = "http://localhost:8787/ClientWS/";   
//        Endpoint.publish(url, new ws.JAXWSServices());
//        System.out.println(url);
        ClientDAO dao = new ClientImpl();
//        Client cl = dao.rechercheClient("RAOELSON", "nom");
        Iterator it = dao.rechercheClient("fianar", "adresse").iterator();
        while(it.hasNext()){
            Client cl = (Client) it.next();
             System.out.print(cl.getId() + " "+ cl.getAdresse());
        }                      
    }
}
