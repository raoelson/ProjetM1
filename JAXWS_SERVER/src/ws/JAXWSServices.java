/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.DAO.UserImpl;
import com.DAO.UserDAO;
import com.DAO.ClientDAO;
import com.DAO.ClientImpl;
import com.Models.Client;
import com.Models.User;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author DjazzJah
 */
@WebService(name = "ClientWS", targetNamespace = "http://ws/test/")
public class JAXWSServices {

    private UserDAO dao;
    private ClientDAO daoclient;

    public JAXWSServices() {
        dao = new UserImpl();
        daoclient = new ClientImpl();
    }

    @WebMethod(operationName = "getAllUser")
    public List<User> getAllUser() {
        return dao.affichageUser();
    }

    @WebMethod(operationName = "getAllClient")
    public List<Client> getClient() {
        return daoclient.affichageClient();
    }

    @WebMethod(operationName = "addUser")
    public void addUser(@WebParam(name = "user") User user) {
        dao.ajoutUser(user);
    }

    @WebMethod(operationName = "addClient")
    public void addClient(@WebParam(name = "client") Client client) {
        daoclient.ajoutClient(client);
    }
    
    @WebMethod(operationName = "updateUser")
    public void updateUser(@WebParam(name = "user") User user) {
        dao.modificationUser(user);
    }

    @WebMethod(operationName = "updateClient")
    public void updateClient(@WebParam(name = "client") Client client) {
        daoclient.modificationClient(client);
    }
    
    @WebMethod(operationName = "deleteUser")
    public void deleteUser(@WebParam(name = "iduser") int iduser) {
        dao.suppressionUser(iduser);
    }

    @WebMethod(operationName = "deleteClient")
    public void deleteClient(@WebParam(name = "idclient") int idclient) {
        daoclient.suppressionClient(idclient);
    }
    
    @WebMethod(operationName = "verifyUser")
    public User verifyUser(@WebParam(name = "login") String login,@WebParam(name = "password") String password) {
        return  dao.verificationUser(login, password);
    }
    
    @WebMethod(operationName = "searchClient")
    public List<Client> searchClient(@WebParam(name = "cle") String cle,@WebParam(name = "ob") String ob) {
        return daoclient.rechercheClient(cle, ob);
    }
}
