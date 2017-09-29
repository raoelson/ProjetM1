/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Djazz Jah
 */
@Entity
@Table(name = "tva", catalog = "gesitoncommande_ligne", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tva.findAll", query = "SELECT t FROM Tva t"),
    @NamedQuery(name = "Tva.findById", query = "SELECT t FROM Tva t WHERE t.id = :id"),
    @NamedQuery(name = "Tva.findByMultiplicate", query = "SELECT t FROM Tva t WHERE t.multiplicate = :multiplicate"),
    @NamedQuery(name = "Tva.findByNom", query = "SELECT t FROM Tva t WHERE t.nom = :nom"),
    @NamedQuery(name = "Tva.findByValeur", query = "SELECT t FROM Tva t WHERE t.valeur = :valeur")})
public class Tva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "multiplicate", nullable = false)
    private double multiplicate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nom", nullable = false, length = 120)
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valeur", nullable = false)
    private double valeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tvaId")
    private Collection<Produit> produitCollection;

    public Tva() {
    }

    public Tva(Integer id) {
        this.id = id;
    }

    public Tva(Integer id, double multiplicate, String nom, double valeur) {
        this.id = id;
        this.multiplicate = multiplicate;
        this.nom = nom;
        this.valeur = valeur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMultiplicate() {
        return multiplicate;
    }

    public void setMultiplicate(double multiplicate) {
        this.multiplicate = multiplicate;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
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
        if (!(object instanceof Tva)) {
            return false;
        }
        Tva other = (Tva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entities.Tva[ id=" + id + " ]";
    }
    
}
