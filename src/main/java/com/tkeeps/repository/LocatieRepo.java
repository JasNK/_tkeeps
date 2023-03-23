package com.tkeeps.repository;

import com.tkeeps.entity.Locatie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LocatieRepo {
    private EntityManager entityManager;

    public LocatieRepo(EntityManager entityManager){
        this.entityManager = entityManager  ;
    }

    public Locatie createLocatie(Locatie locatie){
        entityManager.getTransaction().begin();
        entityManager.merge(locatie);
        entityManager.getTransaction().commit();
        return locatie;
    }

    public List<Locatie> retrieveLocatieList() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT m FROM Locatie m";
        TypedQuery<Locatie> query = entityManager.createQuery(jpql, Locatie.class);
        List<Locatie> locatieList = query.getResultList();
        entityManager.getTransaction().commit();
        return locatieList;
    }

    public Locatie findById(int id) {
        entityManager.getTransaction().begin();
        Locatie locatie = entityManager.find(Locatie.class, id);
        entityManager.getTransaction().commit();
        return locatie;
    }

    public Locatie updateLocatie(Locatie locatie){
        entityManager.getTransaction().begin();
        entityManager.merge(locatie);
        entityManager.getTransaction().commit();
        return locatie;
    }

    public void deleteLocatie(Locatie locatie){
        entityManager.getTransaction().begin();
        Locatie locatieId = entityManager.find(Locatie.class, locatie.getId());
        entityManager.remove(locatieId);
        entityManager.getTransaction().commit();
    }
}
