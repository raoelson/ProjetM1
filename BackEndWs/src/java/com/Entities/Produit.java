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
@Table(name = "produit", catalog = "gesitoncommande_ligne", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p ORDER BY p.id DESC"),
    @NamedQuery(name = "Produit.findById", query = "SELECT p FROM Produit p WHERE p.id = :id"),
    @NamedQuery(name = "Produit.findByNom", query = "SELECT p FROM Produit p WHERE p.nom = :nom"),
    @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix"),
    @NamedQuery(name = "Produit.findByDisponible", query = "SELECT p FROM Produit p WHERE p.disponible = :disponible")})
public class Produit implements Serializable {
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
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description", nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix", nullable = false)
    private double prix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponible", nullable = false)
    private short disponible;
    @JoinColumn(name = "categorie_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private SousCategories categorieId;
    @JoinColumn(name = "tva_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Tva tvaId;
    @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Media imageId;

    public Produit() {
    }

    public Produit(Integer id) {
        this.id = id;
    }

    public Produit(Integer id, String nom, String description, double prix, short disponible) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.disponible = disponible;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public short getDisponible() {
        return disponible;
    }

    public void setDisponible(short disponible) {
        this.disponible = disponible;
    }

    public SousCategories getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(SousCategories categorieId) {
        this.categorieId = categorieId;
    }

    public Tva getTvaId() {
        return tvaId;
    }

    public void setTvaId(Tva tvaId) {
        this.tvaId = tvaId;
    }

    public Media getImageId() {
        return imageId;
    }

    public void setImageId(Media imageId) {
        this.imageId = imageId;
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
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entities.Produit[ id=" + id + " ]";
    }
    
}
