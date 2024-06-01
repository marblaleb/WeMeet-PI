package com.example.proyecto_integrado.mapper;

import com.example.proyecto_integrado.dto.ConsumidorDTO;
import com.example.proyecto_integrado.dto.UsuarioDTO;
import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConsumidorMapper implements Mapper<Consumidor, ConsumidorDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ConsumidorDTO mapTo(Consumidor consumidor) {
        return modelMapper.map(consumidor, ConsumidorDTO.class);
    }

    @Override
    public Consumidor mapFrom(ConsumidorDTO consumidorDTO) {
        return modelMapper.map(consumidorDTO, Consumidor.class);
    }
}
