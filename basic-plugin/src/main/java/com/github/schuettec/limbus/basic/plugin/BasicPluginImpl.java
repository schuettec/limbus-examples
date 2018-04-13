package com.github.schuettec.limbus.basic.plugin;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import com.github.schuettec.limbus.basic.BasicPluginInterface;

/**
 * This is the implementation of a basic plugin implementation.
 * 
 * @author schuettec
 *
 */
public class BasicPluginImpl implements BasicPluginInterface {

	@Override
	public void initialize() throws Exception {
	}

	@Override
	public void finish() {
	}

	@Override
	public Set<String> readSystemProperties() {
		Properties properties = System.getProperties();
		Set<Object> keySet = properties.keySet();
		Set<String> propertySet = new HashSet<>();
		for (Object key : keySet) {
			Object value = properties.get(key);
			String string = new StringBuilder().append(key).append(" = ").append(value).toString();
			propertySet.add(string);
		}
		return propertySet;
	}

	@Override
	public void trySystemExit() {
		System.exit(0);
	}

}
