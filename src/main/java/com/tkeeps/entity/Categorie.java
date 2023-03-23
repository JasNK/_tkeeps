package com.tkeeps.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    @Column(name = "aantal_accom")
    private int aantalAccom;
    private String beschrijving;
    @OneToMany(mappedBy = "catacc")
    private List<Accomodatie> accomodatie;

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

    public List<Accomodatie> getAccomodatie() {
        return accomodatie;
    }

    public void setAccomodatie(List<Accomodatie> accomodatie) {
        this.accomodatie = accomodatie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categorie)) return false;
        Categorie categorie = (Categorie) o;
        return id == categorie.id && aantalAccom == categorie.aantalAccom && code.equals(categorie.code) && Objects.equals(beschrijving, categorie.beschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, aantalAccom, beschrijving);
    }
}
