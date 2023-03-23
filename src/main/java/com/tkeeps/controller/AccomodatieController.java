package com.tkeeps.controller;

import com.tkeeps.entity.Accomodatie;
import com.tkeeps.service.impl.AccomodatieServiceImpl;
import com.tkeeps.service.interfaces.AccomodatieService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Path("accomodatie")
public class AccomodatieController {
    private final AccomodatieService accomodatieService = new AccomodatieServiceImpl();

    @Path("/retrieve")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Accomodatie> retrieve() {
        return accomodatieService.retrieveAccomodatieList();
    }

    @POST
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Accomodatie find(Accomodatie accomodatie) {
        return accomodatieService.findById(accomodatie.getId());
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Accomodatie add(Accomodatie accomodatie) {
        return accomodatieService.createAccomodatie(accomodatie);
    }

    @Path("/update")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Accomodatie update(Accomodatie accomodatie) {
        return accomodatieService.updateAccomodatie(accomodatie);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String remove(Accomodatie accomodatie) {
        return accomodatieService.deleteAccomodatie(accomodatie);
    }
}
