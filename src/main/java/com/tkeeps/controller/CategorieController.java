package com.tkeeps.controller;

import com.tkeeps.entity.Categorie;
import com.tkeeps.entity.Locatie;
import com.tkeeps.service.impl.CategorieServiceImpl;
import com.tkeeps.service.interfaces.CategorieService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Path("categorie")
public class CategorieController {
    private final CategorieService categorieService = new CategorieServiceImpl();

    @Path("/retrieve")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categorie> retrieve() {
        return categorieService.retrieveCategorieList();
    }

    @POST
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Categorie find(Locatie locatie) {
        return categorieService.findById(locatie.getId());
    }
}
