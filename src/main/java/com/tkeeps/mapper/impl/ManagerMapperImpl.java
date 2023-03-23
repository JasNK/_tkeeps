package com.tkeeps.mapper.impl;

import com.tkeeps.dto.ManagerDto;
import com.tkeeps.entity.Manager;
import com.tkeeps.mapper.ManagerMapper;

import java.util.ArrayList;
import java.util.List;

public class ManagerMapperImpl implements ManagerMapper {
    public Manager managerDtoToManager(ManagerDto managerDto){
        return new Manager
                .ManagerBuilder()
                .id(managerDto.getId())
                .naam(managerDto.getNaam())
                .gebDatum(managerDto.getGebDatum())
                .beschrijving(managerDto.getBeschrijving())
//                .locatiesById(managerDto.getLocatiesById())
                .build();
    }

    public ManagerDto managerToManagerDto(Manager manager){
        return new ManagerDto
                .ManagerDtoBuilder()
                .id(manager.getId())
                .naam(manager.getNaam())
                .gebDatum(manager.getGebDatum())
                .beschrijving(manager.getBeschrijving())
//                .locatiesById(manager.getLocatiesById())
                .build();
    }

    public List<Manager> managerDtoToManagerList(List<ManagerDto> dtoList) {
        List<Manager> managerList = new ArrayList<>();

        for (ManagerDto managerDto : dtoList) {
            managerList.add(managerDtoToManager(managerDto));
        }

        return managerList;
    }

    public List<ManagerDto> managerToManagerDtoList(List<Manager> list) {
        List<ManagerDto> managerList = new ArrayList<>();

        for (Manager manager: list) {
            managerList.add(managerToManagerDto(manager));
        }
        return managerList;
    }
}
