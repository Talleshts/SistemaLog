package com.ufes.sistemalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogAdapterFactory {
    private static final Map<String, ILogAdapter> logMap = new HashMap<>();

    static {
        // Inicializa o mapa com as implementações
        logMap.put("JSON", new LogJsonAdapter());
        logMap.put("CSV", new LogCsvAdapter());
    }

    public static List<ILogAdapter> getLogAdapters() {
        String tiposLog = LogConfig.getTipoLogSelecionado();
        List<ILogAdapter> adapters = new ArrayList<>();
        String[] typeArray = tiposLog.split(",");
        for (String type : typeArray) {
            ILogAdapter adapter = logMap.get(type.trim().toUpperCase());
            if (adapter != null) {
                adapters.add(adapter);
            }
        }
        return adapters.isEmpty() ? List.of(new LogJsonAdapter()) : adapters;
    }
}