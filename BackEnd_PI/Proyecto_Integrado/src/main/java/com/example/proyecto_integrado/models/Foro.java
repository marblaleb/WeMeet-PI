package com.example.proyecto_integrado.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Foro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String nombre;

    @Column()
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_ofertante", unique = true, insertable = false, updatable = false)
    private Ofertantes ofertante;

    @OneToOne
    @JoinColumn(name="id_actividad", unique = true)
    private Actividad actividad;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    private Set<Consumidor> consumidores=new HashSet<>();


    @OneToMany(mappedBy = "foro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Mensaje> mensajes=new ArrayList<>();

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Foro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Ofertantes getOfertante() {
        return ofertante;
    }

    public void setOfertante(Ofertantes ofertante) {
        this.ofertante = ofertante;
    }



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public void addConsumidor(final Consumidor consumidor) {
        this.consumidores.add(consumidor);
        consumidor.getForos().add(this);
    }
    public void removeConsumidor(final Consumidor consumidor) {
        this.consumidores.remove(consumidor);
        consumidor.getForos().remove(this);
    }

    @Override
    public String toString() {
        return "Foro{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ofertante=" + ofertante +
                ", actividad=" + actividad +
                ", fecha=" + fecha +
                '}';
    }
}
