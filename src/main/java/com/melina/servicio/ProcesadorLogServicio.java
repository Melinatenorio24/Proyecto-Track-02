package com.melina.servicio;

import com.melina.util.Respuesta;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProcesadorLogServicio {

    public List<String> transformarLogs(List<String> logs) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return Optional.ofNullable(logs)
                .orElse(List.of())
                .stream()
                .map(log -> "[" + LocalDateTime.now().format(formatter) + "] " + log.toUpperCase())
                .collect(Collectors.toList());
    }
    public Respuesta<Map<String, Long>> procesarLogs(List<String> logs) {
        return Optional.ofNullable(logs)
                .filter(lista -> !lista.isEmpty())
                .map(lista -> {
                    Map<String, Long> conteo = lista.stream()
                            .collect(Collectors.groupingBy(log -> log.split(" ")[0], Collectors.counting()));
                    return Respuesta.exito(conteo);
                })
                .orElse(Respuesta.fallo("La lista de logs está vacía o es nula"));
    }
}