package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Foro;
import com.example.proyecto_integrado.models.Mensaje;
import com.example.proyecto_integrado.repositories.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeServiceImpl implements MensajeService{

    @Autowired
    private MensajeRepository mensajeRepository;


    @Override
    public Mensaje insertMensaje(Mensaje Mensaje) {
        if(Mensaje!=null){
            mensajeRepository.save(Mensaje);
        }
        return null;
    }

    @Override
    public List<Mensaje> getAllMensaje() {
        return mensajeRepository.findAll();
    }

    @Override
    public Mensaje getMensajeByName(String nombre) {
        return null;
    }

    @Override
    public Mensaje actualizarMensaje(Mensaje Mensaje) {

        if (Mensaje == null || Mensaje.getId() == null) {
            return null;
        }

        return mensajeRepository.save(Mensaje);
    }

    @Override
    public Optional<Mensaje> findMensajeById(Long id) {
        return mensajeRepository.findById(id);
    }

    @Override
    public void deleteMensaje(Long id) {

        mensajeRepository.deleteById(id);

    }

    @Override
    public List<Mensaje>findMensajebyForo(Foro foro) {

        return mensajeRepository.findByForo(foro);

    }
}
