package com.example.proyecto_integrado.controllers;

import com.example.proyecto_integrado.dto.ActividadDTO;
import com.example.proyecto_integrado.dto.ConsumidorDTO;
import com.example.proyecto_integrado.mapper.Mapper;
import com.example.proyecto_integrado.models.*;
import com.example.proyecto_integrado.repositories.ForoRepository;
import com.example.proyecto_integrado.repositories.MensajeRepository;
import com.example.proyecto_integrado.services.*;
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
public class ActividadController {


    static final Logger logger = LoggerFactory.getLogger(ActividadController.class);

    @Autowired
    private ActividadService actividadService;

    @Autowired
    private OfertanteService ofertanteService;

    @Autowired
    private ConsumidorService consumidorService;

    @Autowired
    private ForoService foroService;

    @Autowired
    private MensajeService mensajeService;

    @Autowired
    private CategoriaService categoriaService;



    @Autowired private Mapper<Actividad, ActividadDTO> actividadMapper;
    @Autowired
    private ForoRepository foroRepository;
    @Autowired
    private MensajeRepository mensajeRepository;

    // Obtener un profesor por su id
    @GetMapping(path = "/api/actividad/{id}")
    public ResponseEntity<ActividadDTO> getActividad(@PathVariable Long id) {
        logger.info("Get act by id: " + id + ")");
        Optional<Actividad> actividad = actividadService.findActividadById(id);
        if (actividad.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actividadMapper.mapTo(actividad.get()), HttpStatus.OK);
    }

    // Obtener todos los profesores
    @GetMapping(path = "/api/actividad")
    public ResponseEntity<Iterable<ActividadDTO>> getActividades() {
        logger.info("Get all profesores");
        List<Actividad> actividades = actividadService.getAllActividades();
        List<ActividadDTO> actividadesDTO = new ArrayList<>();
        for (Actividad actividad : actividades) {
            ActividadDTO actividadDTO = actividadMapper.mapTo(actividad);
            logger.info(actividadDTO.toString());
            actividadesDTO.add(actividadDTO);
        }
        return new ResponseEntity<>(actividadesDTO, HttpStatus.OK);
    }

    @GetMapping("/api/actividad/list")
    public List<Actividad> listarTodosLasActividades() {
        return actividadService.getAllActividades();

    }

//    // Crear un profesor
//    @PostMapping(path = "/api/actividad")
//    public ResponseEntity<ActividadDTO> createActividad(@RequestBody ActividadDTO actividadDTO) {
//        logger.info("Create act: " + actividadDTO.toString());
//
//        try {
//            Actividad actividad = actividadMapper.mapFrom(actividadDTO);
//
//
//            Optional<Ofertantes> of = ofertanteService.findOfertantesById(actividadDTO.getOfertanteid());
//
//            actividad.setOfertante(of.get());
//
//
//            logger.info("Saved ac: " + actividad);
//
//            //creación de foro junto a actividad
//            Foro foro = new Foro();
//
//            foro.setOfertante(actividad.getOfertante());
//            foro.setNombre(actividad.getNombre());
////            foro.setActividad(savedActividad);
//            foroService.insertForo(foro);
//
//            actividad.setForo(foro);
//
//            Actividad savedActividad = actividadService.insertarActividad(actividad);
//
//            foro.setActividad(savedActividad);
//
//            return new ResponseEntity<>(actividadMapper.mapTo(savedActividad), HttpStatus.CREATED);
//
//        }catch(Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        }
//
//    }
//
//    // Actualizar un profesor
//    @PutMapping(path = "/api/actividad/{id}")
//    public ResponseEntity<ActividadDTO> updateActividad(
//            @PathVariable("id") Long id, @RequestBody ActividadDTO actividadDTO) {
//        logger.info("Update consumidor: " + actividadDTO.toString());
//
//        if (actividadService.findActividadById(id).isEmpty()) {
//            logger.info("Act not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        try {
//
//            Optional<Ofertantes> of = ofertanteService.findOfertantesById(actividadDTO.getOfertanteid());
//
//            logger.info(String.valueOf(actividadDTO.getConsumidorid()));
//            Optional<Consumidor> con = consumidorService.findConsumidorById(actividadDTO.getConsumidorid());
//
//
//
//            logger.info(String.valueOf(con));
//
//            Actividad actividadGet=actividadService.findActividadById(id).get();
//
//            logger.info(String.valueOf(actividadGet));
//
//
//            actividadDTO.setId(id);
//            Actividad actividad = actividadMapper.mapFrom(actividadDTO);
//
//            actividad.setOfertante(of.get());
//            actividad.addConsumidor(con.get());
//
//            Foro foro = actividadGet.getForo();
//            foro.addConsumidor(con.get());
//
//            Foro updatedForo = foroService.actualizarForo(foro);
//            Actividad updatedActividad = actividadService.actualizarActividad(actividad);
//            logger.info("Updated act: " + updatedActividad);
//            return new ResponseEntity<>(actividadMapper.mapTo(updatedActividad), HttpStatus.OK);
//        }catch(Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        }
//    }

    @PostMapping(path = "/api/actividad")
    public ResponseEntity<ActividadDTO> createActividad(@RequestBody ActividadDTO actividadDTO) {
        logger.info("Create act: " + actividadDTO.toString());

        try {
            // Mapear DTO a entidad Actividad
            Actividad actividad = actividadMapper.mapFrom(actividadDTO);

            // Buscar y asignar el ofertante
            Optional<Ofertantes> ofertanteOptional = ofertanteService.findOfertantesById(actividadDTO.getOfertanteid());
            if (!ofertanteOptional.isPresent()) {
                // Si no se encuentra el ofertante, devuelve un error
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Ofertantes ofertante = ofertanteOptional.get();
            actividad.setOfertante(ofertante);

            // Crear el foro y asignarle el ofertante y el nombre de la actividad
            Foro foro = new Foro();
            foro.setOfertante(ofertante);
            foro.setNombre(actividad.getNombre());
            // Guardar el foro
            foroService.insertForo(foro);

            // Asociar el foro a la actividad y viceversa
            actividad.setForo(foro);
            foro.setActividad(actividad);

            // Guardar la actividad
            Actividad savedActividad = actividadService.insertarActividad(actividad);

            // Devolver la respuesta con la actividad guardada
            return new ResponseEntity<>(actividadMapper.mapTo(savedActividad), HttpStatus.CREATED);

        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


//    @PostMapping(path = "/api/actividad")
//    public ResponseEntity<ActividadDTO> createActividad(@RequestBody ActividadDTO actividadDTO) {
//        logger.info("Create act: " + actividadDTO.toString());
//
//        try {
//            Actividad actividad = actividadMapper.mapFrom(actividadDTO);
//
//            Optional<Ofertantes> of = ofertanteService.findOfertantesById(actividadDTO.getOfertanteid());
//            actividad.setOfertante(of.get());
//
//            // Crear el foro junto con la actividad
//            Foro foro = new Foro();
//            foro.setOfertante(actividad.getOfertante());
//            foro.setNombre(actividad.getNombre());
//            foroService.insertForo(foro);
//
//            // Asociar el foro a la actividad y viceversa
//            actividad.setForo(foro);
//            foro.setActividad(actividad);
//
//            Mensaje mensaje=new Mensaje();
//            mensaje.setContenido(actividadDTO.getDescripcion());
//            mensaje.setTitulo(actividadDTO.getNombre());
//            mensaje.setUsuario(of.get());
//            mensaje.setForo(foro);
//
//            mensajeService.insertMensaje(mensaje);
//
//            Actividad savedActividad = actividadService.insertarActividad(actividad);
//
//            return new ResponseEntity<>(actividadMapper.mapTo(savedActividad), HttpStatus.CREATED);
//
//        } catch(Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    @PatchMapping(path = "/api/actividad/{id}")
    public ResponseEntity<ActividadDTO> patchActividad(
            @PathVariable("id") Long id, @RequestBody ActividadDTO actividadDTO) {
        logger.info("Update actividad: " + actividadDTO);

        // Verificar si la actividad existe
        Optional<Actividad> actividadOpt = actividadService.findActividadById(id);
        if (actividadOpt.isEmpty()) {
            logger.info("Actividad not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Verificar si el ofertante existe
        Optional<Ofertantes> ofertanteOpt = ofertanteService.findOfertantesById(actividadDTO.getOfertanteid());
        if (ofertanteOpt.isEmpty()) {
            logger.info("Ofertante not found");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            // Mapear DTO a entidad y actualizar campos necesarios
            Actividad actividad = actividadMapper.mapFrom(actividadDTO);
            actividad.setId(id);
            actividad.setOfertante(ofertanteOpt.get());

            // Obtener el foro asociado a la actividad existente
            Actividad actividadExistente = actividadOpt.get();
            Foro foro = actividadExistente.getForo();

            // Aquí podrías añadir lógica para actualizar el foro si es necesario
            // foroService.actualizarForo(foro); // Descomentar si se necesita actualizar el foro

            // Actualizar la actividad
            Actividad updatedActividad = actividadService.actualizarActividad(actividad);

            // Mapear la entidad actualizada a DTO y retornar la respuesta
            return new ResponseEntity<>(actividadMapper.mapTo(updatedActividad), HttpStatus.OK);
        } catch(Exception e) {
            logger.error("Error updating actividad: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PutMapping(path = "/api/actividad/edit/{id}")
//    public ResponseEntity<ActividadDTO> updateActividad(
//            @PathVariable("id") Long id, @RequestBody ActividadDTO actividadDTO) {
//        logger.info("Update actividad: " + actividadDTO.toString());
//
//        if (actividadService.findActividadById(id).isEmpty()) {
//            logger.info("Actividad not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        try {
//            Optional<Ofertantes> of = ofertanteService.findOfertantesById(actividadDTO.getOfertanteid());
////            Optional<Consumidor> con = consumidorService.findConsumidorById(actividadDTO.getConsumidorid());
//
//            Actividad actividad = actividadMapper.mapFrom(actividadDTO);
//            actividad.setId(id);
//            actividad.setOfertante(of.get());
////            actividad.addConsumidor(con.get());
//
//            // Obtener el foro asociado a la actividad
//            Actividad actividadGet = actividadService.findActividadById(id).get();
//            Foro foro = actividadGet.getForo();
//            // Añadir el consumidor al foro
////            foro.addConsumidor(con.get());
//
//
//
//            // Actualizar el foro y la actividad
//            foroService.actualizarForo(foro);
//
//            Actividad updatedActividad = actividadService.actualizarActividad(actividad);
//
//            return new ResponseEntity<>(actividadMapper.mapTo(updatedActividad), HttpStatus.OK);
//        } catch(Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }


    @PutMapping(path = "/api/actividad/update/{id}")
    public ResponseEntity<ActividadDTO> updateActividad(
            @PathVariable("id") Long id, @RequestBody ActividadDTO actividadDTO) {
        logger.info("Update actividad: " + actividadDTO.toString());

        Optional<Actividad> optionalActividad = actividadService.findActividadById(id);
        if (optionalActividad.isEmpty()) {
            logger.info("Actividad not found");
            return ResponseEntity.notFound().build();
        }

        try {
            Optional<Ofertantes> optionalOfertante = ofertanteService.findOfertantesById(actividadDTO.getOfertanteid());
            Optional<Consumidor> optionalConsumidor = consumidorService.findConsumidorById(actividadDTO.getConsumidorid());

            if (optionalOfertante.isEmpty() || optionalConsumidor.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            Actividad actividad = actividadMapper.mapFrom(actividadDTO);
            actividad.setId(id);
            actividad.setOfertante(optionalOfertante.get());
            actividad.addConsumidor(optionalConsumidor.get());

            Optional<Actividad> optionalActividadUpdated = Optional.ofNullable(actividadService.actualizarActividad(actividad));
            if (optionalActividadUpdated.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }

            Actividad updatedActividad = optionalActividadUpdated.get();

            // Obtener el foro asociado a la actividad
            Foro foro = updatedActividad.getForo();
            if (foro != null) {
                // Añadir el consumidor al foro
                optionalConsumidor.ifPresent(foro::addConsumidor);
            }

            Mensaje mensaje = new Mensaje();
            mensaje.setContenido(actividadDTO.getDescripcion());
            mensaje.setTitulo(actividadDTO.getNombre());
            mensaje.setUsuario(optionalOfertante.get());
            mensaje.setForo(foro);

            foroService.actualizarForo(foro);
            mensajeService.insertMensaje(mensaje);

            return ResponseEntity.ok(actividadMapper.mapTo(updatedActividad));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    // Borrar un profesor
    @DeleteMapping(path = "/api/actividad/{id}")
    public ResponseEntity deleteActividad(@PathVariable("id") Long id) {
        logger.info("Delete act: " + id);
        actividadService.deleteActividad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api/actividad/categorias")
    public List<Categoria> listarTodosLasCategorias() {
        return categoriaService.getAllCategorias();

    }




}
