package edu.esprit.app.utils;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

	private CustomLogger logger;

	public void setLogger(CustomLogger logger) {
		this.logger = logger;
	}

	public void logBefore(JoinPoint joinPoint) {

		logger.log("-------> Start execution of [ "
				+ joinPoint.getSignature().getName() + " ]");
	}

	public void logAfter(JoinPoint joinPoint) {
		logger.log("-------> End execution of [ "
				+ joinPoint.getSignature().getName() + " ]");
	}

}
