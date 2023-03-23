package com.tkeeps.repository;

import com.tkeeps.entity.Equipment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EquipmentRepo {
    private EntityManager entityManager;

    public EquipmentRepo(EntityManager entityManager){
        this.entityManager = entityManager  ;
    }

    public Equipment createEquipment(Equipment equipment) {
        entityManager.getTransaction().begin();
        entityManager.merge(equipment);
        entityManager.getTransaction().commit();
        return equipment;
    }

    public List<Equipment> retrieveEquipmentList() {
        entityManager.getTransaction().begin();
        String jpql = "SELECT m FROM Equipment m";
        TypedQuery<Equipment> query = entityManager.createQuery(jpql, Equipment.class);
        List<Equipment> equipmentList = query.getResultList();
        entityManager.getTransaction().commit();
        return equipmentList;
    }

    public Equipment findById(int id) {
        entityManager.getTransaction().begin();
        Equipment equipment = entityManager.find(Equipment.class, id);
        entityManager.getTransaction().commit();
        return equipment;
    }

    public Equipment updateEquipment(Equipment equipment){
        entityManager.getTransaction().begin();
        entityManager.merge(equipment);
        entityManager.getTransaction().commit();
        return equipment;
    }

    public void deleteEquipment(Equipment equipment){
        entityManager.getTransaction().begin();
        Equipment equipmentId = entityManager.find(Equipment.class, equipment.getId());
        entityManager.remove(equipmentId);
        entityManager.getTransaction().commit();
    }

}
