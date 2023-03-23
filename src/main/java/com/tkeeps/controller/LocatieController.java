package com.tkeeps.controller;

import com.tkeeps.entity.Locatie;
import com.tkeeps.service.impl.LocatieServiceImpl;
import com.tkeeps.service.interfaces.LocatieService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("locatie")
public class LocatieController {
    private final LocatieService locatieService = new LocatieServiceImpl();

    @Path("/retrieve")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Locatie> retrieve() {
        return locatieService.retrieveLocatieList();
    }

    @POST
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Locatie find(Locatie locatie) {
        return locatieService.findById(locatie.getId());
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Locatie add(Locatie locatie) {
        return locatieService.createLocatie(locatie);
    }

    @Path("/update")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Locatie update(Locatie locatie) {
        return locatieService.updateLocatie(locatie);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String remove(Locatie locatie) {
        return locatieService.deleteLocatie(locatie);
    }
}
