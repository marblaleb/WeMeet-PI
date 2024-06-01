package com.example.proyecto_integrado.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Usuario> usuarios=new HashSet<>();



    public Rol() {
    }



    public Rol(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}
