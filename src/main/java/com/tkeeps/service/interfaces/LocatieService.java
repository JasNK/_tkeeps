package com.tkeeps.service.interfaces;

import com.tkeeps.entity.Locatie;

import java.util.List;

public interface LocatieService {
    List<Locatie> retrieveLocatieList();
    Locatie createLocatie(Locatie locatie);

    Locatie findById(int id);

    String deleteLocatie(Locatie locatie);

    Locatie updateLocatie(Locatie locatie);
}
