package com.example.proyecto_integrado.mapper;

public interface Mapper<A, B> {

  B mapTo(A a);

  A mapFrom(B b);
}
