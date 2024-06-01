package com.example.proyecto_integrado.controllers;

import com.example.proyecto_integrado.dto.OfertanteDTO;
import com.example.proyecto_integrado.mapper.Mapper;
import com.example.proyecto_integrado.models.Ofertantes;
import com.example.proyecto_integrado.services.OfertanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class OfertanteController {

    static final Logger logger = LoggerFactory.getLogger(OfertanteController.class);
    @Autowired
    private OfertanteService ofertanteService;





    @Autowired private Mapper<Ofertantes, OfertanteDTO> ofertanteMapper;



    // Obtener un profesor por su id
    @GetMapping(path = "/api/ofertante/{id}")
    public ResponseEntity<OfertanteDTO> getConsumidor(@PathVariable Long id) {
        logger.info("Get usuario by id: " + id + ")");
        Optional<Ofertantes> ofertante = ofertanteService.findOfertantesById(id);
//        if (ofertante.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }


        return new ResponseEntity<>(ofertanteMapper.mapTo(ofertante.get()), HttpStatus.OK);
    }

    // Obtener todos los profesores
    @GetMapping(path = "/api/ofertante")
    public ResponseEntity<Iterable<OfertanteDTO>> getConsumidores() {
        logger.info("Get all profesores");
        List<Ofertantes> ofertantes = ofertanteService.getAllOfertantes();
        List<OfertanteDTO> ofertantesDTO = new ArrayList<>();
        for (Ofertantes ofertante : ofertantes) {
            OfertanteDTO ofertanteDTO = ofertanteMapper.mapTo(ofertante);
            logger.info(ofertanteDTO.toString());
            ofertantesDTO.add(ofertanteDTO);
        }
        return new ResponseEntity<>(ofertantesDTO, HttpStatus.OK);
    }

    // Crear un profesor
    @PostMapping(path = "/api/ofertante")
    public ResponseEntity<OfertanteDTO> createOfertante(@RequestBody OfertanteDTO ofertanteDTO) {
        logger.info("Create ofertante: " + ofertanteDTO.toString());
        Ofertantes ofertante = ofertanteMapper.mapFrom(ofertanteDTO);

        Ofertantes savedOfertante = ofertanteService.insertOfertantes(ofertante);
        logger.info("Saved ofertante: " + ofertante);
        return new ResponseEntity<>(ofertanteMapper.mapTo(savedOfertante), HttpStatus.CREATED);
    }

//    // Actualizar un profesor
//    @PatchMapping(path = "/api/ofertante/{id}")
//    public ResponseEntity<OfertanteDTO> updateOfertante(
//            @PathVariable("id") Long id, @RequestBody OfertanteDTO ofertanteDTO) {
//        logger.info("Update consumidor: " + ofertanteDTO.toString());
//
//        if (ofertanteService.findOfertantesById(id).isEmpty()) {
//            logger.info("Ofertante not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        try {
//
//            ofertanteDTO.setId(id);
//            Ofertantes ofertante = ofertanteMapper.mapFrom(ofertanteDTO);
//            Ofertantes updatedOfertante = ofertanteService.actualizarOfertantes(ofertante);
//            logger.info("Updated ofertante: " + updatedOfertante);
//            return new ResponseEntity<>(ofertanteMapper.mapTo(updatedOfertante), HttpStatus.OK);
//
//        }catch(Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }



    @PatchMapping(path = "/api/ofertante/{id}")
        public ResponseEntity<OfertanteDTO> updateOfertante(
                @PathVariable("id") Long id, @RequestBody OfertanteDTO ofertanteDTO) {
            logger.info("Update ofertante: " + ofertanteDTO.toString());

            Optional<Ofertantes> existingOfertante = ofertanteService.findOfertantesById(id);
            if (!existingOfertante.isPresent()) {
                logger.info("Ofertante not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            try {

                Ofertantes ofertante = existingOfertante.get();
                if (ofertanteDTO.getNombre() != null) {
                    ofertante.setNombre(ofertanteDTO.getNombre());
                }
                if (ofertanteDTO.getApellidos() != null) {
                    ofertante.setApellidos(ofertanteDTO.getApellidos());
                }
                if (ofertanteDTO.getEmail() != null) {
                    ofertante.setEmail(ofertanteDTO.getEmail());
                }
                if (ofertanteDTO.getCiudad() != null) {
                    ofertante.setCiudad(ofertanteDTO.getCiudad());
                }
                if (ofertanteDTO.getTelefono() != null) {
                    ofertante.setTelefono(ofertanteDTO.getTelefono());
                }


                Ofertantes updatedOfertante = ofertanteService.actualizarOfertantes(ofertante);
                logger.info("Updated ofertante: " + updatedOfertante);
                return new ResponseEntity<>(ofertanteMapper.mapTo(updatedOfertante), HttpStatus.OK);

            } catch (Exception e) {
                logger.error("Error updating ofertante", e);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }




//    @PutMapping(path = "/api/ofertante/{id}")
//    public ResponseEntity<OfertanteDTO> modificarOfertante(
//            @PathVariable("id") Long id, @RequestBody OfertanteDTO ofertanteDTO) {
//        logger.info("Update consumidor: " + ofertanteDTO.toString());
//
//        if (ofertanteService.findOfertantesById(id).isEmpty()) {
//            logger.info("Ofertante not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        ofertanteDTO.setId(id);
//        Ofertantes ofertante = ofertanteMapper.mapFrom(ofertanteDTO);
//        Ofertantes updatedOfertante = ofertanteService.actualizarOfertantes(ofertante);
//        logger.info("Updated ofertante: " + updatedOfertante);
//        return new ResponseEntity<>(ofertanteMapper.mapTo(updatedOfertante), HttpStatus.OK);
//    }

    // Borrar un profesor
    @DeleteMapping(path = "/api/ofertante/{id}")
    public ResponseEntity deleteOfertante(@PathVariable("id") Long id) {
        logger.info("Delete consumidor: " + id);
        ofertanteService.deleteOfertantes(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
