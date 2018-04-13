package com.github.schuettec.limbus.basic;

import java.util.Set;

import com.remondis.limbus.LimbusPlugin;

/**
 * This is the plugin interface that is used by the host application to interact
 * with the plugin instance.
 * 
 * @author schuettec
 *
 */
public interface BasicPluginInterface extends LimbusPlugin {

	/**
	 * This method lets the plugin read all the system properties using
	 * {@link System#getProperties()}. This demonstrates, that reading system
	 * properties of the JVM is a permission granted by default for every plugin.
	 * 
	 * @return Returns the set of system properties.
	 */
	public Set<String> readSystemProperties();

	/**
	 * This method lets the plugin call {@link System#exit(int)}. The call will
	 * result in a {@link SecurityException}. This demonstrates, that the plugin
	 * does not have the permission to shut down the JVM by default.
	 */
	public void trySystemExit();

}
