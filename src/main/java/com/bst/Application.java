package com.bst;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


/**
 * Created by rekhamittal on 8/6/15.
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,EmbeddedServletContainerAutoConfiguration.class})
@ComponentScan(basePackages={"com.bst"})
@PropertySource(value={"classpath:application.properties"})
public class Application {
    private static Logger logger = Logger.getLogger(Application.class);

    @Value("${server.address}")
    private String SERVER_ADDRESS;

    @Value("${server.port}")
    private Integer SERVER_PORT;

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        logger.info("Spring Boot Beans:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Bean
    public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory() {
        JettyEmbeddedServletContainerFactory servletContainerFactory =  new JettyEmbeddedServletContainerFactory();
        servletContainerFactory.setPort(SERVER_PORT);
        try {
            servletContainerFactory.setAddress(InetAddress.getByName(SERVER_ADDRESS));
        } catch (UnknownHostException e) {
            logger.error("Unable to get the localhost address");
        }
//        servletContainerFactory.setSessionTimeout(4000, TimeUnit.MINUTES);
        servletContainerFactory.setRegisterJspServlet(false);
        servletContainerFactory.setServerCustomizers(Collections.singleton(new JettyConfigurer()));
        return servletContainerFactory;
    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//        return new PropertySourcesPlaceholderConfigurer();
//
//    }

}
