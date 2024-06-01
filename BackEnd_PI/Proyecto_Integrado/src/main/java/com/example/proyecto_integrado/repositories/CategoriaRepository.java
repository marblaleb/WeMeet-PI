package com.example.proyecto_integrado.repositories;

import com.example.proyecto_integrado.models.Actividad;
import com.example.proyecto_integrado.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
