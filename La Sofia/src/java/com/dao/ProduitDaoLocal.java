/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Produit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author DjazzJah
 */
@Local
public interface ProduitDaoLocal {

    List<Produit> getAll();
    
}
