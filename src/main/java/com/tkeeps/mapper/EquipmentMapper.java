package com.tkeeps.mapper;

import com.tkeeps.dto.EquipmentDto;
import com.tkeeps.entity.Equipment;

public interface EquipmentMapper {
    Equipment equipmentDtoToEquipment(EquipmentDto equipmentdto);
    EquipmentDto equipmentToEquipmentDto(Equipment equipment);

}
