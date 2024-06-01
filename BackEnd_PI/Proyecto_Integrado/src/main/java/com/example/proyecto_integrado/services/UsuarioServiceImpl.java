package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Usuario;
import com.example.proyecto_integrado.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public Usuario insertUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioByName(String nombre) {
        return null;
    }

    @Override
    public Optional<Usuario> findUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void deleteUsuario(Long id) {

        usuarioRepository.deleteById(id);

    }
}
