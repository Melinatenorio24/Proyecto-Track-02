package com.melina.servicio;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.melina.util.Respuesta;

public class ProcesadorLogServicio {
    public Respuesta<Map<String, Long>> contarTiposDeLog(List<String>){
        if (logs == null || logs.empty()){
            return Respuesta.fallo("La lista de logs esta vacia o es nula");
        }
        Map<String, Long> conteo = logs.stream()
                .filter(log -> log.contains("[") && log.contains("]"))
                .collect(Collectors.groupingBy(log -> log.substring(0, log.index0f("]") + 1), Collectors.counting()));
        return Respuesta.exito(conteo);
    }
    public List<String> transformarLogs(List<String> logs){
        return logs.stream(
                .map(String::toUpperCase)
                .collect(Collectors.toList());

    }
}
