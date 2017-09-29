/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DjazzJah
 */
@Entity
@Table(name = "sortie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sortie.findAll", query = "SELECT s FROM Sortie s"),
    @NamedQuery(name = "Sortie.findByIdSorti", query = "SELECT s FROM Sortie s WHERE s.idSorti = :idSorti"),
    @NamedQuery(name = "Sortie.findByQte", query = "SELECT s FROM Sortie s WHERE s.qte = :qte"),
    @NamedQuery(name = "Sortie.findByDateSorti", query = "SELECT s FROM Sortie s WHERE s.dateSorti = :dateSorti")})
public class Sortie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sorti")
    private Integer idSorti;
    @Basic(optional = false)
    @Column(name = "qte")
    private int qte;
    @Basic(optional = false)
    @Column(name = "date_sorti")
    private String dateSorti;
    @JoinColumn(name = "id_prod", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produit idProd;

    public Sortie() {
    }

    public Sortie(Integer idSorti) {
        this.idSorti = idSorti;
    }

    public Sortie(Integer idSorti, int qte, String dateSorti) {
        this.idSorti = idSorti;
        this.qte = qte;
        this.dateSorti = dateSorti;
    }

    public Integer getIdSorti() {
        return idSorti;
    }

    public void setIdSorti(Integer idSorti) {
        this.idSorti = idSorti;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getDateSorti() {
        return dateSorti;
    }

    public void setDateSorti(String dateSorti) {
        this.dateSorti = dateSorti;
    }

    public Produit getIdProd() {
        return idProd;
    }

    public void setIdProd(Produit idProd) {
        this.idProd = idProd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSorti != null ? idSorti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sortie)) {
            return false;
        }
        Sortie other = (Sortie) object;
        if ((this.idSorti == null && other.idSorti != null) || (this.idSorti != null && !this.idSorti.equals(other.idSorti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Sortie[ idSorti=" + idSorti + " ]";
    }
    
}
