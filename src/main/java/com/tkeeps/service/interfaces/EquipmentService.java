package com.tkeeps.service.interfaces;

import com.tkeeps.entity.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> retrieveEquipmentList();
    Equipment createEquipment(Equipment equipment);

    Equipment findById(int id);

    String deleteEquipment(Equipment equipment);

    Equipment updateEquipment(Equipment equipment);
}
