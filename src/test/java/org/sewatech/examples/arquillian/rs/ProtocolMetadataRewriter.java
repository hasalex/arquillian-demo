/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package org.sewatech.examples.arquillian.rs;

import org.jboss.arquillian.container.spi.client.protocol.metadata.*;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.core.api.annotation.Observes;
import org.jboss.arquillian.container.spi.context.annotation.DeploymentScoped;
import org.jboss.arquillian.core.api.InstanceProducer;

/**
 *
 * @author alexis
 */
public class ProtocolMetadataRewriter {

    @Inject
    @DeploymentScoped
    private InstanceProducer<ProtocolMetaData> prod;

    public void rewrite(@Observes ProtocolMetaData metadata) {

        if (needToRewriteMetadata(metadata)) {
            ProtocolMetaData newData = cloneAndRewrite(metadata);

            // Since your observing the creation of a ProtocolMetaData you will get called again 
            // when you set cloned/recreated metadata on the InstanceProducer. 
            // The needToRewriteMetadata check should prevent a wild loop
            prod.set(newData);
        }
    }

    private ProtocolMetaData cloneAndRewrite(ProtocolMetaData metadata) {
        String serverHost = System.getProperty("arquillian.server");
        ProtocolMetaData newMetadata = new ProtocolMetaData();
                
        newMetadata.addContext(cloneHTTPContext(metadata, serverHost));

        // May I should re-attach other contexts
            // Unfortunately, I cannot know the complete list of contexts.
        if (metadata.hasContext(JMXContext.class)) {
            newMetadata.addContext(metadata.getContext(JMXContext.class));
        }
        if (metadata.hasContext(RMIContext.class)) {
            newMetadata.addContext(metadata.getContext(RMIContext.class));
        }
        
        return newMetadata;
    }

    private HTTPContext cloneHTTPContext(ProtocolMetaData metadata, String serverHost) {
        HTTPContext oldContext = metadata.getContext(HTTPContext.class);
        HTTPContext newContext = new HTTPContext(serverHost, oldContext.getPort());
        for (Servlet servlet : oldContext.getServlets()) {
            newContext.add(servlet);
        }
        return newContext;
    }

    private boolean needToRewriteMetadata(ProtocolMetaData metadata) {
        if (metadata.hasContext(HTTPContext.class)) {
            
            String serverHost = System.getProperty("arquillian.server");
            String host = metadata.getContext(HTTPContext.class).getHost();
            
            if (serverHost != null && !serverHost.equals(host)) {
                return true;
            }
        }
        return false;
    }
    
}
