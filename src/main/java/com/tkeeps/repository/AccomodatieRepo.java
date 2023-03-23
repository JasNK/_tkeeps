package com.tkeeps.repository;

import com.tkeeps.entity.Accomodatie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AccomodatieRepo {
    private EntityManager entityManager;

    public AccomodatieRepo(EntityManager entityManager){
        this.entityManager = entityManager  ;
    }

    public Accomodatie createAccomodatie(Accomodatie accomodatie){
        entityManager.getTransaction().begin();
        entityManager.merge(accomodatie);
        entityManager.getTransaction().commit();
        return accomodatie;
    }

    public List<Accomodatie> retrieveAccomodatieList() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT m FROM Accomodatie m";
        TypedQuery<Accomodatie> query = entityManager.createQuery(jpql, Accomodatie.class);
        List<Accomodatie> accomodatieList = query.getResultList();
        entityManager.getTransaction().commit();
        return accomodatieList;
    }

    public Accomodatie findById(int id) {
        entityManager.getTransaction().begin();
        Accomodatie accomodatie = entityManager.find(Accomodatie.class, id);
        entityManager.getTransaction().commit();
        return accomodatie;
    }

    public Accomodatie updateAccomodatie(Accomodatie accomodatie){
        entityManager.getTransaction().begin();
        entityManager.merge(accomodatie);
        entityManager.getTransaction().commit();
        return accomodatie;
    }

    public void deleteAccomodatie(Accomodatie accomodatie){
        entityManager.getTransaction().begin();
        Accomodatie accomodatieId = entityManager.find(Accomodatie.class, accomodatie.getId());
        entityManager.remove(accomodatieId);
        entityManager.getTransaction().commit();
    }
}
