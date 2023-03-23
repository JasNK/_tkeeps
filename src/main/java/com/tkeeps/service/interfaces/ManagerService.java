package com.tkeeps.service.interfaces;

import com.tkeeps.entity.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager> retrieveManagerList();
    Manager createManager(Manager manager);

    Manager findById(int id);

    String deleteManager(Manager manager);

    Manager updateManager(Manager manager);
}
