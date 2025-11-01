package ru.chousik.mts.config;

import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.chousik.mts.tomcat.FooValve;

@Configuration
public class TomcatConfiguration {
    @Bean
    TomcatContextCustomizer fooValve(){
        return context -> context.getPipeline().addValve(new FooValve());
    }
}
