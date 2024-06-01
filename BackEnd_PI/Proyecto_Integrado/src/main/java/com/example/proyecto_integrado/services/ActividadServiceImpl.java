package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Actividad;
import com.example.proyecto_integrado.repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadServiceImpl implements ActividadService{

    @Autowired
    ActividadRepository  actividadRepository;
    @Override
    public List<Actividad> getAllActividades() {
        return actividadRepository.findAll();
    }

    @Override
    public Actividad getActividadByName(String nombre) {
        return actividadRepository.findByNombre(nombre);
    }

    @Override
    public Actividad insertarActividad(Actividad actividad) {
        if (actividad != null && getActividadByName(actividad.getNombre())==null) {
            return actividadRepository.save(actividad);
        }

        return null;
    }

    @Override
    public Actividad actualizarActividad(Actividad actividad) {
        if (actividad == null || actividad.getId() == null || actividad.getNombre() == null) {
            return null;
        }

        return actividadRepository.save(actividad);
    }

    @Override
    public Optional<Actividad> findActividadById(Long id) {
        return actividadRepository.findById(id);
    }

    @Override
    public void deleteActividad(Long id) {

        actividadRepository.deleteById(id);

    }
}
