package com.tkeeps.repository;

import com.tkeeps.entity.Categorie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CategorieRepo {
    private final EntityManager entityManager;

    public CategorieRepo(EntityManager entityManager){
        this.entityManager = entityManager  ;
    }
    public List<Categorie> retrieveCategorieList() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT m FROM Categorie m";
        TypedQuery<Categorie> query = entityManager.createQuery(jpql, Categorie.class);
        List<Categorie> categorieList = query.getResultList();
        entityManager.getTransaction().commit();
        return categorieList;
    }

    public Categorie findById(int id) {
        entityManager.getTransaction().begin();
        Categorie categorie = entityManager.find(Categorie.class, id);
        entityManager.getTransaction().commit();
        return categorie;
    }

}
