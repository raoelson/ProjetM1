
package ws.test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.test package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddUserResponse_QNAME = new QName("http://ws/test/", "addUserResponse");
    private final static QName _AddClientResponse_QNAME = new QName("http://ws/test/", "addClientResponse");
    private final static QName _GetAllUser_QNAME = new QName("http://ws/test/", "getAllUser");
    private final static QName _VerifyUserResponse_QNAME = new QName("http://ws/test/", "verifyUserResponse");
    private final static QName _VerifyUser_QNAME = new QName("http://ws/test/", "verifyUser");
    private final static QName _DeleteClientResponse_QNAME = new QName("http://ws/test/", "deleteClientResponse");
    private final static QName _AddUser_QNAME = new QName("http://ws/test/", "addUser");
    private final static QName _SearchClient_QNAME = new QName("http://ws/test/", "searchClient");
    private final static QName _UpdateClient_QNAME = new QName("http://ws/test/", "updateClient");
    private final static QName _AddClient_QNAME = new QName("http://ws/test/", "addClient");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://ws/test/", "updateUserResponse");
    private final static QName _DeleteUserResponse_QNAME = new QName("http://ws/test/", "deleteUserResponse");
    private final static QName _DeleteClient_QNAME = new QName("http://ws/test/", "deleteClient");
    private final static QName _GetAllClientResponse_QNAME = new QName("http://ws/test/", "getAllClientResponse");
    private final static QName _GetAllUserResponse_QNAME = new QName("http://ws/test/", "getAllUserResponse");
    private final static QName _GetAllClient_QNAME = new QName("http://ws/test/", "getAllClient");
    private final static QName _UpdateUser_QNAME = new QName("http://ws/test/", "updateUser");
    private final static QName _UpdateClientResponse_QNAME = new QName("http://ws/test/", "updateClientResponse");
    private final static QName _DeleteUser_QNAME = new QName("http://ws/test/", "deleteUser");
    private final static QName _SearchClientResponse_QNAME = new QName("http://ws/test/", "searchClientResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VerifyUser }
     * 
     */
    public VerifyUser createVerifyUser() {
        return new VerifyUser();
    }

    /**
     * Create an instance of {@link AddClientResponse }
     * 
     */
    public AddClientResponse createAddClientResponse() {
        return new AddClientResponse();
    }

    /**
     * Create an instance of {@link GetAllUser }
     * 
     */
    public GetAllUser createGetAllUser() {
        return new GetAllUser();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link VerifyUserResponse }
     * 
     */
    public VerifyUserResponse createVerifyUserResponse() {
        return new VerifyUserResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link DeleteClientResponse }
     * 
     */
    public DeleteClientResponse createDeleteClientResponse() {
        return new DeleteClientResponse();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link DeleteUserResponse }
     * 
     */
    public DeleteUserResponse createDeleteUserResponse() {
        return new DeleteUserResponse();
    }

    /**
     * Create an instance of {@link AddClient }
     * 
     */
    public AddClient createAddClient() {
        return new AddClient();
    }

    /**
     * Create an instance of {@link GetAllClientResponse }
     * 
     */
    public GetAllClientResponse createGetAllClientResponse() {
        return new GetAllClientResponse();
    }

    /**
     * Create an instance of {@link DeleteClient }
     * 
     */
    public DeleteClient createDeleteClient() {
        return new DeleteClient();
    }

    /**
     * Create an instance of {@link UpdateClient }
     * 
     */
    public UpdateClient createUpdateClient() {
        return new UpdateClient();
    }

    /**
     * Create an instance of {@link SearchClient }
     * 
     */
    public SearchClient createSearchClient() {
        return new SearchClient();
    }

    /**
     * Create an instance of {@link UpdateClientResponse }
     * 
     */
    public UpdateClientResponse createUpdateClientResponse() {
        return new UpdateClientResponse();
    }

    /**
     * Create an instance of {@link SearchClientResponse }
     * 
     */
    public SearchClientResponse createSearchClientResponse() {
        return new SearchClientResponse();
    }

    /**
     * Create an instance of {@link DeleteUser }
     * 
     */
    public DeleteUser createDeleteUser() {
        return new DeleteUser();
    }

    /**
     * Create an instance of {@link GetAllClient }
     * 
     */
    public GetAllClient createGetAllClient() {
        return new GetAllClient();
    }

    /**
     * Create an instance of {@link GetAllUserResponse }
     * 
     */
    public GetAllUserResponse createGetAllUserResponse() {
        return new GetAllUserResponse();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "addClientResponse")
    public JAXBElement<AddClientResponse> createAddClientResponse(AddClientResponse value) {
        return new JAXBElement<AddClientResponse>(_AddClientResponse_QNAME, AddClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "getAllUser")
    public JAXBElement<GetAllUser> createGetAllUser(GetAllUser value) {
        return new JAXBElement<GetAllUser>(_GetAllUser_QNAME, GetAllUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "verifyUserResponse")
    public JAXBElement<VerifyUserResponse> createVerifyUserResponse(VerifyUserResponse value) {
        return new JAXBElement<VerifyUserResponse>(_VerifyUserResponse_QNAME, VerifyUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "verifyUser")
    public JAXBElement<VerifyUser> createVerifyUser(VerifyUser value) {
        return new JAXBElement<VerifyUser>(_VerifyUser_QNAME, VerifyUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "deleteClientResponse")
    public JAXBElement<DeleteClientResponse> createDeleteClientResponse(DeleteClientResponse value) {
        return new JAXBElement<DeleteClientResponse>(_DeleteClientResponse_QNAME, DeleteClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "searchClient")
    public JAXBElement<SearchClient> createSearchClient(SearchClient value) {
        return new JAXBElement<SearchClient>(_SearchClient_QNAME, SearchClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "updateClient")
    public JAXBElement<UpdateClient> createUpdateClient(UpdateClient value) {
        return new JAXBElement<UpdateClient>(_UpdateClient_QNAME, UpdateClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "addClient")
    public JAXBElement<AddClient> createAddClient(AddClient value) {
        return new JAXBElement<AddClient>(_AddClient_QNAME, AddClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "deleteUserResponse")
    public JAXBElement<DeleteUserResponse> createDeleteUserResponse(DeleteUserResponse value) {
        return new JAXBElement<DeleteUserResponse>(_DeleteUserResponse_QNAME, DeleteUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "deleteClient")
    public JAXBElement<DeleteClient> createDeleteClient(DeleteClient value) {
        return new JAXBElement<DeleteClient>(_DeleteClient_QNAME, DeleteClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "getAllClientResponse")
    public JAXBElement<GetAllClientResponse> createGetAllClientResponse(GetAllClientResponse value) {
        return new JAXBElement<GetAllClientResponse>(_GetAllClientResponse_QNAME, GetAllClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "getAllUserResponse")
    public JAXBElement<GetAllUserResponse> createGetAllUserResponse(GetAllUserResponse value) {
        return new JAXBElement<GetAllUserResponse>(_GetAllUserResponse_QNAME, GetAllUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "getAllClient")
    public JAXBElement<GetAllClient> createGetAllClient(GetAllClient value) {
        return new JAXBElement<GetAllClient>(_GetAllClient_QNAME, GetAllClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "updateClientResponse")
    public JAXBElement<UpdateClientResponse> createUpdateClientResponse(UpdateClientResponse value) {
        return new JAXBElement<UpdateClientResponse>(_UpdateClientResponse_QNAME, UpdateClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "deleteUser")
    public JAXBElement<DeleteUser> createDeleteUser(DeleteUser value) {
        return new JAXBElement<DeleteUser>(_DeleteUser_QNAME, DeleteUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/test/", name = "searchClientResponse")
    public JAXBElement<SearchClientResponse> createSearchClientResponse(SearchClientResponse value) {
        return new JAXBElement<SearchClientResponse>(_SearchClientResponse_QNAME, SearchClientResponse.class, null, value);
    }

}
