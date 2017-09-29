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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Djazz Jah
 */
@Stateless
public class CommandsImp implements CommandsDao {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   @PersistenceContext
   private EntityManager em;

    @Override
    public List<Pages> getAllPages() {
        return em.createNamedQuery("Pages.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public List<Produit> getAllProduits() {
        return em.createQuery("SELECT p FROM Produit p ORDER BY p.id DESC").getResultList();
    }

    @Override
    public List<Categories> getAllCategories() {
        return em.createNamedQuery("Categories.findAll").getResultList();
    }
    
    @Override
    public List<Tva> getAllTva() {
        return em.createNamedQuery("Tva.findAll").getResultList();
    }

    @Override
    public List<Commandes> getAllCommandes() {
        return em.createNamedQuery("Commandes.findAll").getResultList();
    }

    @Override
    public List<Media> getAllMedia() {
        return em.createNamedQuery("Media.findAll").getResultList();
    }

    @Override
    public List<Utilisateurs> getAllUtilisateurs() {
        return em.createNamedQuery("Utilisateurs.findAll").getResultList();
    }

    @Override
    public List<Utilisateursadresses> getAllUtilisateursadresses() {
        return em.createNamedQuery("Utilisateursadresses.findAll").getResultList();
    }

    @Override
    public Produit SearchProduits(int id) {
        return em.find(Produit.class, id);
    }

    @Override
    public List<Produit> ComparaisonProduits(int id, String idcategorie) {
        SousCategories categorie = new SousCategories(Integer.parseInt(idcategorie));
        Query query = em.createQuery("SELECT p FROM Produit p WHERE   p.id <>:id and p.disponible = true and p.categorieId =:categories");
        query.setParameter("id", id);
        query.setParameter("categories", categorie);
        return query.getResultList();
    }

    @Override
    public List<Produit> SearchCategories(String id) {
        SousCategories categories = new SousCategories (Integer.parseInt(id));
        Query query = em.createQuery("SELECT p FROM Produit p WHERE  p.disponible = true and p.categorieId=:categories");
        query.setParameter("categories", categories);
        return query.getResultList();
    }

    @Override
    public List<Produit> ProduitsArray(List<String> array) {
        Query query = null;
        List<Produit> produits = new ArrayList<Produit>();

        for (String id : array) {
            Produit prod = new Produit();
            query = em.createNamedQuery("Produit.findById");
            query.setParameter("id", Integer.parseInt(id));
            Iterator it = query.getResultList().iterator();
            while (it.hasNext()) {
                Produit object = (Produit) it.next();
                prod.setCategorieId(object.getCategorieId());
                prod.setDescription(object.getDescription());
                prod.setDisponible(object.getDisponible());
                prod.setId(object.getId());
                prod.setImageId(object.getImageId());
                prod.setNom(object.getNom());
                prod.setPrix(object.getPrix());
                prod.setTvaId(object.getTvaId());
            }
            produits.add(prod);
        }
        return produits;
    }

    @Override
    public Utilisateurs verificationUser(String login, String password) {
        Encryptages encre = new Encryptages();
        Utilisateurs user = new Utilisateurs();
        Query query = em.createQuery("SELECT u FROM Utilisateurs u WHERE u.username = :username AND u.password = :password and u.enabled=1");
        query.setParameter("username", login);
        query.setParameter("password", encre.SHAConverter(password));
        Iterator it = query.getResultList().iterator();
        while (it.hasNext()) {
            Utilisateurs object = (Utilisateurs) it.next();
            if (object != null) {
                user.setUsername(object.getUsername());
                user.setId(object.getId());
            }
        }
        return user;
    }

    @Override
    public List<Utilisateursadresses> AdresseLivraison(int id) {
        Utilisateurs ut = new Utilisateurs(id);
        List<Utilisateursadresses> user = new ArrayList<Utilisateursadresses>();
        Query query = em.createQuery("SELECT u FROM Utilisateursadresses u where u.utilisateurId=:utilisateur");
        query.setParameter("utilisateur", ut);
        return query.getResultList();
    }

    @Override
    public int addLivraisonAdresse(Utilisateursadresses adresses) {
        Utilisateursadresses livraison = new Utilisateursadresses();
        livraison.setNom(adresses.getNom());
        livraison.setPrenom(adresses.getPrenom());
        livraison.setAdresse(adresses.getAdresse());
        livraison.setCp(adresses.getCp());
        livraison.setUtilisateurId(adresses.getUtilisateurId()); 
        livraison.setVille(adresses.getVille());
        livraison.setTelephone(adresses.getTelephone());
        livraison.setPays(adresses.getPays());
        System.out.println(livraison);
        em.persist(livraison);
        return 1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteAdresses(int id) {
        em.remove(em.find(Utilisateursadresses.class, id));
        return 1;
    }

    @Override
    public Utilisateursadresses SearchAdresseLivraison(int id) {
        return em.find(Utilisateursadresses.class, id);
    }

    @Override
    public int addCommandes(Commandes data) {    
        System.out.println(data.getHeure());
        em.persist(data);
        return 1;
    }

    @Override
    public List<Commandes> commandesValider() {
        Query query = em.createNamedQuery("Commandes.findByValider");
        query.setParameter("valider", true);
        return query.getResultList();
    }   
    @Override
    public int DeleteCategories(String id) {
        em.remove(em.find(Categories.class, Integer.parseInt(id)));
        return 0;
    }

    @Override
    public Categories findCategories(String id) {
        return em.find(Categories.class, Integer.parseInt(id));
    }

    @Override
    public void edtiCategories(Categories cat) {
        em.merge(cat);
    }

    @Override
    public void deleteCategories(String id) {
        em.remove(em.find(Categories.class, Integer.parseInt(id)));
    }

    @Override
    public List<SousCategories> SousCategoriesArray(int array) {        
        Query query = null;
        Categories cat = new Categories((array));
        query = em.createQuery("SELECT s FROM SousCategories s WHERE s.categoriesId = :categoriesId ");
        query.setParameter("categoriesId", cat);
        return query.getResultList();
    }

    @Override
    public List<Commandes> RecuperationCommandes(int user) {   
        //System.out.println(user);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date_ = sdf.format(new Date());
        Query query = em.createQuery("SELECT c FROM Commandes c WHERE c.utilisateurId =:utilisateurId ORDER BY c.dateCommandes DESC");
        Utilisateurs ut = new Utilisateurs(user);
        query.setParameter("utilisateurId", ut); 
        //query.setParameter("date", new Date()); 
        List<Commandes> cm = new ArrayList<Commandes>();
        
        Iterator it =query.getResultList().iterator();
        Commandes ob;
        while (it.hasNext()) {
             ob = new Commandes();
            Commandes object = (Commandes) it.next();
            String date = object.getDateCommandes();
            String date_sub = date.substring(0, 10);            
            if(date_sub.equalsIgnoreCase(date_)){
               ob.setId(object.getId());
               ob.setCommandes(object.getCommandes());
               ob.setReference(object.getReference());
               ob.setValider(object.getValider());
               ob.setUtilisateurId(object.getUtilisateurId());
               ob.setDateCommandes(object.getDateCommandes());
               cm.add(ob);
            }            
        }
        
        return cm;
    } 

    @Override
    public void AddCategories(Categories cat) {
        em.persist(cat);
    }

    @Override
    public List<SousCategories> ListSousCat() {
        return em.createNamedQuery("SousCategories.findAll").getResultList();
    }

    @Override
    public SousCategories findSouscat(String id) {
        return em.find(SousCategories.class, Integer.parseInt(id));
    }

    @Override
    public int editSouscat(SousCategories sous) {
        em.merge(sous);
        return 1;
    }

    @Override
    public int deleteSouscat(String id) {
        em.remove(em.find(SousCategories.class, Integer.parseInt(id)));
        return 1;
    }

    @Override
    public int addSouscat(SousCategories sous) {
        em.persist(sous);
        return 0;
    }

    @Override
    public int AddMedia(Media media) {
        em.persist(media);
        return 1;
    }

    @Override
    public int editMedia(Media media) {
        em.merge(media);
        return 0;
    }

    @Override
    public int deleteMedia(String id) {
        em.remove(searchMedia(id));
        return 0;
    }

    @Override
    public Media searchMedia(String id) {
        return em.find(Media.class, Integer.parseInt(id));
    }

    @Override
    public List<Categories> getAllCategoriesAdmin(int debut) {
        Query query = em.createNamedQuery("Categories.findAll");
        query.setFirstResult(debut);
        query.setMaxResults(2);
        return query.getResultList();
    }

    @Override
    public int AddProduits(Produit produits) {
        em.persist(produits);
        return 0;
    }

    @Override
    public int editProduits(Produit produits) {
        em.merge(produits);
        return 0;
    }

    @Override
    public Produit FindProduit(String id) {        
        return em.find(Produit.class, Integer.parseInt(id));
    }

    @Override
    public int DeleteProduits(String id) {
        em.remove(FindProduit(id));
        return 0;
    }
    
    @Override
    public List<Produit> getAllProduits_() {
        return em.createQuery("SELECT p FROM Produit p WHERE  p.disponible = true ORDER BY p.id DESC").getResultList();
    }

    @Override
    public Commandes SearchCommandesDetails(String id) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String date = sdf.format(new Date());
        Query query = em.createQuery("SELECT c FROM Commandes c WHERE c.utilisateurId = :utilisateurId  ORDER BY c.dateCommandes DESC");
        query.setParameter("utilisateurId", new Utilisateurs(Integer.parseInt(id)));         
        Iterator it = query.getResultList().iterator();
        int i=0;
        Commandes com = new Commandes();
        while (it.hasNext()) {
            Commandes object = (Commandes) it.next();
            if(i==0){
              com.setId(object.getId());
              com.setCommandes(object.getCommandes());
              com.setDateCommandes(object.getDateCommandes());
              com.setReference(object.getReference());
              com.setUtilisateurId(object.getUtilisateurId());
              com.setValider(object.getValider());
              com.setTimesCommandes(object.getTimesCommandes());
            }
            i++;
        }
        return com;        
    }    
    @Override
    public int editCommandes(Commandes commandes) {
        Commandes cm = em.find(Commandes.class, commandes.getId());
        Commandes commandes1 = new Commandes();
        commandes1.setCommandes(cm.getCommandes());
        commandes1.setDateCommandes(cm.getDateCommandes());
        commandes1.setId(cm.getId());
        commandes1.setReference(cm.getReference());
        commandes1.setUtilisateurId(cm.getUtilisateurId());
        commandes1.setValider(commandes.getValider());
        commandes1.setHeure(cm.getHeure());
        commandes1.setTimesCommandes(cm.getTimesCommandes());
        em.merge(commandes1);
        return 0;
    }

    @Override
    public int deleteCommandes(int id) {
        em.remove(em.find(Commandes.class, id));
        return 0;
    }

    @Override
    public Utilisateurs AdminVerify(String login, String password) {
        Encryptages encre = new Encryptages();        
        Utilisateurs user = new Utilisateurs();
        Query query = em.createQuery("SELECT u FROM Utilisateurs u WHERE u.username = :username AND u.password = :password and u.enabled=1 and u.roles='ROLE_ADMIN'");
        query.setParameter("username", login);
        query.setParameter("password", encre.SHAConverter(password));
        Iterator it = query.getResultList().iterator();
        while (it.hasNext()) {
            Utilisateurs object = (Utilisateurs) it.next();
            if (object != null) {
                user.setUsername(object.getUsername());
                user.setId(object.getId());
            }
        }
        return user;        
    }

    @Override
    public String countCommandes() {
        int rep_valider = em.createNamedQuery("Commandes.findByValider").setParameter("valider", true).getResultList().size();
        int rep_non = em.createNamedQuery("Commandes.findByValider").setParameter("valider", false).getResultList().size();
        int rep_ut = em.createNamedQuery("Utilisateurs.findAll").getResultList().size();
        return rep_valider+"/"+rep_non+"/"+rep_ut+"/";
    }

    @Override
    public Utilisateursadresses AdresseLivraisons(String id) {        
        return em.find(Utilisateursadresses.class, Integer.parseInt(id));
    }

    @Override
    public Utilisateursadresses AdressesFacturations(String id) {
        return em.find(Utilisateursadresses.class, Integer.parseInt(id));
    }

    @Override
    public Utilisateursadresses getNameUserAdresses(String id) {                
        return em.find(Utilisateursadresses.class, Integer.parseInt(id));
    }

    @Override
    public Commandes findCommands(String id) {
        return em.find(Commandes.class, Integer.parseInt(id));
    }

    
  
    
    public List<Commandes> comptes(String heures, String date){
        Query query = em.createQuery("SELECT count(c) FROM Commandes c WHERE c.dateCommandes=:dateCommandes AND c.heure=:heure ORDER BY c.heure ASC");
        query.setParameter("dateCommandes", date);
        query.setParameter("heure", heures);
        return query.getResultList();
    }

    @Override
    public String countJCommandes() {
        JSONArray array = new JSONArray();
                JSONObject finalObject = new JSONObject();
                Map<String, Object> data = new HashMap<String, Object>();
                String heures[] = {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"
                , "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
                int i = 0;
                JSONObject j;
                String json = null;
                Date dt = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String cours = sdf.format(dt);                
                for (; i < heures.length; i++) {                     
                    data.put("value", comptes(heures[i], cours));
                    j = new JSONObject(data);
                    array.put(j);
            try {
                finalObject.put("data", array);
            } catch (JSONException ex) {
                Logger.getLogger(CommandsImp.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
                json = array.toString();
        return json;
    }
    
}
