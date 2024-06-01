package com.example.proyecto_integrado.dto;

import com.example.proyecto_integrado.models.Categoria;
import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Ofertantes;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ActividadDTO {


    private Long id;




    private String nombre;


    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;


    private String hora;



    private int duracion;

    private String lugar;


    private float tarifa;


    private float dificultad;


    private Set<Categoria> categorias = new HashSet<>();


    private Set<Consumidor> consumidor = new HashSet<>();


    private Long consumidorid;

    private Long categoria_id;


    private Ofertantes ofertante;

    private Long ofertanteid;






    public ActividadDTO() {
    }

    public ActividadDTO(String nombre, String descripcion, Date fecha, String hora, int duracion, String lugar, float tarifa, float dificultad, Set<Categoria> categorias, Long consumidorid, Set<Consumidor> consumidor,  Ofertantes ofertante, Long ofertanteid, Long categoria_id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.lugar = lugar;
        this.tarifa = tarifa;
        this.dificultad = dificultad;
        this.categorias = categorias;
        this.consumidorid = consumidorid;
        this.consumidor=consumidor;
        this.ofertante = ofertante;
        this.ofertanteid=ofertanteid;
        this.categoria_id=categoria_id;
    }

    public ActividadDTO(String nombre, String descripcion, Date fecha, String hora, int duracion, String lugar, float tarifa, float dificultad, Ofertantes ofertante, Long ofertanteid) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.lugar = lugar;
        this.tarifa = tarifa;
        this.dificultad = dificultad;
        this.ofertante = ofertante;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public float getDificultad() {
        return dificultad;
    }

    public void setDificultad(float dificultad) {
        this.dificultad = dificultad;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Long getConsumidorid() {
        return consumidorid;
    }

    public Set<Consumidor> getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Set<Consumidor> consumidor) {
        this.consumidor = consumidor;
    }

    public void setConsumidorid(Long consumidorid) {
        this.consumidorid = consumidorid;
    }

    public Ofertantes getOfertante() {
        return ofertante;
    }

    public void setOfertante(Ofertantes ofertante) {
        this.ofertante = ofertante;
    }

    public Long getOfertanteid() {
        return ofertanteid;
    }

    public void setOfertanteid(Long ofertanteid) {
        this.ofertanteid = ofertanteid;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }
}
