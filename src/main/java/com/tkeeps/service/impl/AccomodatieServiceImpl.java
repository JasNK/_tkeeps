package com.tkeeps.service.impl;

import com.tkeeps.config.JPAConfig;
import com.tkeeps.entity.Accomodatie;
import com.tkeeps.repository.AccomodatieRepo;
import com.tkeeps.service.interfaces.AccomodatieService;

import java.util.List;

public class AccomodatieServiceImpl implements AccomodatieService {
    private final AccomodatieRepo repo;

    public AccomodatieServiceImpl() {
        this.repo = new AccomodatieRepo(JPAConfig.getEntityManager());
    }
    
    @Override
    public List<Accomodatie> retrieveAccomodatieList() {
        return repo.retrieveAccomodatieList();
    }

    @Override
    public Accomodatie findById(int id) {
        return repo.findById(id);
    }

    @Override
    public Accomodatie createAccomodatie(Accomodatie Accomodatie) {
        return repo.createAccomodatie(Accomodatie);
    }

    @Override
    public Accomodatie updateAccomodatie(Accomodatie Accomodatie) {
        return repo.updateAccomodatie(Accomodatie);
    }

    @Override
    public String deleteAccomodatie(Accomodatie Accomodatie) {
        repo.deleteAccomodatie(Accomodatie);
        return "Accomodatie deleted";
    }
}
