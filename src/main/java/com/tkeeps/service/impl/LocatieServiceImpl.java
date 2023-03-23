package com.tkeeps.service.impl;

import com.tkeeps.config.JPAConfig;
import com.tkeeps.entity.Locatie;
import com.tkeeps.repository.LocatieRepo;
import com.tkeeps.service.interfaces.LocatieService;

import java.util.List;

public class LocatieServiceImpl implements LocatieService {
    private final LocatieRepo repo;

    public LocatieServiceImpl() {
        this.repo = new LocatieRepo(JPAConfig.getEntityManager());
    }

    @Override
    public List<Locatie> retrieveLocatieList() {
        return repo.retrieveLocatieList();
    }

    @Override
    public Locatie findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Locatie createLocatie(Locatie locatie) {
        return repo.createLocatie(locatie);
    }

    @Override
    public Locatie updateLocatie(Locatie locatie) {
        return repo.updateLocatie(locatie);
    }

    @Override
    public String deleteLocatie(Locatie locatie) {
        repo.deleteLocatie(locatie);
        return "Locatie deleted";
    }
}
