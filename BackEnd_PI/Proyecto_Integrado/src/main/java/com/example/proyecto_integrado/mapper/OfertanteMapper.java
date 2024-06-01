package com.example.proyecto_integrado.mapper;


import com.example.proyecto_integrado.dto.OfertanteDTO;

import com.example.proyecto_integrado.models.Ofertantes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OfertanteMapper implements Mapper<Ofertantes, OfertanteDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OfertanteDTO mapTo(Ofertantes ofertante) {
        return modelMapper.map(ofertante, OfertanteDTO.class);
    }

    @Override
    public Ofertantes mapFrom(OfertanteDTO ofertanteDTO) {
        return modelMapper.map(ofertanteDTO, Ofertantes.class);
    }
}
