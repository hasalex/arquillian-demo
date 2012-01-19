package org.sewatech.examples.arquillian.rs;

import org.jboss.arquillian.core.spi.LoadableExtension;
import org.jboss.arquillian.core.spi.LoadableExtension.ExtensionBuilder;

/**
 * Extension for supporting NAT environments.
 * Will allow to force public address to HTTP URLs
 * 
 * @author alexis
 */
public class NATExtension implements LoadableExtension {
  public void register(ExtensionBuilder builder) {
    builder.observer(ProtocolMetadataRewriter.class);
  }    
}
