package com.tkeeps.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String naam;
    @Column(name = "geb_datum")
    private Date gebDatum;
    private String beschrijving;
//    @JsonIgnore
    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Locatie> locaties;

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

    public List<Locatie> getLocaties() {
        return locaties;
    }

    public void setLocaties(List<Locatie> locaties) {
        this.locaties = locaties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return id == manager.id && Objects.equals(naam, manager.naam) && Objects.equals(gebDatum, manager.gebDatum) && Objects.equals(beschrijving, manager.beschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naam, gebDatum, beschrijving);
    }

    public static final class ManagerBuilder {
        private int id;
        private String naam;
        private Date gebDatum;
        private String beschrijving;
        private List<Locatie> locaties;

        public ManagerBuilder() {
        }

        public static ManagerBuilder aManager() {
            return new ManagerBuilder();
        }

        public ManagerBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ManagerBuilder naam(String naam) {
            this.naam = naam;
            return this;
        }

        public ManagerBuilder gebDatum(Date gebDatum) {
            this.gebDatum = gebDatum;
            return this;
        }

        public ManagerBuilder beschrijving(String beschrijving) {
            this.beschrijving = beschrijving;
            return this;
        }

        public ManagerBuilder locaties(List<Locatie> locaties) {
            this.locaties = locaties;
            return this;
        }

        public Manager build() {
            Manager manager = new Manager();
            manager.setId(id);
            manager.setNaam(naam);
            manager.setGebDatum(gebDatum);
            manager.setBeschrijving(beschrijving);
            manager.setLocaties(locaties);
            return manager;
        }
    }
}
