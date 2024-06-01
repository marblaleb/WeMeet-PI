package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Foro;

import java.util.List;
import java.util.Optional;

public interface ForoService {

    public Foro insertForo(Foro Foro);

    public List<Foro> getAllForo();





    public Foro actualizarForo(Foro Foro);

    public Optional<Foro> findForoById(Long id);


    public void deleteForo(Long id);
}
