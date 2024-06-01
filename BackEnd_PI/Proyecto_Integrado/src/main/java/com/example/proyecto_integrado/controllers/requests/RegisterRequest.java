package com.example.proyecto_integrado.controllers.requests;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class RegisterRequest {

  private String nombre;
  private String apellidos;
  private String email;
  private String password;

  private MultipartFile imagenPerfil;

  public RegisterRequest() {}

  public RegisterRequest(String nombre, String apellidos, String email, String password, MultipartFile imagenPerfil) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.email = email;
    this.password = password;
    this.imagenPerfil = imagenPerfil;
  }

  public RegisterRequest(String nombre, String apellidos, String email, String password) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.email = email;
    this.password = password;
  }

  @Override
  public String toString() {
    return "RegisterRequest{"
        + "firstName='"
        + nombre
        + '\''
        + ", lastName='"
        + apellidos
        + '\''
        + ", email='"
        + email
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RegisterRequest that = (RegisterRequest) o;
    return Objects.equals(nombre, that.nombre)
        && Objects.equals(apellidos, that.apellidos)
        && Objects.equals(email, that.email)
        && Objects.equals(password, that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, apellidos, email, password);
  }

  public String getFirstName() {
    return nombre;
  }

  public void setFirstName(String firstName) {
    this.nombre = firstName;
  }

  public String getLastName() {
    return apellidos;
  }

  public void setLastName(String lastName) {
    this.apellidos = lastName;
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

  public MultipartFile getImagenPerfil() {
    return imagenPerfil;
  }

  public void setImagenPerfil(MultipartFile imagenPerfil) {
    this.imagenPerfil = imagenPerfil;
  }
}
