package com.example.proyecto_integrado.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "consumidor")
@DiscriminatorValue("Consumidor")
@PrimaryKeyJoinColumn(name="id_consumidor")
public class Consumidor extends Usuario implements Serializable {



    @ManyToMany(mappedBy = "consumidor")
    @JsonIgnore
    private Set<Actividad> actividades=new HashSet<>();




    @ManyToMany(mappedBy = "consumidores")
    private Set<Intereses> intereses = new HashSet<>();




    @OneToMany(mappedBy = "consumidor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Ofertas> ofertas = new HashSet<>();

    @ManyToMany(mappedBy = "consumidores")
    private Set<Foro> foros = new HashSet<>();








    public Consumidor() {
    }



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


    public Set<Foro> getForos() {
        return foros;
    }

    public void setForos(Set<Foro> foros) {
        this.foros = foros;
    }
}


