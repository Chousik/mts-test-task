package ru.chousik.mts.autoconfig;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.context.annotation.Bean;
import ru.chousik.mts.tomcat.FooValve;

@AutoConfiguration(after = ServletWebServerFactoryAutoConfiguration.class)
@ConditionalOnClass(Tomcat.class)
public class TomcatConfiguration {
    @Bean
    TomcatContextCustomizer fooValve(){
        return context -> context.getPipeline().addValve(new FooValve());
    }
}
