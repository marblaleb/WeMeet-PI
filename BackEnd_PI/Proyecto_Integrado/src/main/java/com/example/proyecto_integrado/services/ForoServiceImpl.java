package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Foro;
import com.example.proyecto_integrado.repositories.ConsumidorRepository;
import com.example.proyecto_integrado.repositories.ForoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForoServiceImpl implements ForoService{


    @Autowired
    ForoRepository foroRepository;
    @Override
    public Foro insertForo(Foro Foro) {
        if (Foro!= null) {
            return foroRepository.save(Foro);
        }

        return null;
    }

    @Override
    public List<Foro> getAllForo() {
        return foroRepository.findAll();
    }



    @Override
    public Foro actualizarForo(Foro Foro) {
        if (Foro!= null) {
            return foroRepository.save(Foro);
        }

        return null;
    }

    @Override
    public Optional<Foro> findForoById(Long id) {
        return foroRepository.findById(id);
    }

    @Override
    public void deleteForo(Long id) {

        foroRepository.deleteById(id);

    }
}
