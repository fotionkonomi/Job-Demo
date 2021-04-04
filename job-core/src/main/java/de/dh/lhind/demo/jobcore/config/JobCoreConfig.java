package de.dh.lhind.demo.jobcore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobCoreConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
