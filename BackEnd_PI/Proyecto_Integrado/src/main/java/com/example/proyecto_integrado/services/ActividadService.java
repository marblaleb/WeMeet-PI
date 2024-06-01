package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Actividad;

import java.util.List;
import java.util.Optional;

public interface ActividadService {


    public List<Actividad> getAllActividades();

    public Actividad getActividadByName(String nombre);

    public Actividad insertarActividad(Actividad actividad);

    public Actividad actualizarActividad(Actividad actividad);

    public Optional<Actividad> findActividadById(Long id);

    public void deleteActividad(Long id);
}
