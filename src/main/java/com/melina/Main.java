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
                );
        ProcesadorLogServicio servicio = new ProcesadorLogServicio();
        Respuesta<Map<String, Long>> resultado = servicio.contarTiposDeLog(logs);

        System.out.println("Resultado del procesamiento: " + resultado.getData());

    }
}
