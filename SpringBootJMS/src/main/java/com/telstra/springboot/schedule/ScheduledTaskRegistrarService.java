package com.telstra.springboot.schedule;

import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTaskRegistrarService {


	private ScheduledTaskRegistrar scheduledTaskRegistrar;

	public ScheduledTaskRegistrar getScheduledTaskRegistrar() {
		return scheduledTaskRegistrar;
	}

	public void setScheduledTaskRegistrar(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		this.scheduledTaskRegistrar = scheduledTaskRegistrar;
	}
	
}
