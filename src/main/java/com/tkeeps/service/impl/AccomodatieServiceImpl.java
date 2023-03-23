package com.tkeeps.service.impl;

import com.tkeeps.config.JPAConfig;
import com.tkeeps.entity.Accomodatie;
import com.tkeeps.repository.AccomodatieRepo;
import com.tkeeps.service.interfaces.AccomodatieService;

import java.util.List;

public class AccomodatieServiceImpl implements AccomodatieService {
    private final AccomodatieRepo repo;
//    private final LocatieRepo locRepo;

    public AccomodatieServiceImpl() {
        this.repo = new AccomodatieRepo(JPAConfig.getEntityManager());
//        this.locRepo = new LocatieRepo(JPAConfig.getEntityManager());
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
    public Accomodatie createAccomodatie(Accomodatie accomodatie) {
        return repo.createAccomodatie(accomodatie);
    }

    @Override
    public Accomodatie updateAccomodatie(Accomodatie accomodatie) {
        return repo.updateAccomodatie(accomodatie);
    }

    @Override
    public String deleteAccomodatie(Accomodatie Accomodatie) {
        repo.deleteAccomodatie(Accomodatie);
        return "Accomodatie deleted";
    }
//    @Override
//    public Map<String, List> update2Accomodatie(Accomodatie accomodatie) {
//        Map<String, List> map = new HashMap<>();
//        map.put("accomodatie", new ArrayList((Collection) repo.updateAccomodatie(accomodatie)));
//        map.put("locatie", locRepo.retrieveLocatieList());
//        return map;
//    }
}
