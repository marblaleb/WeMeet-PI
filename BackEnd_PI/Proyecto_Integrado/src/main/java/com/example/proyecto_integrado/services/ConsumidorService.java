package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Consumidor;

import java.util.List;
import java.util.Optional;

public interface ConsumidorService {

    public Consumidor insertConsumidor(Consumidor usuario);

    public List<Consumidor> getAllConsumidor();

    public Consumidor getConsumidorByName(String nombre);



    public Consumidor actualizarConsumidor(Consumidor consumidor);

    public Optional<Consumidor> findConsumidorById(Long id);


    public void deleteConsumidor(Long id);
}
