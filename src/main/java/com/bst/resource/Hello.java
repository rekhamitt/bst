package com.bst.resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/order")
public class Hello {
    private static Logger logger = Logger.getLogger(Hello.class);

    @Path("/hello")
    @GET
    public String index() {
        return "Greetings!";
    }

    private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


}
