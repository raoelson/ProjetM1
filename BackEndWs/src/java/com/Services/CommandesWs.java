/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Services;

import com.DAO.CommandsDao;
import com.Entities.Categories;
import com.Entities.Commandes;
import com.Entities.Media;
import com.Entities.Pages;
import com.Entities.Produit;
import com.Entities.SousCategories;
import com.Entities.Tva;
import com.Entities.Utilisateurs;
import com.Entities.Utilisateursadresses;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Djazz Jah
 */
@WebService(serviceName = "CommandesWs")
public class CommandesWs {

    @EJB
    private CommandsDao ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getAllPages")
    public List<Pages> getAllPages() {
        return ejbRef.getAllPages();
    }

    @WebMethod(operationName = "getAllProduits")
    public List<Produit> getAllProduits() {
        return ejbRef.getAllProduits();
    }

    @WebMethod(operationName = "getAllCategories")
    public List<Categories> getAllCategories() {
        return ejbRef.getAllCategories();
    }

    @WebMethod(operationName = "getAllTva")
    public List<Tva> getAllTva() {
        return ejbRef.getAllTva();
    }

    @WebMethod(operationName = "getAllCommandes")
    public List<Commandes> getAllCommandes() {
        return ejbRef.getAllCommandes();
    }

    @WebMethod(operationName = "getAllUtilisateurs")
    public List<Utilisateurs> getAllUtilisateurs() {
        return ejbRef.getAllUtilisateurs();
    }

    @WebMethod(operationName = "getAllUtilisateursadresses")
    public List<Utilisateursadresses> getAllUtilisateursadresses() {
        return ejbRef.getAllUtilisateursadresses();
    }

    @WebMethod(operationName = "SearchProduits")
    public Produit SearchProduits(@WebParam(name = "id") int id) {
        return ejbRef.SearchProduits(id);
    }

    @WebMethod(operationName = "ComparaisonProduits")
    public List<Produit> ComparaisonProduits(@WebParam(name = "id") int id, @WebParam(name = "idcategorie") String idcategorie) {
        return ejbRef.ComparaisonProduits(id, idcategorie);
    }

    @WebMethod(operationName = "SearchCategories")
    public List<Produit> SearchCategories(@WebParam(name = "id") String id) {
        return ejbRef.SearchCategories(id);
    }

    @WebMethod(operationName = "ProduitsArray")
    public List<Produit> ProduitsArray(@WebParam(name = "array") List<String> array) {
        return ejbRef.ProduitsArray(array);
    }

    @WebMethod(operationName = "verificationUser")
    public Utilisateurs verificationUser(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        return ejbRef.verificationUser(login, password);
    }

    @WebMethod(operationName = "AdresseLivraison")
    public List<Utilisateursadresses> AdresseLivraison(@WebParam(name = "id") int id) {
        return ejbRef.AdresseLivraison(id);
    }

    @WebMethod(operationName = "addLivraisonAdresse")
    public int addLivraisonAdresse(@WebParam(name = "user") int user, @WebParam(name = "nom") String nom,
            @WebParam(name = "prenom") String prenom, @WebParam(name = "phone") String phone,
            @WebParam(name = "adresse") String adresse, @WebParam(name = "cp") String cp,
            @WebParam(name = "pays") String pays, @WebParam(name = "ville") String ville, @WebParam(name = "complement") String complement) {
        Utilisateursadresses adresses = new Utilisateursadresses();
        adresses.setUtilisateurId(new Utilisateurs(user));
        adresses.setNom(nom);
        adresses.setPrenom(prenom);
        adresses.setTelephone(phone);
        adresses.setAdresse(adresse);
        adresses.setCp(cp);
        adresses.setPays(pays);
        adresses.setVille(ville);
        adresses.setComplement(complement);
        return ejbRef.addLivraisonAdresse(adresses);
    }

    @WebMethod(operationName = "deleteAdresses")
    public int deleteAdresses(@WebParam(name = "id") int id) {
        return ejbRef.deleteAdresses(id);
    }

    @WebMethod(operationName = "SearchAdresseLivraison")
    public Utilisateursadresses SearchAdresseLivraison(@WebParam(name = "id") int id) {
        return ejbRef.SearchAdresseLivraison(id);
    }

    @WebMethod(operationName = "addCommandes")
    public int addCommandes(@WebParam(name = "id") Integer id, @WebParam(name = "valid") Boolean valid, @WebParam(name = "reference") int reference, @WebParam(name = "commandes") String commandes) {
        Commandes cm = new Commandes();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date = sdf.format(new Date());
        String date_sb = date.substring(0, 10);
        String time = date.substring(11, 19);
        String time_ = date.substring(11, 13);
        cm.setUtilisateurId(new Utilisateurs(id));
        cm.setValider(valid);
        cm.setReference(reference);
        cm.setDateCommandes(date_sb);
        cm.setTimesCommandes(time);
        cm.setCommandes(commandes);
        cm.setHeure(time_);
        return ejbRef.addCommandes(cm);
    }

    @WebMethod(operationName = "commandesValider")
    public List<Commandes> commandesValider() {
        return ejbRef.commandesValider();
    }

    @WebMethod(operationName = "DeleteCategories")
    public int DeleteCategories(@WebParam(name = "id") String id) {
        return ejbRef.DeleteCategories(id);
    }

    @WebMethod(operationName = "findCategories")
    public Categories findCategories(@WebParam(name = "id") String id) {
        return ejbRef.findCategories(id);
    }

    @WebMethod(operationName = "edtiCategories")
    @Oneway
    public void edtiCategories(@WebParam(name = "id") String id, @WebParam(name = "idimage") String idimage,
            @WebParam(name = "nom") String nom) {
        Categories cat = new Categories();
        Media media = new Media();
        media.setId(Integer.parseInt(idimage));
        cat.setId(Integer.parseInt(id));
        cat.setImageId(media);
        cat.setNom(nom);
        ejbRef.edtiCategories(cat);
    }

    @WebMethod(operationName = "deleteCategories")
    @Oneway
    public void deleteCategories(@WebParam(name = "id") String id) {
        ejbRef.deleteCategories(id);
    }

    @WebMethod(operationName = "SousCategoriesArray")
    public List<SousCategories> SousCategoriesArray(@WebParam(name = "array") int array) {
        return ejbRef.SousCategoriesArray(array);
    }

    @WebMethod(operationName = "RecuperationCommandes")
    public List<Commandes> RecuperationCommandes(@WebParam(name = "user") int user) {
        return ejbRef.RecuperationCommandes(user);
    }

    @WebMethod(operationName = "AddCategories")
    public void AddCategories(@WebParam(name = "image") String image, String nom) {
        Categories cat = new Categories();
        cat.setNom(nom);
        cat.setImageId(new Media(Integer.parseInt(image)));
        ejbRef.AddCategories(cat);
    }

    @WebMethod(operationName = "ListSousCat")
    public List<SousCategories> ListSousCat() {
        return ejbRef.ListSousCat();
    }

    @WebMethod(operationName = "findSouscat")
    public SousCategories findSouscat(@WebParam(name = "id") String id) {
        return ejbRef.findSouscat(id);
    }

    @WebMethod(operationName = "editSouscat")
    public int editSouscat(@WebParam(name = "id") String id, @WebParam(name = "nom") String nom, @WebParam(name = "cat") String cat) {
        SousCategories souscat = new SousCategories();
        souscat.setId(Integer.parseInt(id));
        souscat.setNom(nom);
        souscat.setCategoriesId(new Categories(Integer.parseInt(cat)));
        return ejbRef.editSouscat(souscat);
    }

    @WebMethod(operationName = "deleteSouscat")
    public int deleteSouscat(@WebParam(name = "id") String id) {
        return ejbRef.deleteSouscat(id);
    }

    @WebMethod(operationName = "addSouscat")
    public int addSouscat(@WebParam(name = "nom") String nom, @WebParam(name = "cat") String cat) {
        SousCategories souscat = new SousCategories();
        souscat.setNom(nom);
        souscat.setCategoriesId(new Categories(Integer.parseInt(cat)));
        return ejbRef.addSouscat(souscat);
    }

    @WebMethod(operationName = "getAllMedia")
    public List<Media> getAllMedia() {
        return ejbRef.getAllMedia();
    }

    @WebMethod(operationName = "AddMedia")
    public int AddMedia(@WebParam(name = "path") String path, @WebParam(name = "alt") String alt) {
        Media media = new Media();
        media.setAlt(alt);
        media.setPath(path);
        return ejbRef.AddMedia(media);
    }

    @WebMethod(operationName = "editMedia")
    public int editMedia(@WebParam(name = "id") String id, @WebParam(name = "path") String path, @WebParam(name = "alt") String alt) {
        Media media = new Media();
        media.setId(Integer.parseInt(id));
        media.setAlt(alt);
        media.setPath(path);
        return ejbRef.editMedia(media);
    }

    @WebMethod(operationName = "deleteMedia")
    public int deleteMedia(@WebParam(name = "id") String id) {
        return ejbRef.deleteMedia(id);
    }

    @WebMethod(operationName = "searchMedia")
    public Media searchMedia(@WebParam(name = "id") String id) {
        return ejbRef.searchMedia(id);
    }

    @WebMethod(operationName = "getAllCategoriesAdmin")
    public List<Categories> getAllCategoriesAdmin(@WebParam(name = "debut") int debut) {
        return ejbRef.getAllCategoriesAdmin(debut);
    }

    @WebMethod(operationName = "AddProduits")
    public int AddProduits(@WebParam(name = "image") String image, @WebParam(name = "tva") String tva,
            @WebParam(name = "cat") String cat, @WebParam(name = "nom") String nom,
            @WebParam(name = "desc") String desc, @WebParam(name = "prix") String prix,
            @WebParam(name = "disp") String dispo) {
        Produit produits = new Produit();
        produits.setCategorieId(new SousCategories(Integer.parseInt(cat)));
        produits.setDescription(desc);
        produits.setDisponible(Short.parseShort(dispo));
        produits.setImageId(new Media(Integer.parseInt(image)));
        produits.setTvaId(new Tva(Integer.parseInt(tva)));
        produits.setPrix(Double.parseDouble(prix));
        produits.setNom(nom);
        return ejbRef.AddProduits(produits);
    }

    @WebMethod(operationName = "editProduits")
    public int editProduits(@WebParam(name = "id") String id, @WebParam(name = "image") String image, @WebParam(name = "tva") String tva,
            @WebParam(name = "cat") String cat, @WebParam(name = "nom") String nom,
            @WebParam(name = "desc") String desc, @WebParam(name = "prix") String prix,
            @WebParam(name = "disp") String dispo) {
        Produit produits = new Produit();
        produits.setCategorieId(new SousCategories(Integer.parseInt(cat)));
        produits.setDescription(desc);
        produits.setDisponible(Short.parseShort(dispo));
        produits.setImageId(new Media(Integer.parseInt(image)));
        produits.setTvaId(new Tva(Integer.parseInt(tva)));
        produits.setPrix(Double.parseDouble(prix));
        produits.setNom(nom);
        produits.setId(Integer.parseInt(id));
        return ejbRef.editProduits(produits);
    }

    @WebMethod(operationName = "FindProduit")
    public Produit FindProduit(@WebParam(name = "id") String id) {
        return ejbRef.FindProduit(id);
    }

    @WebMethod(operationName = "DeleteProduits")
    public int DeleteProduits(@WebParam(name = "id") String id) {
        return ejbRef.DeleteProduits(id);
    }

    @WebMethod(operationName = "getAllProduits_")
    public List<Produit> getAllProduits_() {
        return ejbRef.getAllProduits_();
    }

    @WebMethod(operationName = "SearchCommandesDetails")
    public Commandes SearchCommandesDetails(@WebParam(name = "id") String id) {
        return ejbRef.SearchCommandesDetails(id);
    }

    @WebMethod(operationName = "editCommandes")
    public int editCommandes(@WebParam(name = "id") String id, @WebParam(name = "valid") Boolean valid) {
        Commandes commandes = new Commandes();
        commandes.setId(Integer.parseInt(id));
        commandes.setValider(valid);
        return ejbRef.editCommandes(commandes);
    }

    @WebMethod(operationName = "deleteCommandes")
    public int deleteCommandes(@WebParam(name = "id") int id) {
        return ejbRef.deleteCommandes(id);
    }

    @WebMethod(operationName = "AdminVerify")
    public Utilisateurs AdminVerify(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        return ejbRef.AdminVerify(login, password);
    }

    @WebMethod(operationName = "countCommandes")
    public String countCommandes() {
        return ejbRef.countCommandes();
    }

    @WebMethod(operationName = "AdresseLivraisons")
    public Utilisateursadresses AdresseLivraisons(@WebParam(name = "id") String id) {
        return ejbRef.AdresseLivraisons(id);
    }

    @WebMethod(operationName = "AdressesFacturations")
    public Utilisateursadresses AdressesFacturations(@WebParam(name = "id") String id) {
        return ejbRef.AdressesFacturations(id);
    }

    @WebMethod(operationName = "getNameUserAdresses")
    public Utilisateursadresses getNameUserAdresses(@WebParam(name = "id") String id) {
        return ejbRef.getNameUserAdresses(id);
    }

    @WebMethod(operationName = "findCommands")
    public Commandes findCommands(@WebParam(name = "id") String id) {
        return ejbRef.findCommands(id);
    }

    @WebMethod(operationName = "countJCommandes")
    public String countJCommandes() {
        return ejbRef.countJCommandes();
    }
}
