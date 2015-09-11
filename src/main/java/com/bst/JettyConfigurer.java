package com.bst;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.servlet.ErrorPageErrorHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.boot.context.embedded.jetty.JettyServerCustomizer;
import org.springframework.context.annotation.Configuration;


/**
 * This is a JettyServerCustomizer implementation for future customizations.
 * Created by rekhamittal on 8/7/15.
 */
@Configuration
public class JettyConfigurer  implements JettyServerCustomizer{

    @Override
    public void customize(Server server) {
        WebAppContext webAppContext = (WebAppContext) server.getHandler();
        try {
            webAppContext.setErrorHandler(errorHandler());
            webAppContext.setLogUrlOnStart(true);
//            webAppContext.getLogger().setDebugEnabled(true);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ErrorHandler errorHandler() {
        ErrorPageErrorHandler errorHandler = new ErrorPageErrorHandler();
        errorHandler.addErrorPage(404, "/404.html");
        errorHandler.addErrorPage(500, "/500.html");
        return errorHandler;
    }
}