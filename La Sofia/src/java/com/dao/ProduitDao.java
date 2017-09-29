/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Produit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DjazzJah
 */
@Stateless
public class ProduitDao implements ProduitDaoLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Produit> getAll() {
        return em.createNamedQuery("Produit.findAll").getResultList();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
