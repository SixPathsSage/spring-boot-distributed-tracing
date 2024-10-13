package com.service.local.config;

import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OTLPConfiguration {

    @Bean
    OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${tracing.backend.url}") String url) {
        return OtlpHttpSpanExporter.builder()
                .setEndpoint(url)
                .build();
    }
}