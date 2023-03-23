package com.tkeeps.dto;

import com.tkeeps.entity.Categorie;
import com.tkeeps.entity.Locatie;
import com.tkeeps.entity.Accomodatie;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link Accomodatie} entity
 */
public class AccomodatieDto implements Serializable {
    private int id;
    private int catId;
    private int locId;
    private String ruimteType;
    private String ruimteCode;
    private BigDecimal prijs;
    private String beschrijving;
    private Categorie categorieByCatId;
    private Locatie locatieByLocId;

    public AccomodatieDto() {
    }

    public AccomodatieDto(int id, int catId, int locId, String ruimteType, String ruimteCode, BigDecimal prijs, String beschrijving, Categorie categorieByCatId, Locatie locatieByLocId) {
        this.id = id;
        this.catId = catId;
        this.locId = locId;
        this.ruimteType = ruimteType;
        this.ruimteCode = ruimteCode;
        this.prijs = prijs;
        this.beschrijving = beschrijving;
        this.categorieByCatId = categorieByCatId;
        this.locatieByLocId = locatieByLocId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getRuimteType() {
        return ruimteType;
    }

    public void setRuimteType(String ruimteType) {
        this.ruimteType = ruimteType;
    }

    public String getRuimteCode() {
        return ruimteCode;
    }

    public void setRuimteCode(String ruimteCode) {
        this.ruimteCode = ruimteCode;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Categorie getCategorieByCatId() {
        return categorieByCatId;
    }

    public void setCategorieByCatId(Categorie categorieByCatId) {
        this.categorieByCatId = categorieByCatId;
    }

    public Locatie getLocatieByLocId() {
        return locatieByLocId;
    }

    public void setLocatieByLocId(Locatie locatieByLocId) {
        this.locatieByLocId = locatieByLocId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccomodatieDto entity = (AccomodatieDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.catId, entity.catId) &&
                Objects.equals(this.locId, entity.locId) &&
                Objects.equals(this.ruimteType, entity.ruimteType) &&
                Objects.equals(this.ruimteCode, entity.ruimteCode) &&
                Objects.equals(this.prijs, entity.prijs) &&
                Objects.equals(this.beschrijving, entity.beschrijving) &&
                Objects.equals(this.categorieByCatId, entity.categorieByCatId) &&
                Objects.equals(this.locatieByLocId, entity.locatieByLocId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, catId, locId, ruimteType, ruimteCode, prijs, beschrijving, categorieByCatId, locatieByLocId);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "catId = " + catId + ", " +
                "locId = " + locId + ", " +
                "ruimteType = " + ruimteType + ", " +
                "ruimteCode = " + ruimteCode + ", " +
                "prijs = " + prijs + ", " +
                "beschrijving = " + beschrijving + ", " +
                "categorieByCatId = " + categorieByCatId + ", " +
                "locatieByLocId = " + locatieByLocId + ")";
    }
}