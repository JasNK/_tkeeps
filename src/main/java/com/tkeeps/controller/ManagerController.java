package com.tkeeps.controller;

import com.tkeeps.entity.Manager;
import com.tkeeps.service.impl.ManagerServiceImpl;
import com.tkeeps.service.interfaces.ManagerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("manager")
public class ManagerController {
    private final ManagerService managerService = new ManagerServiceImpl();

    @Path("/retrieve")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Manager> retrieve() {
        return managerService.retrieveManagerList();
    }

    @POST
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Manager find(Manager manager) {
        return managerService.findById(manager.getId());
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Manager add(Manager manager) {
        return managerService.createManager(manager);
    }

    @Path("/update")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Manager update(Manager manager) {
        return managerService.updateManager(manager);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String remove(Manager manager) {
        return managerService.deleteManager(manager);
    }
}
