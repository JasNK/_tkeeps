package com.tkeeps.controller;

import com.tkeeps.entity.Equipment;
import com.tkeeps.service.impl.EquipmentServiceImpl;
import com.tkeeps.service.interfaces.EquipmentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Path("equipment")
public class EquipmentController {
    private final EquipmentService equipmentService = new EquipmentServiceImpl();

    @Path("/retrieve")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipment> retrieve() {
        return equipmentService.retrieveEquipmentList();
    }

    @POST
    @Path("/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Equipment find(Equipment equipment) {
        return equipmentService.findById(equipment.getId());
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Equipment add(Equipment equipment) {
        return equipmentService.createEquipment(equipment);
    }

    @Path("/update")
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Equipment update(Equipment equipment) {
        return equipmentService.updateEquipment(equipment);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String remove(Equipment Equipment) {
        return equipmentService.deleteEquipment(Equipment);
    }
}
