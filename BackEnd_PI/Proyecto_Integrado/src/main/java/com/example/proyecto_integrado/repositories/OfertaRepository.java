package com.example.proyecto_integrado.repositories;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Ofertantes;
import com.example.proyecto_integrado.models.Ofertas;
import com.example.proyecto_integrado.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfertaRepository  extends JpaRepository<Ofertas, Long> {

    public List<Ofertas> findByOfertante(Ofertantes ofertante);

    public List<Ofertas> findByConsumidor(Consumidor consumidor);
}
