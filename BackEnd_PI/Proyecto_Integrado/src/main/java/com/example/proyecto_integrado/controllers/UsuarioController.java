package com.example.proyecto_integrado.controllers;


import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UsuarioController {


    private final Path imageDir = Paths.get("src/main/resources/static/images");

    @GetMapping("/api/images/{imageName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = imageDir.resolve(imageName).normalize();
        Resource resource = new UrlResource(imagePath.toUri());

        if (resource.exists() || resource.isReadable()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // Cambia según el tipo de imagen
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            throw new RuntimeException("No se pudo cargar la imagen: " + imageName);
        }
    }


//    static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
//
//    @Autowired
//    private UsuarioService usuarioService;
//
//    @Autowired private ActividadService actividadService;
//
//    @Autowired private Mapper<Usuario, UsuarioDTO> usuarioMapper;
//
//    // Obtener un profesor por su id
//    @GetMapping(path = "/api/usuario/{id}")
//    public ResponseEntity<UsuarioDTO> getProfesor(@PathVariable Long id) {
//        logger.info("Get usuario by id: " + id + ")");
//       Optional<Usuario> usuario = usuarioService.findUsuarioById(id);
//        if (usuario.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(usuarioMapper.mapTo(usuario.get()), HttpStatus.OK);
//    }
//
//    // Obtener todos los profesores
//    @GetMapping(path = "/api/profesores")
//    public ResponseEntity<Iterable<UsuarioDTO>> getProfesores() {
//        logger.info("Get all profesores");
//        List<Usuario> usuarios = usuarioService.getAllUsuarios();
//        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
//        for (Usuario profesor : usuarios) {
//            UsuarioDTO usuarioDTO = usuarioMapper.mapTo(profesor);
//            logger.info(usuarioDTO.toString());
//            usuariosDTO.add(usuarioDTO);
//        }
//        return new ResponseEntity<>(usuariosDTO, HttpStatus.OK);
//    }
//
//    // Crear un profesor
//    @PostMapping(path = "/api/profesor")
//    public ResponseEntity<UsuarioDTO> createProfesor(@RequestBody UsuarioDTO profesorDTO) {
//        logger.info("Create profesor: " + profesorDTO.toString());
//        Usuario usuario = usuarioMapper.mapFrom(profesorDTO);
//
//        Usuario savedProfesor = usuarioService.insertUsuario(usuario);
//        logger.info("Saved profesor: " + usuario);
//        return new ResponseEntity<>(usuarioMapper.mapTo(savedProfesor), HttpStatus.CREATED);
//    }
//
//    // Actualizar un profesor
//    @PutMapping(path = "/api/profesor/{id}")
//    public ResponseEntity<UsuarioDTO> updateProfesor(
//            @PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
//        logger.info("Update profesor: " + usuarioDTO.toString());
//
//        if (usuarioService.findUsuarioById(id).isEmpty()) {
//            logger.info("Profesor not found");
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        usuarioDTO.setId(id);
//        Usuario usuario = usuarioMapper.mapFrom(usuarioDTO);
//        Usuario updatedProfesor = usuarioService.actualizarUsuario(usuario);
//        logger.info("Updated profesor: " + updatedProfesor);
//        return new ResponseEntity<>(usuarioMapper.mapTo(updatedProfesor), HttpStatus.OK);
//    }
//
//    // Borrar un profesor
//    @DeleteMapping(path = "/api/profesor/{id}")
//    public ResponseEntity deleteProfesor(@PathVariable("id") Long id) {
//        logger.info("Delete profesor: " + id);
//        usuarioService.deleteUsuario(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }



}
