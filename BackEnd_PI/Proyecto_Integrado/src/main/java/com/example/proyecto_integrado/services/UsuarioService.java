package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.models.Ofertantes;
import com.example.proyecto_integrado.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public Usuario insertUsuario(Usuario usuario);

    public List<Usuario> getAllUsuario();

    public Usuario getUsuarioByName(String nombre);



    public Optional<Usuario> findUsuarioById(Long id);


    public void deleteUsuario(Long id);
}
