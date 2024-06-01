package com.example.proyecto_integrado.controllers;

import com.example.proyecto_integrado.dto.ConsumidorDTO;
import com.example.proyecto_integrado.dto.OfertanteDTO;
import com.example.proyecto_integrado.mapper.Mapper;
import com.example.proyecto_integrado.models.Consumidor;
import com.example.proyecto_integrado.models.Ofertantes;
import com.example.proyecto_integrado.services.ConsumidorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ConsumidorController {

    static final Logger logger = LoggerFactory.getLogger(ConsumidorController.class);

    @Autowired
    private ConsumidorService consumidorService;



    @Autowired private Mapper<Consumidor, ConsumidorDTO> consumidorMapper;

    // Obtener un profesor por su id
    @GetMapping(path = "/api/consumidor/{id}")
    public ResponseEntity<ConsumidorDTO> getConsumidor(@PathVariable Long id) {
        logger.info("Get usuario by id: " + id + ")");
       Optional<Consumidor> consumidor = consumidorService.findConsumidorById(id);
        if (consumidor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(consumidorMapper.mapTo(consumidor.get()), HttpStatus.OK);
    }

    // Obtener todos los profesores
    @GetMapping(path = "/api/consumidor")
    public ResponseEntity<Iterable<ConsumidorDTO>> getConsumidores() {
        logger.info("Get all profesores");
        List<Consumidor> consumidores = consumidorService.getAllConsumidor();
        List<ConsumidorDTO> consumidoresDTO = new ArrayList<>();
        for (Consumidor profesor : consumidores) {
            ConsumidorDTO usuarioDTO = consumidorMapper.mapTo(profesor);
            logger.info(usuarioDTO.toString());
            consumidoresDTO.add(usuarioDTO);
        }
        return new ResponseEntity<>(consumidoresDTO, HttpStatus.OK);
    }

    // Crear un consumer
    @PostMapping(path = "/api/consumidor")
    public ResponseEntity<ConsumidorDTO> createConsumidor(@RequestBody ConsumidorDTO consumidorDTO) {
        logger.info("Create consumidor: " + consumidorDTO.toString());
        Consumidor consumidor = consumidorMapper.mapFrom(consumidorDTO);

        Consumidor savedConsumidor = consumidorService.insertConsumidor(consumidor);
        logger.info("Saved consumidor: " + consumidor);
        return new ResponseEntity<>(consumidorMapper.mapTo(savedConsumidor), HttpStatus.CREATED);
    }

//    // Actualizar un consumer
//    @PutMapping(path = "/api/consumidor/{id}")
//    public ResponseEntity<ConsumidorDTO> updateConsumidor(
//            @PathVariable("id") Long id, @RequestBody ConsumidorDTO consumidorDTO) {
//        logger.info("Update consumidor: " + consumidorDTO.toString());
//
//        if (consumidorService.findConsumidorById(id).isEmpty()) {
//            logger.info("Consumidor not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        consumidorDTO.setId(id);
//        Consumidor consumidor = consumidorMapper.mapFrom(consumidorDTO);
//        Consumidor updatedProfesor = consumidorService.actualizarConsumidor(consumidor);
//        logger.info("Updated consumidor: " + updatedProfesor);
//        return new ResponseEntity<>(consumidorMapper.mapTo(updatedProfesor), HttpStatus.OK);
//    }


    @PatchMapping(path = "/api/consumidor/{id}")
    public ResponseEntity<ConsumidorDTO> updateConsumidor(
            @PathVariable("id") Long id, @RequestBody ConsumidorDTO ConsumidorDTO) {
        logger.info("Update ofertante: " + ConsumidorDTO.toString());

        Optional<Consumidor> existingConsumidor = consumidorService.findConsumidorById(id);
        if (!existingConsumidor.isPresent()) {
            logger.info("Consumidor not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {

            Consumidor Consumidor = existingConsumidor.get();
            if (ConsumidorDTO.getNombre() != null) {
                Consumidor.setNombre(ConsumidorDTO.getNombre());
            }
            if (ConsumidorDTO.getApellidos() != null) {
                Consumidor.setApellidos(ConsumidorDTO.getApellidos());
            }
            if (ConsumidorDTO.getEmail() != null) {
                Consumidor.setEmail(ConsumidorDTO.getEmail());
            }
            if (ConsumidorDTO.getCiudad() != null) {
                Consumidor.setCiudad(ConsumidorDTO.getCiudad());
            }
            if (ConsumidorDTO.getTelefono() != null) {
                Consumidor.setTelefono(ConsumidorDTO.getTelefono());
            }


            Consumidor updatedConsumidor = consumidorService.actualizarConsumidor(Consumidor);
            logger.info("Updated ofertante: " + updatedConsumidor);
            return new ResponseEntity<>(consumidorMapper.mapTo(updatedConsumidor), HttpStatus.OK);

        } catch (Exception e) {
            logger.error("Error updating Consumidor", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Borrar un profesor
    @DeleteMapping(path = "/api/consumidor/{id}")
    public ResponseEntity deleteConsumidor(@PathVariable("id") Long id) {
        logger.info("Delete consumidor: " + id);
        consumidorService.deleteConsumidor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
