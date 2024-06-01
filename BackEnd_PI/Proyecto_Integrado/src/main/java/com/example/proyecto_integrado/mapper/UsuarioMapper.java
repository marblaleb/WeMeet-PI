package com.example.proyecto_integrado.mapper;

import com.example.proyecto_integrado.dto.ActividadDTO;
import com.example.proyecto_integrado.dto.UsuarioDTO;
import com.example.proyecto_integrado.models.Actividad;
import com.example.proyecto_integrado.models.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements Mapper<Usuario, UsuarioDTO>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDTO mapTo(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @Override
    public Usuario mapFrom(UsuarioDTO usuarioDTO) {
        return modelMapper.map(usuarioDTO, Usuario.class);
    }


}
