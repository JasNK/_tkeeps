package com.tkeeps.service.interfaces;

import com.tkeeps.entity.Categorie;

import java.util.List;

public interface CategorieService {
    List<Categorie> retrieveCategorieList();
//    Categorie createCategorie(Categorie categorie);

    Categorie findById(int id);
//
//    String deleteCategorie(Categorie categorie);
//
//    Categorie updateCategorie(Categorie categorie);
}
