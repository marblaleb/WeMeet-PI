package com.example.proyecto_integrado.controllers;

import com.example.proyecto_integrado.dto.ActividadDTO;
import com.example.proyecto_integrado.dto.MensajeDTO;
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
public class ForoController {

    static final Logger logger = LoggerFactory.getLogger(ActividadController.class);

    @Autowired
    private ActividadService actividadService;

    @Autowired
    private UsuarioService usuarioService;


    @Autowired
    private ForoService foroService;

    @Autowired
    private MensajeService mensajeService;

    @Autowired private Mapper<Mensaje, MensajeDTO> mensajeMapper;

//    @GetMapping("/api/foro/{id}")
//    public List<Mensaje> listarTodosLosMensajesPorIdUsuario(@PathVariable("id") Long id) {
//
//
//
//
//        return mensajeRepository.findByForo_Id(id);
//
//    }


    @GetMapping("/api/foro/mensajes/{id}")
    public List<Mensaje> listarTodosLosMensajesPorForoId(@PathVariable("id") Long id) {

        Optional<Foro> foro= foroService.findForoById(id);


        return mensajeService.findMensajebyForo(foro.get());

    }

    @GetMapping("/api/foro/{id}")
    public Foro listarForo(@PathVariable("id") Long id) {

        Optional<Foro> foro= foroService.findForoById(id);


        return foro.get();

    }


    @PostMapping("/api/foro")
    public ResponseEntity<MensajeDTO> createMensaje(@RequestBody MensajeDTO mensajeDTO){

        try {



            Mensaje mensaje = new Mensaje();

            Optional<Usuario> usuario = usuarioService.findUsuarioById(mensajeDTO.getUsuario_id());
            Optional<Foro> foro = foroService.findForoById(mensajeDTO.getForo_id());

            mensaje.setUsuario(usuario.get());
            mensaje.setForo(foro.get());
            mensaje.setContenido(mensajeDTO.getContenido());
            mensaje.setTitulo(mensajeDTO.getTitulo());

            logger.info(String.valueOf(mensaje));


            Mensaje saved = mensajeService.insertMensaje(mensaje);

            mensajeDTO.setUsuario(usuario.get());
            mensajeDTO.setForo(foro.get());


            return new ResponseEntity<>(mensajeDTO, HttpStatus.CREATED);


        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }



}
