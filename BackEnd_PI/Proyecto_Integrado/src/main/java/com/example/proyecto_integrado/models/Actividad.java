package com.example.proyecto_integrado.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Actividad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String hora;


    @Column(nullable = false)
    private int duracion;
    @Column(nullable = false)
    private String lugar;

    @Column(nullable = false)
    private float tarifa;

    @Column(nullable = false)
    private float dificultad;

    @ManyToMany(mappedBy = "actividades")
    private Set<Categoria> categorias = new HashSet<>();



    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private Set<Consumidor> consumidor=new HashSet<>();

    @OneToOne(mappedBy = "actividad", cascade = CascadeType.ALL)
    private Foro foro;


    @ManyToOne
    @JoinColumn(name = "ofertante", nullable = false)
//    @JsonBackReference
    private Ofertantes ofertante;


    public Actividad() {
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

    public Set<Consumidor> getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Set<Consumidor> consumidor) {
        this.consumidor = consumidor;
    }

    public Ofertantes getOfertante() {
        return ofertante;
    }

    public void setOfertante(Ofertantes ofertante) {
        this.ofertante = ofertante;
    }


    public Foro getForo() {
        return foro;
    }

    public void setForo(Foro foro) {
        this.foro = foro;
    }

    public void addConsumidor(final Consumidor consumidor) {
        this.consumidor.add(consumidor);
        consumidor.getActividades().add(this);
    }
    public void removeConsumidor(final Consumidor consumidor) {
        this.consumidor.remove(consumidor);
        consumidor.getActividades().remove(this);
    }




}
