package com.springboot.sse.config;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(AsyncConfig.class);

	@Bean
	public Executor taskExecutor() {
		// ThreadPoolTaskExecutor is spring managed bean, not need to call
		// shutdown
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(6);
		executor.setThreadNamePrefix("MyExecutor-");
		return executor;
	}

	@Override
	public Executor getAsyncExecutor() {
		return taskExecutor();
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return (throwable, method, objects) -> logger.error(method.getName(), throwable);
	}

}