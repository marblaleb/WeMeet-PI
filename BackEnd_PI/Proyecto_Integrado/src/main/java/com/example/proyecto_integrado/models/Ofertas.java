package com.example.proyecto_integrado.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
public class Ofertas {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;


    @ManyToOne
    @JoinColumn(name = "consumidor", nullable = false)
//    @JsonBackReference
    private Consumidor consumidor;

    @ManyToOne
    @JoinColumn(name = "ofertante", nullable = false)
//    @JsonBackReference
    private Ofertantes ofertante;


    public Ofertas() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ofertantes getOfertante() {
        return ofertante;
    }

    public void setOfertante(Ofertantes ofertante) {
        this.ofertante = ofertante;
    }


}
