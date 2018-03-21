package com.emp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeMain implements ApplicationRunner {
	private static final Logger logger = LogManager.getLogger(EmployeeMain.class);

	public static void main(String arg[]) {
		SpringApplication.run(EmployeeMain.class, arg);
	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Hey, This is a warning!");
		logger.error("Oops! We have an Error. OK");
		logger.fatal("Damn! Fatal error. Please fix me.");

	}
}
