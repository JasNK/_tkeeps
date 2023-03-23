package com.tkeeps.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Accomodatie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ruimteType;
    private String ruimteCode;
    private BigDecimal prijs;
    private String beschrijving;
    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    private Categorie catacc;
    @ManyToOne
    @JoinColumn(name= "loc_id")
    private Locatie locacc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Categorie getCatacc() {
        return catacc;
    }

    public void setCatacc(Categorie catacc) {
        this.catacc = catacc;
    }

    public Locatie getLocacc() {
        return locacc;
    }

    public void setLocacc(Locatie locacc) {
        this.locacc = locacc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accomodatie)) return false;
        Accomodatie that = (Accomodatie) o;
        return id == that.id && ruimteType.equals(that.ruimteType) && ruimteCode.equals(that.ruimteCode) && prijs.equals(that.prijs) && Objects.equals(beschrijving, that.beschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ruimteType, ruimteCode, prijs, beschrijving);
    }
}
