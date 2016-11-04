package com.telstra.springboot;

import java.lang.management.ManagementFactory;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringRestExceptionApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringRestExceptionApplication.class);

	private static ApplicationContext applicationContext = null;

	public static void main(String[] args) throws UnknownHostException {

		String mode = args != null && args.length > 0 ? args[0] : null;

		if (logger.isDebugEnabled()) {
			logger.debug("PID:" + ManagementFactory.getRuntimeMXBean().getName() + " Application mode:" + mode);
		}
		if (applicationContext != null && mode != null && "stop".equals(mode)) {
			System.exit(SpringApplication.exit(applicationContext, new ExitCodeGenerator() {
				@Override
				public int getExitCode() {
					logger.info("Shutdown entry point called.");
					logger.info("Spring boot app has been shut down");
					return 0;
				}
			}));
		}
		SpringApplication app = new SpringApplication(SpringRestExceptionApplication.class);
		app.setBannerMode(Mode.OFF);
		applicationContext = app.run(args);
		if (logger.isDebugEnabled()) {
			logger.debug("PID:" + ManagementFactory.getRuntimeMXBean().getName() + " Application started context");
		}
	}
}
