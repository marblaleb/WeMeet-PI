package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Ofertantes;

import java.util.List;
import java.util.Optional;

public interface OfertanteService {

    public Ofertantes insertOfertantes(Ofertantes usuario);

    public List<Ofertantes> getAllOfertantes();

    public Ofertantes getOfertantesByName(String nombre);



    public Ofertantes actualizarOfertantes(Ofertantes consumidor);

    public Optional<Ofertantes> findOfertantesById(Long id);


    public void deleteOfertantes(Long id);
}
