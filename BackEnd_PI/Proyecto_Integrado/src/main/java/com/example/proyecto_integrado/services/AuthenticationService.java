package com.example.proyecto_integrado.services;

import com.example.proyecto_integrado.controllers.requests.AuthenticationRequest;
import com.example.proyecto_integrado.controllers.requests.RegisterRequest;
import com.example.proyecto_integrado.controllers.response.AuthenticationResponse;
import com.example.proyecto_integrado.models.*;
import com.example.proyecto_integrado.repositories.ConsumidorRepository;
import com.example.proyecto_integrado.repositories.OfertanteRepository;
import com.example.proyecto_integrado.repositories.UsuarioRepository;
import com.example.proyecto_integrado.security.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


@Service
public class AuthenticationService {

  static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

  private final UsuarioRepository usuarioRepository;

  @Autowired
  ConsumidorRepository consumidorRepository;

  @Autowired
  OfertanteRepository ofertanteRepository;

  private final PasswordEncoder passwordEncoder;

  private final JwtService jwtService;

  private final AuthenticationManager authenticationManager;

  public AuthenticationService(
      UsuarioRepository usuarioRepository,
      PasswordEncoder passwordEncoder,
      JwtService jwtService,
      AuthenticationManager authenticationManager) {
    this.usuarioRepository = usuarioRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }

  public AuthenticationResponse register(RegisterRequest request) {
    logger.info("Registering user: {}", request);
    Usuario usuario = new Usuario();
    usuario.setNombre(request.getFirstName());
    usuario.setUserName(request.getFirstName() + "_" + request.getLastName());
    usuario.setApellidos(request.getLastName());
    usuario.setEmail(request.getEmail());
    usuario.setPassword(passwordEncoder.encode(request.getPassword()));
    usuario.setRole("USER");
    usuario.setActivo(true);
    Usuario saved = usuarioRepository.save(usuario);
    String jwtToken = jwtService.generateToken(saved);
    return new AuthenticationResponse(jwtToken);
  }

  public void guardarImagenPerfil(MultipartFile file, Long id) throws IOException {
    Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
  logger.info(String.valueOf(file));
    if(!file.isEmpty()){

      Path directorioImagenes= Paths.get("src//main//resources//static/images");
      String rutaAbsoluta=directorioImagenes.toFile().getAbsolutePath();

      try{
        byte[] bytesImg= file.getBytes();

        Path rutaCompleta=Paths.get(rutaAbsoluta +"//"+ file.getOriginalFilename());

        Files.write(rutaCompleta, bytesImg);

        logger.info(file.getOriginalFilename());

        usuario.setImagenPerfil(file.getOriginalFilename());

      }catch (IOException e){
        e.printStackTrace();

      }


    }

    logger.info(usuario.toString());
    usuarioRepository.save(usuario);
  }


  public AuthenticationResponse registerConsumer(RegisterRequest request) {
    Set<Rol> roles=new HashSet<>();
    Rol rol1=new Rol();
    rol1.setRolNombre(RolNombre.ROLE_USER);
    roles.add(rol1);
    logger.info("Registering user: {}", request);

    Consumidor consumidor= new Consumidor();





    consumidor.setNombre(request.getFirstName());
    consumidor.setUserName(request.getFirstName() + "_" + request.getLastName());
    consumidor.setApellidos(request.getLastName());
    consumidor.setEmail(request.getEmail());
    consumidor.setPassword(passwordEncoder.encode(request.getPassword()));
    consumidor.setActivo(true);







    Usuario saved = usuarioRepository.save(consumidor);


    String jwtToken = jwtService.generateToken(saved);
    return new AuthenticationResponse(jwtToken, consumidor);
  }




  public AuthenticationResponse registerOfertante(RegisterRequest request) {
    Set<Rol> roles=new HashSet<>();
    Rol rol1=new Rol();
    rol1.setRolNombre(RolNombre.ROLE_USER);
    roles.add(rol1);
    logger.info("Registering user: {}", request);

    Ofertantes ofertante= new Ofertantes();



    ofertante.setNombre(request.getFirstName());
    ofertante.setUserName(request.getFirstName() + "_" + request.getLastName());
    ofertante.setApellidos(request.getLastName());
    ofertante.setEmail(request.getEmail());
    ofertante.setPassword(passwordEncoder.encode(request.getPassword()));
    ofertante.setActivo(true);



    Usuario saved = usuarioRepository.save(ofertante);


    String jwtToken = jwtService.generateToken(saved);
    return new AuthenticationResponse(jwtToken, ofertante);
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    logger.info("Authenticating user: {}", request);

    try {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    }catch (AuthenticationException e) {

      e.printStackTrace();
    }

    logger.info("User authenticated: {}", request);
    Usuario usuario = usuarioRepository.findByEmail(request.getEmail()).orElseThrow();
    logger.info(String.valueOf(usuario));
    logger.info("Authenticating user: {}", usuario);
    String jwtToken = jwtService.generateToken(usuario);
    logger.info("JWT Token: {}", jwtToken);
    return new AuthenticationResponse(jwtToken);
  }


  public AuthenticationResponse authenticateConsumer(AuthenticationRequest request) {
    logger.info("Authenticating user: {}", request);


    try {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    }catch (AuthenticationException e) {

      e.printStackTrace();
    }



    logger.info("User authenticated: {}", request);
    Consumidor usuario = consumidorRepository.findByEmail(request.getEmail()).orElseThrow();



    logger.info("Authenticating user: {}", usuario);
    String jwtToken = jwtService.generateToken(usuario);
    logger.info("JWT Token: {}", jwtToken);

    return new AuthenticationResponse(jwtToken, usuario);
  }


  public AuthenticationResponse authenticateOfertante(AuthenticationRequest request) {
    logger.info("Authenticating user: {}", request);


    try {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

    }catch (AuthenticationException e) {

      e.printStackTrace();
    }



    logger.info("User authenticated: {}", request);
    Ofertantes usuario = ofertanteRepository.findByEmail(request.getEmail()).orElseThrow();



    logger.info("Authenticating user: {}", usuario);
    String jwtToken = jwtService.generateToken(usuario);
    logger.info("JWT Token: {}", jwtToken);

    return new AuthenticationResponse(jwtToken, usuario);
  }




}
