package com.example.proyecto_integrado.controllers;

import com.example.proyecto_integrado.dto.ActividadDTO;
import com.example.proyecto_integrado.dto.MensajeDTO;
import com.example.proyecto_integrado.dto.OfertaDTO;
import com.example.proyecto_integrado.mapper.Mapper;
import com.example.proyecto_integrado.models.*;
import com.example.proyecto_integrado.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OfertasController {

    static final Logger logger = LoggerFactory.getLogger(ActividadController.class);

    @Autowired
    private OfertaService ofertaService;

    @Autowired
    private OfertanteService ofertanteService;

    @Autowired
    private ConsumidorService consumidorService;




    @Autowired private Mapper<Ofertas, OfertaDTO> ofertaMapper;



    @GetMapping("/api/ofertas/{id}")
    public List<Ofertas> listarTodosLasOfertasPorOfertanteId(@PathVariable("id") Long id) {

        Ofertantes ofertante=ofertanteService.findOfertantesById(id).get();



        return ofertaService.getOfertasByOfertante(ofertante);

    }


    @PostMapping("/api/ofertas")
    public ResponseEntity<OfertaDTO> createMensaje(@RequestBody OfertaDTO ofertaDTO){

        Ofertas oferta=ofertaMapper.mapFrom(ofertaDTO);

        Ofertantes ofertante= ofertanteService.findOfertantesById(ofertaDTO.getOfertante_id()).get();
        Consumidor consumidor= consumidorService.findConsumidorById(ofertaDTO.getConsumidor_id()).get();

        oferta.setOfertante(ofertante);
        oferta.setConsumidor(consumidor);


        Ofertas saved=ofertaService.insertOfertas(oferta);



        return new ResponseEntity<>(ofertaMapper.mapTo(saved), HttpStatus.CREATED);

    }
}
