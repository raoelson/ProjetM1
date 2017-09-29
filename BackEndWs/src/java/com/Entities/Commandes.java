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
import javax.persistence.Lob;
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
@Table(name = "commandes", catalog = "gesitoncommande_ligne", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commandes.findAll", query = "SELECT c FROM Commandes c ORDER BY c.dateCommandes DESC"),
    @NamedQuery(name = "Commandes.findById", query = "SELECT c FROM Commandes c WHERE c.id = :id  ORDER BY c.dateCommandes DESC"),
    @NamedQuery(name = "Commandes.findByValider", query = "SELECT c FROM Commandes c WHERE c.valider = :valider ORDER BY c.dateCommandes DESC"),
    @NamedQuery(name = "Commandes.findByDateCommandes", query = "SELECT c FROM Commandes c WHERE c.dateCommandes = :dateCommandes"),
    @NamedQuery(name = "Commandes.findByTimesCommandes", query = "SELECT c FROM Commandes c WHERE c.timesCommandes = :timesCommandes"),
    @NamedQuery(name = "Commandes.findByHeure", query = "SELECT c FROM Commandes c WHERE c.heure = :heure"),
    @NamedQuery(name = "Commandes.findByReference", query = "SELECT c FROM Commandes c WHERE c.reference = :reference")})
public class Commandes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valider", nullable = false)
    private boolean valider;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "date_commandes", nullable = false, length = 100)
    private String dateCommandes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "times_commandes", nullable = false, length = 40)
    private String timesCommandes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "heure", nullable = false, length = 10)
    private String heure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reference", nullable = false)
    private int reference;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "commandes", nullable = false, length = 2147483647)
    private String commandes;
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateurs utilisateurId;

    public Commandes() {
    }

    public Commandes(Integer id) {
        this.id = id;
    }

    public Commandes(Integer id, boolean valider, String dateCommandes, String timesCommandes, String heure, int reference, String commandes) {
        this.id = id;
        this.valider = valider;
        this.dateCommandes = dateCommandes;
        this.timesCommandes = timesCommandes;
        this.heure = heure;
        this.reference = reference;
        this.commandes = commandes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }

    public String getDateCommandes() {
        return dateCommandes;
    }

    public void setDateCommandes(String dateCommandes) {
        this.dateCommandes = dateCommandes;
    }

    public String getTimesCommandes() {
        return timesCommandes;
    }

    public void setTimesCommandes(String timesCommandes) {
        this.timesCommandes = timesCommandes;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getCommandes() {
        return commandes;
    }

    public void setCommandes(String commandes) {
        this.commandes = commandes;
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
        if (!(object instanceof Commandes)) {
            return false;
        }
        Commandes other = (Commandes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entities.Commandes[ id=" + id + " ]";
    }
    
}
