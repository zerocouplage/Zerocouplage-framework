package org.zerocouplage.impl.config;

import java.util.HashMap;
import java.util.Map;

import org.zerocouplage.api.config.IVirtualViewConfig;
import org.zerocouplage.api.config.IVirtualViewConfigMap;
import org.zerocouplage.common.exceptions.ZCExceptionConfig;
/**
 * @author Nasseur Hinde vesrion 1.2.0
 *
 */
public class VirtualViewConfigMapImpl implements IVirtualViewConfigMap {

	/**
	 * <p>
	 * The set of IVirtualViewConfig instance
	 * </p>
	 */
	protected Map<String, IVirtualViewConfig> virtualViewConfigs;
	
	public VirtualViewConfigMapImpl(){
		super();
		this.virtualViewConfigs = new HashMap<String, IVirtualViewConfig>();
	}

	@Override
	public IVirtualViewConfig getVirtualViewConfigByContext(String context) {
		
		return ((IVirtualViewConfig) virtualViewConfigs.get(context));	
	}

	@Override
	public void addVirtualViewConfig(IVirtualViewConfig virtualView) {
		String context = virtualView.getContext();
		if (virtualViewConfigs.containsKey(context)) {
	}
		virtualViewConfigs.put(virtualView.getContext(), virtualView);
		
	}

	@Override
	public void removeVirtualViewConfig(String context) {
		virtualViewConfigs.remove(context);
		
	}

	@Override
	public Map<String, IVirtualViewConfig> getVirtualViewConfigs() {
		return virtualViewConfigs;
	}

	@Override
	public void setVirtualViewConfigs(
			Map<String, IVirtualViewConfig> virtualViewConfigs) {
		this.virtualViewConfigs = virtualViewConfigs;
		
	}

}
