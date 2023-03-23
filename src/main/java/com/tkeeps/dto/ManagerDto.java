package com.tkeeps.dto;

import com.tkeeps.entity.Locatie;
import com.tkeeps.entity.Manager;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link Manager} entity
 */
public class ManagerDto implements Serializable {
    private int id;
    private String naam;
    private Date gebDatum;
    private String beschrijving;
    private Collection<Locatie> locatiesById;

    public ManagerDto() {
    }

    public ManagerDto(int id, String naam, Date gebDatum, String beschrijving, Collection<Locatie> locatiesById) {
        this.id = id;
        this.naam = naam;
        this.gebDatum = gebDatum;
        this.beschrijving = beschrijving;
        this.locatiesById = locatiesById;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGebDatum() {
        return gebDatum;
    }

    public void setGebDatum(Date gebDatum) {
        this.gebDatum = gebDatum;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Collection<Locatie> getLocatiesById() {
        return locatiesById;
    }

    public void setLocatiesById(Collection<Locatie> locatiesById) {
        this.locatiesById = locatiesById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerDto entity = (ManagerDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.naam, entity.naam) &&
                Objects.equals(this.gebDatum, entity.gebDatum) &&
                Objects.equals(this.beschrijving, entity.beschrijving) &&
                Objects.equals(this.locatiesById, entity.locatiesById);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, gebDatum, beschrijving, locatiesById);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "naam = " + naam + ", " +
                "gebDatum = " + gebDatum + ", " +
                "beschrijving = " + beschrijving + ", " +
                "locatiesById = " + locatiesById + ")";
    }

    public static final class ManagerDtoBuilder {
        private int id;
        private String naam;
        private Date gebDatum;
        private String beschrijving;
        private Collection<Locatie> locatiesById;

        public ManagerDtoBuilder() {
        }

        public static ManagerDtoBuilder aManagerDto() {
            return new ManagerDtoBuilder();
        }

        public ManagerDtoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ManagerDtoBuilder naam(String naam) {
            this.naam = naam;
            return this;
        }

        public ManagerDtoBuilder gebDatum(Date gebDatum) {
            this.gebDatum = gebDatum;
            return this;
        }

        public ManagerDtoBuilder beschrijving(String beschrijving) {
            this.beschrijving = beschrijving;
            return this;
        }

        public ManagerDtoBuilder locatiesById(Collection<Locatie> locatiesById) {
            this.locatiesById = locatiesById;
            return this;
        }

        public ManagerDto build() {
            ManagerDto managerDto = new ManagerDto();
            managerDto.setId(id);
            managerDto.setNaam(naam);
            managerDto.setGebDatum(gebDatum);
            managerDto.setBeschrijving(beschrijving);
            managerDto.setLocatiesById(locatiesById);
            return managerDto;
        }
    }
}