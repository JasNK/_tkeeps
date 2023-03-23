package com.tkeeps.service.interfaces;

import com.tkeeps.entity.Accomodatie;

import java.util.List;

public interface AccomodatieService {
    List<Accomodatie> retrieveAccomodatieList();
    Accomodatie createAccomodatie(Accomodatie accomodatie);

    Accomodatie findById(int id);

    String deleteAccomodatie(Accomodatie accomodatie);

    Accomodatie updateAccomodatie(Accomodatie accomodatie);
}
