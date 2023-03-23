package com.tkeeps.dto;

import com.tkeeps.entity.Accomodatie;
import com.tkeeps.entity.Equipment;
import com.tkeeps.entity.Locatie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link Locatie} entity
 */
public class LocatieDto implements Serializable {
    private int id;
    private int manId;
    private String naam;
    private String coordinaten;
    private String beschrijving;
    private Collection<Accomodatie> accomodatiesById;
    private Collection<Equipment> equipmentById;

    public LocatieDto() {
    }

    public LocatieDto(int id, int manId, String naam, String coordinaten, String beschrijving, Collection<Accomodatie> accomodatiesById, Collection<Equipment> equipmentById) {
        this.id = id;
        this.manId = manId;
        this.naam = naam;
        this.coordinaten = coordinaten;
        this.beschrijving = beschrijving;
        this.accomodatiesById = accomodatiesById;
        this.equipmentById = equipmentById;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getCoordinaten() {
        return coordinaten;
    }

    public void setCoordinaten(String coordinaten) {
        this.coordinaten = coordinaten;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Collection<Accomodatie> getAccomodatiesById() {
        return accomodatiesById;
    }

    public void setAccomodatiesById(Collection<Accomodatie> accomodatiesById) {
        this.accomodatiesById = accomodatiesById;
    }

    public Collection<Equipment> getEquipmentById() {
        return equipmentById;
    }

    public void setEquipmentById(Collection<Equipment> equipmentById) {
        this.equipmentById = equipmentById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocatieDto entity = (LocatieDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.manId, entity.manId) &&
                Objects.equals(this.naam, entity.naam) &&
                Objects.equals(this.coordinaten, entity.coordinaten) &&
                Objects.equals(this.beschrijving, entity.beschrijving) &&
                Objects.equals(this.accomodatiesById, entity.accomodatiesById) &&
                Objects.equals(this.equipmentById, entity.equipmentById);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manId, naam, coordinaten, beschrijving, accomodatiesById, equipmentById);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "manId = " + manId + ", " +
                "naam = " + naam + ", " +
                "coordinaten = " + coordinaten + ", " +
                "beschrijving = " + beschrijving + ", " +
                "accomodatiesById = " + accomodatiesById + ", " +
                "equipmentById = " + equipmentById + ")";
    }
}