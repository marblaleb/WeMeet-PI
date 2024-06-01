package com.example.proyecto_integrado.controllers.response;

import com.example.proyecto_integrado.models.Usuario;

import java.util.Objects;

public class AuthenticationResponse {
  private final String token;

  private Usuario usuario;

  public AuthenticationResponse(String token) {
    this.token = token;


  }

  public AuthenticationResponse(String token, Usuario usuario) {
    this.token = token;
    this.usuario=usuario;


  }

  public AuthenticationResponse() {
    this.token = null;
  }

  @Override
  public String toString() {
    return "AuthenticationResponse{" + "token='" + token + '\'' + "usuario: "+ usuario + '}';
  }

//  @Override
//  public boolean equals(Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//    AuthenticationResponse that = (AuthenticationResponse) o;
//    return Objects.equals(token, that.token);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(token);
//  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AuthenticationResponse that = (AuthenticationResponse) o;
    return Objects.equals(token, that.token) && Objects.equals(usuario, that.usuario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, usuario);
  }

  public String getToken() {
    return token;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
