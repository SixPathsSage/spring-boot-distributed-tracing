package com.service.local.config;

import io.micrometer.context.ContextSnapshotFactory;
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;
import org.springframework.core.task.support.ContextPropagatingTaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class OTLPConfiguration {

    @Bean
    OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${tracing.backend.url}") String url) {
        return OtlpHttpSpanExporter.builder()
                .setEndpoint(url)
                .build();
    }

    @Bean
    public TaskDecorator otelTaskDecorator() {
        return (runnable) ->  ContextSnapshotFactory.builder().build().captureAll(new Object[0]).wrap(runnable);
    }

    @Bean("asyncExecutorPool")
    public Executor asyncExecutorPool1(TaskDecorator otelTaskDecorator) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("threadPoolExecutor1");
        executor.setTaskDecorator(otelTaskDecorator);
        executor.initialize();
        return executor;
    }
}