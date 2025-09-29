package org.liman.olymp_task_setter_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class OlympTaskSetter {

    public static void main(String[] args) {
        SpringApplication.run(OlympTaskSetter.class);
    }
}
