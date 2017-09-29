
package ws.test;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ClientWS", targetNamespace = "http://ws/test/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClientWS {


    /**
     * 
     * @return
     *     returns java.util.List<ws.test.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllUser", targetNamespace = "http://ws/test/", className = "ws.test.GetAllUser")
    @ResponseWrapper(localName = "getAllUserResponse", targetNamespace = "http://ws/test/", className = "ws.test.GetAllUserResponse")
    @Action(input = "http://ws/test/ClientWS/getAllUserRequest", output = "http://ws/test/ClientWS/getAllUserResponse")
    public List<User> getAllUser();

    /**
     * 
     * @return
     *     returns java.util.List<ws.test.Client>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllClient", targetNamespace = "http://ws/test/", className = "ws.test.GetAllClient")
    @ResponseWrapper(localName = "getAllClientResponse", targetNamespace = "http://ws/test/", className = "ws.test.GetAllClientResponse")
    @Action(input = "http://ws/test/ClientWS/getAllClientRequest", output = "http://ws/test/ClientWS/getAllClientResponse")
    public List<Client> getAllClient();

    /**
     * 
     * @param user
     */
    @WebMethod
    @RequestWrapper(localName = "addUser", targetNamespace = "http://ws/test/", className = "ws.test.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://ws/test/", className = "ws.test.AddUserResponse")
    @Action(input = "http://ws/test/ClientWS/addUserRequest", output = "http://ws/test/ClientWS/addUserResponse")
    public void addUser(
        @WebParam(name = "user", targetNamespace = "")
        User user);

    /**
     * 
     * @param client
     */
    @WebMethod
    @RequestWrapper(localName = "addClient", targetNamespace = "http://ws/test/", className = "ws.test.AddClient")
    @ResponseWrapper(localName = "addClientResponse", targetNamespace = "http://ws/test/", className = "ws.test.AddClientResponse")
    @Action(input = "http://ws/test/ClientWS/addClientRequest", output = "http://ws/test/ClientWS/addClientResponse")
    public void addClient(
        @WebParam(name = "client", targetNamespace = "")
        Client client);

    /**
     * 
     * @param user
     */
    @WebMethod
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://ws/test/", className = "ws.test.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://ws/test/", className = "ws.test.UpdateUserResponse")
    @Action(input = "http://ws/test/ClientWS/updateUserRequest", output = "http://ws/test/ClientWS/updateUserResponse")
    public void updateUser(
        @WebParam(name = "user", targetNamespace = "")
        User user);

    /**
     * 
     * @param client
     */
    @WebMethod
    @RequestWrapper(localName = "updateClient", targetNamespace = "http://ws/test/", className = "ws.test.UpdateClient")
    @ResponseWrapper(localName = "updateClientResponse", targetNamespace = "http://ws/test/", className = "ws.test.UpdateClientResponse")
    @Action(input = "http://ws/test/ClientWS/updateClientRequest", output = "http://ws/test/ClientWS/updateClientResponse")
    public void updateClient(
        @WebParam(name = "client", targetNamespace = "")
        Client client);

    /**
     * 
     * @param iduser
     */
    @WebMethod
    @RequestWrapper(localName = "deleteUser", targetNamespace = "http://ws/test/", className = "ws.test.DeleteUser")
    @ResponseWrapper(localName = "deleteUserResponse", targetNamespace = "http://ws/test/", className = "ws.test.DeleteUserResponse")
    @Action(input = "http://ws/test/ClientWS/deleteUserRequest", output = "http://ws/test/ClientWS/deleteUserResponse")
    public void deleteUser(
        @WebParam(name = "iduser", targetNamespace = "")
        int iduser);

    /**
     * 
     * @param idclient
     */
    @WebMethod
    @RequestWrapper(localName = "deleteClient", targetNamespace = "http://ws/test/", className = "ws.test.DeleteClient")
    @ResponseWrapper(localName = "deleteClientResponse", targetNamespace = "http://ws/test/", className = "ws.test.DeleteClientResponse")
    @Action(input = "http://ws/test/ClientWS/deleteClientRequest", output = "http://ws/test/ClientWS/deleteClientResponse")
    public void deleteClient(
        @WebParam(name = "idclient", targetNamespace = "")
        int idclient);

    /**
     * 
     * @param login
     * @param password
     * @return
     *     returns ws.test.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "verifyUser", targetNamespace = "http://ws/test/", className = "ws.test.VerifyUser")
    @ResponseWrapper(localName = "verifyUserResponse", targetNamespace = "http://ws/test/", className = "ws.test.VerifyUserResponse")
    @Action(input = "http://ws/test/ClientWS/verifyUserRequest", output = "http://ws/test/ClientWS/verifyUserResponse")
    public User verifyUser(
        @WebParam(name = "login", targetNamespace = "")
        String login,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param ob
     * @param cle
     * @return
     *     returns java.util.List<ws.test.Client>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchClient", targetNamespace = "http://ws/test/", className = "ws.test.SearchClient")
    @ResponseWrapper(localName = "searchClientResponse", targetNamespace = "http://ws/test/", className = "ws.test.SearchClientResponse")
    @Action(input = "http://ws/test/ClientWS/searchClientRequest", output = "http://ws/test/ClientWS/searchClientResponse")
    public List<Client> searchClient(
        @WebParam(name = "cle", targetNamespace = "")
        String cle,
        @WebParam(name = "ob", targetNamespace = "")
        String ob);

}