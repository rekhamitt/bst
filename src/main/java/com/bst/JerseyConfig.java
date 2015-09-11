package com.bst;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.internal.scanning.PackageNamesScanner;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * This is the Jersey Application class. Here we declare which packages contain JAX-RS resources, which Jersey features
 * are enabled etc.
 *
 * Created by rekhamittal on 8/7/15.
 */
@Component
@ApplicationPath("/bst/*")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        super();

        // Create a recursive package scanner
        PackageNamesScanner resourceFinder = new PackageNamesScanner(new String[]{"com.bst.resource"}, true);
        // Register the scanner with this Application
        registerFinder(resourceFinder);
        register(JacksonFeature.class);
    }
}
