package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Ofertantes;
import com.example.proyecto_integrado.models.Ofertas;
import com.example.proyecto_integrado.repositories.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaServiceImpl implements OfertaService{

    @Autowired
    OfertaRepository ofertaRepository;
    @Override
    public Ofertas insertOfertas(Ofertas oferta) {
        return ofertaRepository.save(oferta) ;
    }

    @Override
    public List<Ofertas> getAllOfertas() {
        return ofertaRepository.findAll();
    }

    @Override
    public List<Ofertas> getOfertasByOfertante(Ofertantes ofertantes) {
        return ofertaRepository.findByOfertante(ofertantes);
    }

    @Override
    public List<Ofertas> getOfertasByConsumidor(Consumidor consumidor) {
        return ofertaRepository.findByConsumidor(consumidor);
    }

    @Override
    public Optional<Ofertas> findOfertasoById(Long id) {
        return ofertaRepository.findById(id);
    }

    @Override
    public void deleteOfertas(Long id) {

        ofertaRepository.deleteById(id);

    }
}
