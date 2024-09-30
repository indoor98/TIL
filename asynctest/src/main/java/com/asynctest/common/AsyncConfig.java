package com.asynctest.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);  // 기본 스레드 수
        executor.setMaxPoolSize(1);   // 최대 스레드 수
        executor.setQueueCapacity(0); // 큐에 대기할 수 있는 작업 수
        executor.setThreadNamePrefix("AsyncThread-");  // 스레드 이름 프리픽스
        executor.initialize();
        return executor;
    }
}