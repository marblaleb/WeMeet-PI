package com.example.proyecto_integrado.repositories;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Ofertantes;
import com.example.proyecto_integrado.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfertanteRepository extends JpaRepository<Ofertantes, Long> {

    Ofertantes findByUserName(String userName);

    Optional<Ofertantes> findByEmail(String email);
}
