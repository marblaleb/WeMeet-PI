package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Ofertantes;
import com.example.proyecto_integrado.repositories.ConsumidorRepository;
import com.example.proyecto_integrado.repositories.OfertanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertanteServiceImpl implements OfertanteService{

    @Autowired
    OfertanteRepository ofertanteRepository;
    @Override
    public Ofertantes insertOfertantes(Ofertantes ofertante) {
        if (ofertante != null) {
            return ofertanteRepository.save(ofertante);
        }

        return null;
    }

    @Override
    public List<Ofertantes> getAllOfertantes() {
        return ofertanteRepository.findAll();
    }

    @Override
    public Ofertantes getOfertantesByName(String nombre) {
        return ofertanteRepository.findByUserName(nombre);
    }

    @Override
    public Ofertantes actualizarOfertantes(Ofertantes ofertante) {
        return ofertanteRepository.save(ofertante);
    }

    @Override
    public Optional<Ofertantes> findOfertantesById(Long id) {
        return ofertanteRepository.findById(id);
    }

    @Override
    public void deleteOfertantes(Long id) {

        ofertanteRepository.deleteById(id);

    }
}
