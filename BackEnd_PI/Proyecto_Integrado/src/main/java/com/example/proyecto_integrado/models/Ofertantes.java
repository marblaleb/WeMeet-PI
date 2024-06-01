package com.example.proyecto_integrado.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ofertantes")
@DiscriminatorValue("Ofertante")
@PrimaryKeyJoinColumn(name="id_ofertante")
public class Ofertantes extends Usuario implements Serializable {




    public Ofertantes() {
    }



    @OneToMany(mappedBy = "ofertante", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Actividad> actividades = new HashSet<>();

    @ManyToMany(mappedBy = "ofertantes")
//    @JsonIgnore
    private Set<Intereses> intereses = new HashSet<>();



    @OneToMany(mappedBy = "ofertante", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Ofertas> ofertas = new HashSet<>();










    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Set<Intereses> getIntereses() {
        return intereses;
    }

    public void setIntereses(Set<Intereses> intereses) {
        this.intereses = intereses;
    }



    public Set<Ofertas> getOfertas() {
        return ofertas;
    }

    public void setOfertas(Set<Ofertas> ofertas) {
        this.ofertas = ofertas;
    }


//    HELPERS

    public void addActividad(Actividad actividad) {
        this.actividades.add(actividad);
        actividad.setOfertante(this);
    }


    public void removeActividad(Actividad actividad) {
        this.actividades.remove(actividad);
        actividad.setOfertante(null);
    }


}


