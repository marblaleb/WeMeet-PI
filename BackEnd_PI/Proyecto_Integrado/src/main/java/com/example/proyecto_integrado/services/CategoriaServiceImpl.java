package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Categoria;
import com.example.proyecto_integrado.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    CategoriaRepository categoriaRepository;
    @Override
    public List<Categoria> getAllCategorias() {
        return this.categoriaRepository.findAll();
    }
}
