package com.example.proyecto_integrado.mapper;

import com.example.proyecto_integrado.dto.ActividadDTO;
import com.example.proyecto_integrado.models.Actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ActividadMapperImpl implements Mapper<Actividad, ActividadDTO>{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ActividadDTO mapTo(Actividad actividad) {
        return modelMapper.map(actividad, ActividadDTO.class);
    }

    @Override
    public Actividad mapFrom(ActividadDTO actividadDTO) {
        return modelMapper.map(actividadDTO, Actividad.class);
    }


}
