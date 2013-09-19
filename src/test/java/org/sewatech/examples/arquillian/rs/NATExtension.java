package org.sewatech.examples.arquillian.rs;

import org.jboss.arquillian.core.spi.*;

/**
 * Extension for supporting NAT environments.
 * Will allow to force public address to HTTP URLs
 */
public class NATExtension implements LoadableExtension {
  public void register(ExtensionBuilder builder) {
    builder.observer(ProtocolMetadataRewriter.class);
  }    
}
