package com.example.proyecto_integrado.controllers;

import com.example.proyecto_integrado.controllers.requests.AuthenticationRequest;
import com.example.proyecto_integrado.controllers.requests.RegisterRequest;
import com.example.proyecto_integrado.controllers.response.AuthenticationResponse;
import com.example.proyecto_integrado.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
  static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

  private final AuthenticationService authenticationService;

  public AuthenticationController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {

    return ResponseEntity.ok(authenticationService.registerConsumer(request));
  }


  @PostMapping("/register/ofertante")
  public ResponseEntity<AuthenticationResponse> registerOfertante(@RequestBody RegisterRequest request) {

    return ResponseEntity.ok(authenticationService.registerOfertante(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticateConsumer(
      @RequestBody AuthenticationRequest request) {
    logger.info("Authenticating user: {}", request);
    return ResponseEntity.ok(authenticationService.authenticateConsumer(request));
  }

  @PostMapping("/authenticate/ofertante")
  public ResponseEntity<AuthenticationResponse> authenticateOfertante(
          @RequestBody AuthenticationRequest request) {
    logger.info("Authenticating user: {}", request);
    return ResponseEntity.ok(authenticationService.authenticateOfertante(request));
  }


  @PostMapping("/imagen/{id}")
  public ResponseEntity<?> subirImagenPerfil(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
    try {
      authenticationService.guardarImagenPerfil(file, id);
      return ResponseEntity.ok().build();
    } catch (IOException e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen.");
    }
  }

}


