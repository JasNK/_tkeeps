package com.tkeeps.service.impl;

import com.tkeeps.config.JPAConfig;
import com.tkeeps.entity.Equipment;
import com.tkeeps.repository.EquipmentRepo;
import com.tkeeps.service.interfaces.EquipmentService;

import java.util.List;

public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepo repo;

    public EquipmentServiceImpl() {
        this.repo = new EquipmentRepo(JPAConfig.getEntityManager());
    }

    @Override
    public List<Equipment> retrieveEquipmentList() {
        return repo.retrieveEquipmentList();
    }

    @Override
    public Equipment findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Equipment createEquipment(Equipment equipment) {
        return repo.createEquipment(equipment);
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        return repo.updateEquipment(equipment);
    }

    @Override
    public String deleteEquipment(Equipment equipment) {
        repo.deleteEquipment(equipment);
        return "Equipment deleted";
    }
}
