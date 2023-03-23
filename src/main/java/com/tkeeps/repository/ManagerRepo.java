package com.tkeeps.repository;


import com.tkeeps.entity.Manager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ManagerRepo {

    private EntityManager entityManager;

    public ManagerRepo(EntityManager entityManager){
        this.entityManager = entityManager  ;
    }

    public Manager createManager(Manager manager){
        entityManager.getTransaction().begin();
        entityManager.merge(manager);
        entityManager.getTransaction().commit();
        return manager;
    }
    
    public List<Manager> retrieveManagerList() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT m FROM Manager m";
        TypedQuery<Manager> query = entityManager.createQuery(jpql, Manager.class);
        List<Manager> managerList = query.getResultList();
        entityManager.getTransaction().commit();
        return managerList;
    }

    public Manager findById(int id) {
        entityManager.getTransaction().begin();
        Manager manager = entityManager.find(Manager.class, id);
        entityManager.getTransaction().commit();
        return manager;
    }

    public Manager updateManager(Manager manager){
        entityManager.getTransaction().begin();
        entityManager.merge(manager);
        entityManager.getTransaction().commit();
        return manager;
    }

    public void deleteManager(Manager manager){
        entityManager.getTransaction().begin();
        Manager managerId = entityManager.find(Manager.class, manager.getId());
        entityManager.remove(managerId);
        entityManager.getTransaction().commit();
    }
}
