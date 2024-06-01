package com.example.proyecto_integrado.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="intereses")
public class Intereses implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private String nombre;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Ofertantes> ofertantes;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Consumidor> consumidores=new HashSet<>();


    public Intereses() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Ofertantes> getOfertantes() {
        return ofertantes;
    }

    public void setOfertantes(Set<Ofertantes> ofertantes) {
        this.ofertantes = ofertantes;
    }

    public Set<Consumidor> getConsumidores() {
        return consumidores;
    }

    public void setConsumidores(Set<Consumidor> consumidores) {
        this.consumidores = consumidores;
    }

    public void addConsumidor(final Consumidor consumidor) {
        this.consumidores.add(consumidor);
        consumidor.getIntereses().add(this);
    }
    public void removeConsumidor(final Consumidor consumidor) {
        this.consumidores.remove(consumidor);
        consumidor.getIntereses().remove(this);
    }

    public void addOfertante(final Ofertantes ofertante) {
        this.ofertantes.add(ofertante);
        ofertante.getIntereses().add(this);
    }
    public void removeOfertante(final Ofertantes ofertante) {
        this.ofertantes.remove(ofertante);
        ofertante.getIntereses().remove(this);
    }

}
