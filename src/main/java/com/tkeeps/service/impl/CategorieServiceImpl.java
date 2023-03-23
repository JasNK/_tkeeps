package com.tkeeps.service.impl;

import com.tkeeps.config.JPAConfig;
import com.tkeeps.entity.Categorie;
import com.tkeeps.repository.CategorieRepo;
import com.tkeeps.service.interfaces.CategorieService;

import java.util.List;

public class CategorieServiceImpl implements CategorieService {
    private final CategorieRepo repo;

    public CategorieServiceImpl() {
        this.repo = new CategorieRepo(JPAConfig.getEntityManager());
    }

    @Override
    public List<Categorie> retrieveCategorieList() {
        return repo.retrieveCategorieList();
    }

    @Override
    public Categorie findById(int id) {
        return repo.findById(id);
    }

//    @Override
//    public Categorie createCategorie(Categorie categorie) {
//        return repo.createCategorie(categorie);
//    }

//    @Override
//    public Categorie updateCategorie(Categorie categorie) {
//        return repo.updateCategorie(categorie);
//    }
//
//    @Override
//    public String deleteCategorie(Categorie categorie) {
//        repo.deleteCategorie(categorie);
//        return "Categorie deleted";
//    }
}
