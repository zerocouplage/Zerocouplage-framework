/**
 * 
 */
package org.zerocouplage.common.logger;

import org.apache.log4j.Logger;

import org.zerocouplage.api.logger.IZCLogger;

/**
 * Main logger for logging things
 *
 *@author Mestari Salma vesrion 1.2.0
 */
public class ZCLoggerImpl implements IZCLogger{
	
	
	private static Logger logger ;
	public ZCLoggerImpl(Class<?> sourceClass) {
		logger = Logger.getLogger(sourceClass);
		
	}
	
	@Override
	public void error(String message) {
		logger.error("[ZCouplage] Error : "+message);
	}

	@Override
	public void error(String message, Exception exception) {
		logger.error("[ZCouplage] Error : "+message,exception);
		exception.printStackTrace();
	}

	@Override
	public void info(String message) {
		logger.info("[ZCouplage] Info : "+message);
	}

	@Override
	public void info(String message, Exception exception) {
		logger.info("[ZCouplage] Info : "+message,exception);
		exception.printStackTrace();
	}

	@Override
	public void trace(String message) {
		logger.trace("[ZCouplage] Trace : "+message);
	}

	@Override
	public void trace(String message, Exception exception) {
		logger.trace("[ZCouplage] Trace : "+message, exception);
		exception.printStackTrace();
	}

	@Override
	public void debug(String message) {
		logger.debug("[ZCouplage] Debug : "+message);
	}

	@Override
	public void debug(String message, Exception exception) {
		logger.debug("[ZCouplage] Debug : "+message,exception);
		exception.printStackTrace();
	}

	@Override
	public void fatal(String message) {
		logger.fatal("[ZCouplage] Fatal : "+message);
	}

	@Override
	public void fatal(String message, Exception exception) {
		logger.fatal("[ZCouplage] Fatal : "+message,exception);
		exception.printStackTrace();
	}

	@Override
	public void warn(String message) {
		System.err.println("[ZCouplage] Warn : "+message);
	}

	@Override
	public void warn(String message, Exception exception) {
		System.err.println("[ZCouplage] Warn : "+message);
		exception.printStackTrace();
	}

}
