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
    // The following lines demonstrate that the plugin is able to access classes in the package defined by the class
    // overriding LimbusEngineImpl.
    ClassLoader pluginClassLoader = getClass().getClassLoader();
    Class<?> hostApp = pluginClassLoader.loadClass("com.github.schuettec.limbus.basic.BasicHostApplication");
    Class<?> launcher = pluginClassLoader.loadClass("com.github.schuettec.limbus.basic.BasicHostLauncher");
    System.out.println("Got access to the following classes:");
    System.out.println("- " + hostApp.toString());
    System.out.println("- " + launcher.toString());
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
      String string = new StringBuilder().append(key)
          .append(" = ")
          .append(value)
          .toString();
      propertySet.add(string);
    }
    return propertySet;
  }

  @Override
  public void trySystemExit() {
    System.exit(0);
  }

}
