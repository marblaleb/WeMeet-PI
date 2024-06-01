package com.example.proyecto_integrado.repositories;

import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor, Long> {

    Consumidor findByUserName(String userName);


    Optional<Consumidor> findByEmail(String email);






}
