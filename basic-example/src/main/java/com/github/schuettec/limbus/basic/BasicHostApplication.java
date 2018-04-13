package com.github.schuettec.limbus.basic;

import java.io.InputStream;

import com.remondis.limbus.DeployService;
import com.remondis.limbus.LimbusEngine;
import com.remondis.limbus.launcher.EngineLauncher;
import com.remondis.limbus.launcher.SystemEngine;
import com.remondis.limbus.utils.SerializeException;

/**
 * This is the implementation of the host application that loads plugins using
 * the Limbus Engine.
 * 
 * @author schuettec
 *
 */
public class BasicHostApplication {

	public static void main(String[] args) throws SerializeException, Exception {

		// Bootstrap a Limbus System using the descriptor xml.
		EngineLauncher.bootstrapLimbusSystem();
		SystemEngine system = (SystemEngine) EngineLauncher.getEngine();
		LimbusEngine engine = system.getComponent(LimbusEngine.class);
		DeployService deployService = system.getComponent(DeployService.class);

	}
}
