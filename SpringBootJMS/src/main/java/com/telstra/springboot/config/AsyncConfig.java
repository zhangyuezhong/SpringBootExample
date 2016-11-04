package com.telstra.springboot.config;

import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

//@Configuration
//@EnableAsync
public class AsyncConfig implements AsyncConfigurer

{

	// @Bean(destroyMethod = "shutdown")
	// public Executor taskExecutor() {
	// return Executors.newCachedThreadPool();
	// }

	@Bean
	public Executor taskExecutor() {
		// ThreadPoolTaskExecutor is spring managed bean, not need to call
		// shutdown
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(7);
		executor.setMaxPoolSize(42);
		executor.setQueueCapacity(11);
		executor.setThreadNamePrefix("MyExecutor-");
		return executor;
	}

	@Override
	public Executor getAsyncExecutor() {
		return taskExecutor();
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return (throwable, method, objects) -> throwable.printStackTrace();
	}

}
