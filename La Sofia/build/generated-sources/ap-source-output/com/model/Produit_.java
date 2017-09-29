package com.model;

import com.model.Sortie;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2015-09-06T01:34:11")
@StaticMetamodel(Produit.class)
public class Produit_ { 

    public static volatile SingularAttribute<Produit, Integer> id;
    public static volatile CollectionAttribute<Produit, Sortie> sortieCollection;
    public static volatile SingularAttribute<Produit, Integer> prixProd;
    public static volatile SingularAttribute<Produit, String> nomProd;

}