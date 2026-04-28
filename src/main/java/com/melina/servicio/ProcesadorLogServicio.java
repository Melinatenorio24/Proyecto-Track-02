package com.melina.servicio;
import com.melina.util.Respuesta;
import java.util.*;
import java.util.stream.Collectors;

public class ProcesadorLogServicio {

    public Respuesta<Map<String, Long>> contarTiposDeLog(List<String> logs) {
        return Optional.ofNullable(logs)
                .filter(lista -> !lista.isEmpty())
                .map(lista -> {
                    Map<String, Long> conteo = lista.stream()
                            .filter(log -> log != null && log.contains("[") && log.contains("]"))
                            .collect(Collectors.groupingBy(
                                    log -> log.substring(0, log.indexOf("]") + 1),
                                    Collectors.counting()
                            ));
                    return Respuesta.exito(conteo);
                })
                .orElse(Respuesta.fallo("La lista de logs esta vacia o es nula"));
    }

    public List<String> transformarLogs(List<String> logs) {
        return logs.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}