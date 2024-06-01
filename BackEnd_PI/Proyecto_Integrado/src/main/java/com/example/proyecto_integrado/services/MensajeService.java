package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Foro;
import com.example.proyecto_integrado.models.Mensaje;

import java.util.List;
import java.util.Optional;

public interface MensajeService {

    public Mensaje insertMensaje(Mensaje Mensaje);

    public List<Mensaje> getAllMensaje();

    public Mensaje getMensajeByName(String nombre);



    public Mensaje actualizarMensaje(Mensaje Mensaje);

    public Optional<Mensaje> findMensajeById(Long id);


    public void deleteMensaje(Long id);
    public List<Mensaje>findMensajebyForo(Foro foro);

}
