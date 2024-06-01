package com.example.proyecto_integrado.mapper;

import com.example.proyecto_integrado.dto.MensajeDTO;
import com.example.proyecto_integrado.dto.OfertaDTO;
import com.example.proyecto_integrado.models.Mensaje;
import com.example.proyecto_integrado.models.Ofertas;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfertaMapper implements Mapper<Ofertas, OfertaDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OfertaDTO mapTo(Ofertas oferta) {
        return modelMapper.map(oferta, OfertaDTO.class);
    }

    @Override
    public Ofertas mapFrom(OfertaDTO ofertaDTO) {
        return modelMapper.map(ofertaDTO, Ofertas.class);
    }
}
