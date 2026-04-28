package com.melina;

import com.melina.servicio.ProcesadorLogServicio;
import com.melina.util.Respuesta;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
                "[INFO] Usuario inicio sesion",
                "[ERROR] Fallo de conexion",
                "[INFO] Archivo guardado",
                "[ERROR] Timeout en base de datos",
                "[WARNING] Memoria insuficiente"
        );

        ProcesadorLogServicio servicio = new ProcesadorLogServicio();
        List<String> logsTransformados = servicio.transformarLogs(logs);
        logsTransformados.forEach(System.out::println);

        System.out.println("\n--- Resumen de Logs ---");
        Respuesta<Map<String, Long>> resultado = servicio.procesarLogs(logs);

        if (resultado.isExito()) {
            resultado.getData().forEach((tipo, cantidad) ->
                    System.out.println("[" + tipo + "]: " + cantidad));
        } else {
            System.out.println("Error: " + resultado.getMensaje());
        }
    }
}