package com.tkeeps.entity;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Locatie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;
    private String coordinaten;
    private String beschrijving;

    @ManyToOne
    @JoinColumn(name= "man_id")
    private Manager manager;
    @OneToMany(mappedBy = "locacc", cascade = CascadeType.ALL)
    private List<Accomodatie> accomodatie;
    @OneToMany(mappedBy = "loceq", cascade = CascadeType.ALL)
    private List<Equipment> equipment;

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Accomodatie> getAccomodatie() {
        return accomodatie;
    }

    public void setAccomodatie(List<Accomodatie> accomodatie) {
        this.accomodatie = accomodatie;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locatie locatie = (Locatie) o;
        return id == locatie.id && Objects.equals(naam, locatie.naam) && Objects.equals(coordinaten, locatie.coordinaten) && Objects.equals(beschrijving, locatie.beschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, coordinaten, beschrijving);
    }
}
