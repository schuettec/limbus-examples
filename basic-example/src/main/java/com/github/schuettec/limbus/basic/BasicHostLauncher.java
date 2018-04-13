package com.github.schuettec.limbus.basic;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

import com.remondis.limbus.Classpath;
import com.remondis.limbus.DeployService;
import com.remondis.limbus.LimbusEngine;
import com.remondis.limbus.launcher.EngineLauncher;
import com.remondis.limbus.launcher.SystemEngine;
import com.remondis.limbus.utils.SerializeException;

/**
 * This class contains a main method that starts the host application and uses
 * it to deploy the plugin.
 * 
 * @author schuettec
 *
 */
public class BasicHostLauncher {
  public static void main(String[] args) throws SerializeException, Exception {
    // Bootstrap a Limbus System using the descriptor xml.
    EngineLauncher.bootstrapLimbusSystem();
    SystemEngine system = (SystemEngine) EngineLauncher.getEngine();
    LimbusEngine engine = system.getComponent(LimbusEngine.class);
    DeployService deployService = system.getComponent(DeployService.class);
    String deployName = deployService.toDeployName("com.github.schuettec.limbus", "basic-plugin", "jar", "0.0.1");
    HashSet<Permission> permissions = new HashSet<>();
    permissions.add(new java.util.PropertyPermission("*", "read,write"));
    deployService.deployMavenArtifact("com.github.schuettec.limbus", "basic-plugin", "jar", "0.0.1", permissions);
    Classpath classpath = engine.getClasspath(deployName);
    BasicPluginInterface plugin = engine.getPlugin(classpath,
        "com.github.schuettec.limbus.basic.plugin.BasicPluginImpl", BasicPluginInterface.class);

    Set<String> readSystemProperties = plugin.readSystemProperties();
    System.out.println("Got the system properties from plugin: ");
    for (String property : readSystemProperties) {
      System.out.println("- " + property);
    }
    plugin.trySystemExit();
  }
}
