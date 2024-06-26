package com.example.proyecto_integrado.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

  private Long id;

  private String usuario;
  private String nombre;
  private String apellidos;
  private String email;
  private String password;

  private String imagenPerfil;


  public UsuarioDTO() {}

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getImagenPerfil() {
    return imagenPerfil;
  }

  public void setImagenPerfil(String imagenPerfil) {
    this.imagenPerfil = imagenPerfil;
  }
}
