/**
 * 
 */
package org.zerocouplage.common.logger;

import org.zerocouplage.api.logger.IZCLogger;

/**
 * <p>A factory for creating IZCLogger instances to handle logging things</p>
 * @see IZCLogger
 *
 */
public class ZCLoggerFactory {
	
	public static IZCLogger getLogger(Class<?> sourceClass)
	{
		return new ZCLoggerImpl(sourceClass);
	}

}
