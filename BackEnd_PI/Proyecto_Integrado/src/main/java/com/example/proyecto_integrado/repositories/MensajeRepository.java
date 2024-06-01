package com.example.proyecto_integrado.repositories;

import com.example.proyecto_integrado.models.Foro;
import com.example.proyecto_integrado.models.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {



    public List<Mensaje> findByForo(Foro foro);






}
