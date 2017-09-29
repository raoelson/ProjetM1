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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sous_categories", catalog = "gesitoncommande_ligne", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SousCategories.findAll", query = "SELECT s FROM SousCategories s ORDER BY s.id DESC"),
    @NamedQuery(name = "SousCategories.findById", query = "SELECT s FROM SousCategories s WHERE s.id = :id"),
    @NamedQuery(name = "SousCategories.findByNom", query = "SELECT s FROM SousCategories s WHERE s.nom = :nom")})
public class SousCategories implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieId")
    private Collection<Produit> produitCollection;
    @JoinColumn(name = "categories_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Categories categoriesId;

    public SousCategories() {
    }

    public SousCategories(Integer id) {
        this.id = id;
    }

    public SousCategories(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
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

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    public Categories getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(Categories categoriesId) {
        this.categoriesId = categoriesId;
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
        if (!(object instanceof SousCategories)) {
            return false;
        }
        SousCategories other = (SousCategories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entities.SousCategories[ id=" + id + " ]";
    }
    
}
