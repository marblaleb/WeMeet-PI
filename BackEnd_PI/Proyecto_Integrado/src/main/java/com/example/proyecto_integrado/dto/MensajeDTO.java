package com.example.proyecto_integrado.dto;

import com.example.proyecto_integrado.models.Foro;
import com.example.proyecto_integrado.models.Usuario;
import jakarta.persistence.*;

public class MensajeDTO {

    private Long id;


    private String titulo;


    private String contenido;


    private Long usuario_id;

    private Usuario usuario;

    private Foro foro;


    private Long foro_id;


    public MensajeDTO() {
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

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Long getForo_id() {
        return foro_id;
    }

    public void setForo_id(Long foro_id) {
        this.foro_id = foro_id;
    }
}
