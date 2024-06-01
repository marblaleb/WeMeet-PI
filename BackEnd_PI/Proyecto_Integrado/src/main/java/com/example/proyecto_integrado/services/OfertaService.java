package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Ofertantes;
import com.example.proyecto_integrado.models.Ofertas;
import com.example.proyecto_integrado.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface OfertaService {

    public Ofertas insertOfertas(Ofertas oferta);

    public List<Ofertas> getAllOfertas();

    public List<Ofertas> getOfertasByOfertante(Ofertantes ofertantes);
    public List<Ofertas> getOfertasByConsumidor(Consumidor consumidor);



    public Optional<Ofertas> findOfertasoById(Long id);


    public void deleteOfertas(Long id);
}
