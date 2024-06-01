package com.example.proyecto_integrado.dto;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Ofertantes;
import jakarta.persistence.*;

public class OfertaDTO {



    private Long id;




    private String titulo;


    private String descripcion;



    private Long consumidor_id;


    private Long ofertante_id;

    private Ofertantes ofertante;
    private Consumidor consumidor;

    public OfertaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getConsumidor_id() {
        return consumidor_id;
    }

    public void setConsumidor_id(Long consumidor_id) {
        this.consumidor_id = consumidor_id;
    }

    public Long getOfertante_id() {
        return ofertante_id;
    }

    public void setOfertante_id(Long ofertante_id) {
        this.ofertante_id = ofertante_id;
    }
}
