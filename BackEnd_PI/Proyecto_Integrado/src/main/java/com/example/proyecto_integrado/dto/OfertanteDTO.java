package com.example.proyecto_integrado.dto;

import com.example.proyecto_integrado.models.Actividad;
import com.example.proyecto_integrado.models.Intereses;
import com.example.proyecto_integrado.models.Rol;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class OfertanteDTO {


    private Long id;


    private String userName;


    private String password;


    private String email;


    private String nombre;


    private String apellidos;


    private boolean activo;

    private String imagenPerfil;


    private String ciudad;


    private String telefono;


    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    private Set<Rol> roles=new HashSet<>();



    private Set<Actividad> actividades = new HashSet<>();


    private Set<Intereses> intereses = new HashSet<>();


    public OfertanteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
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

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }
}
