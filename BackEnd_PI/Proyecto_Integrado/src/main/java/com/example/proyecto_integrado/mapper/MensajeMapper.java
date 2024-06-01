package com.example.proyecto_integrado.mapper;

import com.example.proyecto_integrado.dto.MensajeDTO;
import com.example.proyecto_integrado.dto.OfertanteDTO;
import com.example.proyecto_integrado.models.Mensaje;
import com.example.proyecto_integrado.models.Ofertantes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MensajeMapper implements Mapper<Mensaje, MensajeDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MensajeDTO mapTo(Mensaje mensaje) {
        return modelMapper.map(mensaje, MensajeDTO.class);
    }

    @Override
    public Mensaje mapFrom(MensajeDTO mensajeDTO) {
        return modelMapper.map(mensajeDTO, Mensaje.class);
    }
}
