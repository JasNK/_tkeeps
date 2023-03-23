package com.tkeeps.dto;

import com.tkeeps.entity.Equipment;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Equipment} entity
 */
public class EquipmentDto implements Serializable {
    private int id;
    private int locId;
    private String naam;
    private String type;
    private String beschrijving;

    public EquipmentDto() {
    }

    public EquipmentDto(int id, int locId, String naam, String type, String beschrijving) {
        this.id = id;
        this.locId = locId;
        this.naam = naam;
        this.type = type;
        this.beschrijving = beschrijving;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentDto entity = (EquipmentDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.locId, entity.locId) &&
                Objects.equals(this.naam, entity.naam) &&
                Objects.equals(this.type, entity.type) &&
                Objects.equals(this.beschrijving, entity.beschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locId, naam, type, beschrijving);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "locId = " + locId + ", " +
                "naam = " + naam + ", " +
                "type = " + type + ", " +
                "beschrijving = " + beschrijving + ")";
    }
}