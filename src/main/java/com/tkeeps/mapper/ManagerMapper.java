package com.tkeeps.mapper;

import com.tkeeps.entity.Manager;
import com.tkeeps.dto.ManagerDto;

import java.util.List;

public interface ManagerMapper {
    Manager managerDtoToManager (ManagerDto managerDto);
    ManagerDto managerToManagerDto(Manager manager);
    List<ManagerDto> managerToManagerDtoList(List<Manager> list);
    List<Manager> managerDtoToManagerList(List<ManagerDto> list);
}
