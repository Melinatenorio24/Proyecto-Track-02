package com.melina.util;

import java.util.Optional;

public class Respuesta <T> {
    private final T datos;
    private final String error;

    private Respuesta(T datos, String error){
        this.datos = datos;
        this.error = error;
    }

    public static <T> Respuesta <T> exito(T datos) {
        return new Respuesta<>(datos, null);
    }

    public static <T> Respuesta <T> fallo(String error){
        return new Respuesta<>(null, error);
    }
    public Optional <T> obtenerDatos(){
        return Optional.ofNullable(datos);
    }
    public Optional <String> obtenerError(){
        return Optional.ofNullable(error);
    }
}
