/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Djazz Jah
 */
@Entity
@Table(name = "utilisateursadresses", catalog = "gesitoncommande_ligne", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateursadresses.findAll", query = "SELECT u FROM Utilisateursadresses u"),
    @NamedQuery(name = "Utilisateursadresses.findById", query = "SELECT u FROM Utilisateursadresses u WHERE u.id = :id"),
    @NamedQuery(name = "Utilisateursadresses.findByNom", query = "SELECT u FROM Utilisateursadresses u WHERE u.nom = :nom"),
    @NamedQuery(name = "Utilisateursadresses.findByPrenom", query = "SELECT u FROM Utilisateursadresses u WHERE u.prenom = :prenom"),
    @NamedQuery(name = "Utilisateursadresses.findByTelephone", query = "SELECT u FROM Utilisateursadresses u WHERE u.telephone = :telephone"),
    @NamedQuery(name = "Utilisateursadresses.findByAdresse", query = "SELECT u FROM Utilisateursadresses u WHERE u.adresse = :adresse"),
    @NamedQuery(name = "Utilisateursadresses.findByCp", query = "SELECT u FROM Utilisateursadresses u WHERE u.cp = :cp"),
    @NamedQuery(name = "Utilisateursadresses.findByPays", query = "SELECT u FROM Utilisateursadresses u WHERE u.pays = :pays"),
    @NamedQuery(name = "Utilisateursadresses.findByVille", query = "SELECT u FROM Utilisateursadresses u WHERE u.ville = :ville"),
    @NamedQuery(name = "Utilisateursadresses.findByComplement", query = "SELECT u FROM Utilisateursadresses u WHERE u.complement = :complement")})
public class Utilisateursadresses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "telephone", nullable = false, length = 30)
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "adresse", nullable = false, length = 255)
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cp", nullable = false, length = 10)
    private String cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "pays", nullable = false, length = 125)
    private String pays;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 125)
    @Column(name = "ville", nullable = false, length = 125)
    private String ville;
    @Size(max = 255)
    @Column(name = "complement", length = 255)
    private String complement;
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateurs utilisateurId;

    public Utilisateursadresses() {
    }

    public Utilisateursadresses(Integer id) {
        this.id = id;
    }

    public Utilisateursadresses(Integer id, String nom, String prenom, String telephone, String adresse, String cp, String pays, String ville) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.cp = cp;
        this.pays = pays;
        this.ville = ville;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Utilisateurs getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Utilisateurs utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateursadresses)) {
            return false;
        }
        Utilisateursadresses other = (Utilisateursadresses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entities.Utilisateursadresses[ id=" + id + " ]";
    }
    
}
