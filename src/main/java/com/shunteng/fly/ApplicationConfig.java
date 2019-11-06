package com.shunteng.fly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ApplicationConfig {

    private static Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);

    /**
     * 线上环境的profile名称
     */

    public static final String PROFILE_NAME_PROD = "prod";
    
    public   static boolean loaddataOnStart = false;
    
    @Autowired
    Environment env;

    @Value("${env}")
    private String active;

    public boolean isProd() {
        return PROFILE_NAME_PROD.equals(active);
    }

    public boolean isTest() {
        return "test".equals(active);
    }

    public boolean isPress() {
        return "press".equals(active);
    }
    
    public boolean isPre() {
        return "pre".equals(active);
    }
    
    public boolean isDev() {
        return "dev".equals(active);
    }

    /**
     * dev profile
     */
    @Profile("dev")
    @Bean(name = "propertyPlaceholderConfigurer")
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurerDev() {
        PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("env/application-dev.properties"));
        LOG.info("env/application-dev loaded");
        return ppc;
    }

    @Profile("test")
    @Bean(name = "propertyPlaceholderConfigurer")
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurerTest() {
        PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("env/application-test.properties"));
        LOG.info("env/application-dev.properties loaded");
        return ppc;
    }

    @Profile(PROFILE_NAME_PROD)
    @Bean(name = "propertyPlaceholderConfigurer")
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurerProd() {
        PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("env/application-prod.properties"));
        LOG.info("env/application-dev.properties loaded");
        return ppc;
    }


    /**
     * bank profile
     */
    @Profile("product")
    @Bean(name = "propertyPlaceholderConfigurer")
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurerproduct() {
        PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("env/application-product.properties"));
        LOG.info("env/application-product.properties loaded");
        return ppc;
    }
}