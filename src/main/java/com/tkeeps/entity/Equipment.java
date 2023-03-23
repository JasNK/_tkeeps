package com.tkeeps.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;
    private String type;
    private String beschrijving;
    @ManyToOne
    @JoinColumn(name= "loc_id")
    private Locatie loceq;

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

    public Locatie getLoceq() {
        return loceq;
    }

    public void setLoceq(Locatie loceq) {
        this.loceq = loceq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;
        Equipment equipment = (Equipment) o;
        return id == equipment.id && Objects.equals(naam, equipment.naam) && Objects.equals(type, equipment.type) && Objects.equals(beschrijving, equipment.beschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, type, beschrijving);
    }
}
