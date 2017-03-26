/**
 * 
 */
package org.zerocouplage.api.logger;

/**
 * Main logger interface for logging things
 * 
 */
public interface IZCLogger {

	public void error(String message);

	public void error(String message, Exception exception);

	public void info(String message);

	public void info(String message, Exception exception);

	public void trace(String message);

	public void trace(String message, Exception exception);

	public void debug(String message);

	public void debug(String message, Exception exception);

	public void fatal(String message);

	public void fatal(String message, Exception exception);

	public void warn(String message);

	public void warn(String message, Exception exception);

}
