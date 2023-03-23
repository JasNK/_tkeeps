package com.tkeeps.service.impl;

import com.tkeeps.config.JPAConfig;
import com.tkeeps.entity.Manager;
import com.tkeeps.mapper.ManagerMapper;
import com.tkeeps.mapper.impl.ManagerMapperImpl;
import com.tkeeps.repository.ManagerRepo;
import com.tkeeps.service.interfaces.ManagerService;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepo repo;
    private final ManagerMapper mapper;

    public ManagerServiceImpl() {
        this.repo = new ManagerRepo(JPAConfig.getEntityManager());
        this.mapper = new ManagerMapperImpl();
    }

    @Override
    public List<Manager> retrieveManagerList() {
        return repo.retrieveManagerList();
    }

    @Override
    public Manager findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Manager createManager(Manager manager) {
        return repo.createManager(manager);
    }

    @Override
    public Manager updateManager(Manager manager) {
        return repo.updateManager(manager);
    }

    @Override
    public String deleteManager(Manager manager) {
        repo.deleteManager(manager);
        return "Manager deleted";
    }

}
