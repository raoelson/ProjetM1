/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.Entities.Categories;
import com.Entities.Commandes;
import com.Entities.Media;
import com.Entities.Pages;
import com.Entities.Produit;
import com.Entities.SousCategories;
import com.Entities.Tva;
import com.Entities.Utilisateurs;
import com.Entities.Utilisateursadresses;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author Djazz Jah
 */
@Local
public interface CommandsDao {

    List<Pages> getAllPages();

    List<Produit> getAllProduits();

    List<Categories> getAllCategories();

    List<Tva> getAllTva();

    List<Commandes> getAllCommandes();

    List<Utilisateurs> getAllUtilisateurs();

    List<Utilisateursadresses> getAllUtilisateursadresses();

    Produit SearchProduits(int id);

    List<Produit> ComparaisonProduits(int id, String idcategorie);

    List<Produit> SearchCategories(String id);

    List<Produit> ProduitsArray(List<String> array);

    Utilisateurs verificationUser(String login, String password);

    List<Utilisateursadresses> AdresseLivraison(int id);

    int addLivraisonAdresse(Utilisateursadresses adresses);

    int deleteAdresses(int id);

    Utilisateursadresses SearchAdresseLivraison(int id);

    int addCommandes(Commandes data);

    List<Commandes> commandesValider();

    int DeleteCategories(String id);

    Categories findCategories(String id);

    void edtiCategories(Categories cat);

    void deleteCategories(String id);

    List<SousCategories> SousCategoriesArray(int array);

    List<Commandes> RecuperationCommandes(int user);

    void AddCategories(Categories cat);

    List<SousCategories> ListSousCat();

    SousCategories findSouscat(String id);

    int editSouscat(SousCategories sous);

    int deleteSouscat(String id);

    int addSouscat(SousCategories sous);

    List<Media> getAllMedia();

    int AddMedia(Media media);

    int editMedia(Media media);

    int deleteMedia(String id);

    Media searchMedia(String id);

    List<Categories> getAllCategoriesAdmin(int debut);

    int AddProduits(Produit produits);

    int editProduits(Produit produits);

    Produit FindProduit(String id);

    int DeleteProduits(String id);

    List<Produit> getAllProduits_();

    Commandes SearchCommandesDetails(String id);

    int editCommandes(Commandes commandes);

    int deleteCommandes(int id);

    Utilisateurs AdminVerify(String login, String password);

    String countCommandes();

    Utilisateursadresses AdresseLivraisons(String id);

    Utilisateursadresses AdressesFacturations(String id);

    Utilisateursadresses getNameUserAdresses(String id);

    Commandes findCommands(String id);

    String countJCommandes();
    
}
