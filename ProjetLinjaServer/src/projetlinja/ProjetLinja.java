/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlinja;

import com.DAO.ClientDAO;
import com.DAO.ClientImpl;
import com.Model.Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author DjazzJah
 */
public class ProjetLinja {

    /**
     * @param args the command line arguments
     */
    ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String reponses, message;
    ClientDAO dao;

    public ProjetLinja() {
        dao = new ClientImpl();
    }

    public static void main(String args[]) {
        ProjetLinja server = new ProjetLinja();

        while (true) {
            server.run();
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
                System.out.println(choix);
                if (choix.equalsIgnoreCase("fich")) {
                    String data_client = (message.substring(4));
                    try {
                        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        InputSource is = new InputSource();
                        is.setCharacterStream(new StringReader(data_client));
                        Document doc = db.parse(is);
                        NodeList nodes = doc.getElementsByTagName("etudiant");
                        for (int i = 0; i < nodes.getLength(); i++) {
                            Node nNode = nodes.item(i);
                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element eElement = (Element) nNode;
                                if ((eElement.getAttribute("action")).equals("supp")) {
                                    Client client = new Client(Integer.parseInt(eElement.getAttribute("id")), eElement.getElementsByTagName("nom").item(0).getTextContent(),
                                            eElement.getElementsByTagName("adresse").item(0).getTextContent(), Integer.parseInt(eElement.getElementsByTagName("bourse").item(0).getTextContent()));
                                    dao.deleteClient(client);
                                } else if ((eElement.getAttribute("action")).equals("save")) {
                                    Client client = new Client(Integer.parseInt(eElement.getAttribute("id")), eElement.getElementsByTagName("nom").item(0).getTextContent(),
                                            eElement.getElementsByTagName("adresse").item(0).getTextContent(), Integer.parseInt(eElement.getElementsByTagName("bourse").item(0).getTextContent()));
                                    dao.createClient(client);
                                } else if ((eElement.getAttribute("action")).equals("edit")) {
                                    Client client = new Client(Integer.parseInt(eElement.getAttribute("id")), eElement.getElementsByTagName("nom").item(0).getTextContent(),
                                            eElement.getElementsByTagName("adresse").item(0).getTextContent(), Integer.parseInt(eElement.getElementsByTagName("bourse").item(0).getTextContent()));
                                    dao.updateClient(client);
                                }

                                reponses = "<root>";
                                Iterator it = dao.getListAll().iterator();
                                while (it.hasNext()) {
                                    Client object = (Client) it.next();
                                    reponses = reponses + "\n<etudiant action=\"select\" id=\"" + object.getId() + "\">";
                                    reponses = reponses + "\n<nom>" + object.getNom() + "</nom>";
                                    reponses = reponses + "\n<adresse>" + object.getAdresse() + "</adresse>";
                                    reponses = reponses + "\n<bourse>" + object.getSolde() + "</bourse>";
                                    reponses = reponses + "\n</etudiant>";
                                }
                                reponses = reponses + "\n</root>";
                                sendMessage(reponses);

                            }
                        }
                    } catch (Exception e) {
                    }
                } else if (choix.equals("supp")) {
                    dao.deleteClient(new Client(Integer.parseInt(message.substring(4))));
                    sendMessage("ok");
                } else if (choix.equals("save")) {
                    String data_client = (message.substring(4));
                    try {
                        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        InputSource is = new InputSource();
                        is.setCharacterStream(new StringReader(data_client));
                        Document doc = db.parse(is);
                        NodeList nodes = doc.getElementsByTagName("etudiant");
                        for (int i = 0; i < nodes.getLength(); i++) {
                            Node nNode = nodes.item(i);
                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element eElement = (Element) nNode;
                                Client client = new Client(Integer.parseInt(eElement.getAttribute("id")), eElement.getElementsByTagName("nom").item(0).getTextContent(),
                                        eElement.getElementsByTagName("adresse").item(0).getTextContent(), Integer.parseInt(eElement.getElementsByTagName("bourse").item(0).getTextContent()));
                                dao.createClient(client);
                            }
                        }
                    } catch (Exception e) {
                    }
                    sendMessage("ok");
                }else if (choix.equals("edit")) {
                    String data_client = (message.substring(4));
                    try {
                        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                        InputSource is = new InputSource();
                        is.setCharacterStream(new StringReader(data_client));
                        Document doc = db.parse(is);
                        NodeList nodes = doc.getElementsByTagName("etudiant");
                        for (int i = 0; i < nodes.getLength(); i++) {
                            Node nNode = nodes.item(i);
                            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element eElement = (Element) nNode;
                                Client client = new Client(Integer.parseInt(eElement.getAttribute("id")), eElement.getElementsByTagName("nom").item(0).getTextContent(),
                                        eElement.getElementsByTagName("adresse").item(0).getTextContent(), Integer.parseInt(eElement.getElementsByTagName("bourse").item(0).getTextContent()));
                                dao.updateClient(client);
                            }
                        }
                    } catch (Exception e) {
                    }
                    sendMessage("ok");
                } else {
                    reponses = "<root>";
                    Iterator it = dao.getListAll().iterator();
                    while (it.hasNext()) {
                        Client object = (Client) it.next();
                        reponses = reponses + "\n<etudiant action=\"select\" id=\"" + object.getId() + "\">";
                        reponses = reponses + "\n<nom>" + object.getNom() + "</nom>";
                        reponses = reponses + "\n<adresse>" + object.getAdresse() + "</adresse>";
                        reponses = reponses + "\n<bourse>" + object.getSolde() + "</bourse>";
                        reponses = reponses + "\n</etudiant>";
                    }
                    reponses = reponses + "\n</root>";
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
}
