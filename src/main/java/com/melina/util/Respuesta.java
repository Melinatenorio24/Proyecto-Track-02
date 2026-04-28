package com.melina.util;

import java.util.Optional;

public class Respuesta<T> {
    private final T data;
    private final String mensaje;
    private final boolean exito;

    public Respuesta(T data, String mensaje, boolean exito) {
        this.data = data;
        this.mensaje = mensaje;
        this.exito = exito;
    }

    public static <T> Respuesta<T> exito(T data) {
        return new Respuesta<>(data, "Operacion exitosa", true);
    }

    public static <T> Respuesta<T> fallo(String mensaje) {
        return new Respuesta<>(null, mensaje, false);
    }

    public T getData() { return data; }
    public String getMensaje() { return mensaje; }
    public boolean isExito() { return exito; }
}