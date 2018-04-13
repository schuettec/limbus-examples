package com.github.schuettec.limbus.basic;

import com.remondis.limbus.LimbusEngineImpl;

/**
 * This is the implementation of the host application that loads plugins using
 * the Limbus Engine.
 * 
 * @author schuettec
 *
 */
public class BasicHostApplication extends LimbusEngineImpl {

  @Override
  protected String[] getPublicAccessPackages() {
    return new String[] {
        getClass().getPackage()
            .getName()
    };
  }

}
