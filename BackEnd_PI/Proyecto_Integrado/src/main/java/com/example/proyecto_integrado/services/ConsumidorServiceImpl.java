package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.repositories.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumidorServiceImpl implements ConsumidorService {

    @Autowired
    ConsumidorRepository consumidorRepository;
    @Override
    public Consumidor insertConsumidor(Consumidor usuario) {
        if (usuario != null) {
            return consumidorRepository.save(usuario);
        }

        return null;
    }

    @Override
    public List<Consumidor> getAllConsumidor() {
        return consumidorRepository.findAll();
    }

    @Override
    public Consumidor getConsumidorByName(String nombre) {
        return consumidorRepository.findByUserName(nombre);
    }

    @Override
    public Consumidor actualizarConsumidor(Consumidor consumidor) {
        return consumidorRepository.save(consumidor);
    }

    @Override
    public Optional<Consumidor> findConsumidorById(Long id) {
        return consumidorRepository.findById(id);
    }

    @Override
    public void deleteConsumidor(Long id) {

        consumidorRepository.deleteById(id);

    }
}
