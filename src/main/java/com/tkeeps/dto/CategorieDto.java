package com.tkeeps.dto;

import com.tkeeps.entity.Accomodatie;
import com.tkeeps.entity.Categorie;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * A DTO for the {@link Categorie} entity
 */
public class CategorieDto implements Serializable {
    private int id;
    private String code;
    private int aantalAccom;
    private String beschrijving;
    private Collection<Accomodatie> accomodatiesById;

    public CategorieDto() {
    }

    public CategorieDto(int id, String code, int aantalAccom, String beschrijving, Collection<Accomodatie> accomodatiesById) {
        this.id = id;
        this.code = code;
        this.aantalAccom = aantalAccom;
        this.beschrijving = beschrijving;
        this.accomodatiesById = accomodatiesById;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAantalAccom() {
        return aantalAccom;
    }

    public void setAantalAccom(int aantalAccom) {
        this.aantalAccom = aantalAccom;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieDto entity = (CategorieDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.code, entity.code) &&
                Objects.equals(this.aantalAccom, entity.aantalAccom) &&
                Objects.equals(this.beschrijving, entity.beschrijving) &&
                Objects.equals(this.accomodatiesById, entity.accomodatiesById);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, aantalAccom, beschrijving, accomodatiesById);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "code = " + code + ", " +
                "aantalAccom = " + aantalAccom + ", " +
                "beschrijving = " + beschrijving + ", " +
                "accomodatiesById = " + accomodatiesById + ")";
    }
}