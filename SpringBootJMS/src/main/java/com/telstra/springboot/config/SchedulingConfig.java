package com.telstra.springboot.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.telstra.springboot.schedule.ScheduledTaskRegistrarService;

@Configuration

@EnableScheduling
public class SchedulingConfig implements SchedulingConfigurer {

	@Autowired
	private ScheduledTaskRegistrarService scheduledTaskRegistrarService;

	@Bean(destroyMethod = "shutdown")
	public Executor taskScheduler() {
		return Executors.newScheduledThreadPool(100);
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskScheduler());
		// scheduledTaskRegistrarService.setScheduledTaskRegistrar(taskRegistrar);

	}

}
