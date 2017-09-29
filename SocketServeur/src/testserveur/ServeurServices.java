/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testserveur;

import com.DAO.ClientDAO;
import com.DAO.ClientImpl;
import com.Models.Client;
import com.Models.User;
import java.awt.Frame;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author DjazzJah
 */
public class ServeurServices {

    /**
     * @param args the command line arguments
     */
    ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String reponses, message;
    ClientDAO dao;

    ServeurServices() {
        dao = new ClientImpl();
    }

    public void run() {
        try {
            providerSocket = new ServerSocket(2004, 10);
            System.out.println("Waiting for connection");
            connection = providerSocket.accept();
            System.out.println("Connection received from " + connection.getInetAddress().getHostName());
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
            try {
                message = (String) in.readObject();
                String choix = message.substring(0, 4);
                if (choix.equalsIgnoreCase("fich")) {
                    if (message.substring(4, 8).equalsIgnoreCase("supp")) {
                        dao.supprimer(Integer.parseInt(message.substring(8)));
                    } else if (message.substring(4, 8).equalsIgnoreCase("edit")) {
                        String data_client = (message.substring(8));
                        JSONArray jArray;
                        try {
                            Client client = new Client();
                            jArray = new JSONArray(data_client);
                            for (int i = 0; i < jArray.length(); i++) {
                                JSONObject json_data = jArray.getJSONObject(i);
                                client.setId(Integer.parseInt(Integer.toString(json_data.getInt("id"))));
                                client.setNom(json_data.getString("nom"));
                                client.setAdresse(json_data.getString("adresse"));
                                client.setSolde(Integer.parseInt(Integer.toString(json_data.getInt("solde"))));
                            }
                            dao.modification(client);
                        } catch (JSONException ex) {
                            Logger.getLogger(ServeurServices.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        String data_client = (message.substring(8));
                        JSONArray jArray;
                        try {
                            Client client = new Client();
                            jArray = new JSONArray(data_client);
                            for (int i = 0; i < jArray.length(); i++) {
                                JSONObject json_data = jArray.getJSONObject(i);
                                client.setNom(json_data.getString("nom"));
                                client.setAdresse(json_data.getString("adresse"));
                                client.setSolde(Integer.parseInt(Integer.toString(json_data.getInt("solde"))));
                            }
                            dao.ajout(client);
                        } catch (JSONException ex) {
                            Logger.getLogger(ServeurServices.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    reponses = "[";
                    Iterator iterator = (dao.affichage("SELECT c FROM Client c")).iterator();
                    while (iterator.hasNext()) {
                        Client client = (Client) iterator.next();

                        reponses = reponses + "{\"id\":\"";

                        reponses = reponses + client.getId();

                        reponses = reponses + "\",\"nom\":\"";

                        reponses = reponses + client.getNom();

                        reponses = reponses + "\",\"adresse\":\"";

                        reponses = reponses + client.getAdresse();

                        reponses = reponses + "\",\"solde\":\"";

                        reponses = reponses + client.getSolde()
                                + "\"},";
                    }
                    if (reponses.charAt(reponses.length() - 1) == ',') {
                        reponses = reponses.substring(0, reponses.length() - 1);
                    }
                    reponses = reponses + "]";
                    sendMessage(reponses);
                } else if (choix.equalsIgnoreCase("open")) {
                } else if (choix.equals("auth")) {
                    String data_user = (message.substring(4));
                    JSONArray jArray;
                    try {
                        User user = null;
                        jArray = new JSONArray(data_user);
                        for (int i = 0; i < jArray.length(); i++) {
                            JSONObject json_data = jArray.getJSONObject(i);
                            user = dao.verification(json_data.getString("login"), json_data.getString("password"));
                        }
                        if (user != null) {
                            sendMessage("succes");
                        } else {
                            sendMessage("erreur");
                        }

                    } catch (JSONException ex) {
                        Logger.getLogger(ServeurServices.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (choix.equals("supp")) {
                    dao.supprimer(Integer.parseInt(message.substring(4)));
                    sendMessage("Enregistrement supprimé");
                } else if (choix.equals("save")) {
                    String data_client = (message.substring(4));
                    JSONArray jArray;
                    try {
                        Client client = new Client();
                        jArray = new JSONArray(data_client);
                        for (int i = 0; i < jArray.length(); i++) {
                            JSONObject json_data = jArray.getJSONObject(i);
                            client.setNom(json_data.getString("nom"));
                            client.setAdresse(json_data.getString("adresse"));
                            client.setSolde(Integer.parseInt(Integer.toString(json_data.getInt("solde"))));
                        }
                        dao.ajout(client);
                        sendMessage("Enregistrement ajouté");
                    } catch (JSONException ex) {
                        Logger.getLogger(ServeurServices.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (choix.equals("edit")) {
                    String data_client = (message.substring(4));
                    JSONArray jArray;
                    try {
                        Client client = new Client();
                        jArray = new JSONArray(data_client);
                        for (int i = 0; i < jArray.length(); i++) {
                            JSONObject json_data = jArray.getJSONObject(i);
                            client.setId(Integer.parseInt(Integer.toString(json_data.getInt("id"))));
                            client.setNom(json_data.getString("nom"));
                            client.setAdresse(json_data.getString("adresse"));
                            client.setSolde(Integer.parseInt(Integer.toString(json_data.getInt("solde"))));
                        }
                        dao.modification(client);
                        sendMessage("Enregistrement modifié");
                    } catch (JSONException ex) {
                        Logger.getLogger(ServeurServices.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    reponses = "[";
                    Iterator iterator = (dao.affichage("SELECT c FROM Client c")).iterator();
                    while (iterator.hasNext()) {
                        Client client = (Client) iterator.next();

                        reponses = reponses + "{\"id\":\"";

                        reponses = reponses + client.getId();

                        reponses = reponses + "\",\"nom\":\"";

                        reponses = reponses + client.getNom();

                        reponses = reponses + "\",\"adresse\":\"";

                        reponses = reponses + client.getAdresse();

                        reponses = reponses + "\",\"solde\":\"";

                        reponses = reponses + client.getSolde()
                                + "\"},";
                    }
                    if (reponses.charAt(reponses.length() - 1) == ',') {
                        reponses = reponses.substring(0, reponses.length() - 1);
                    }
                    reponses = reponses + "]";
                    sendMessage(reponses);
                }
            } catch (ClassNotFoundException classnot) {
                System.err.println("Data received in unknown format");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                providerSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    void sendMessage(String msg) {
        try {
            out.writeObject(msg);
            out.flush();
            System.out.println("server>" + msg);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String args[]) {
        ServeurServices server = new ServeurServices();
        while (true) {
            server.run();
        }
    }
}
