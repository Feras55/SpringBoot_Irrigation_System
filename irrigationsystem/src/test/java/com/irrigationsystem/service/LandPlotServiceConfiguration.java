package com.irrigationsystem.service;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class LandPlotServiceConfiguration {

    @Bean
    @Primary
    public LandPlotService landPlotService() {
        return Mockito.mock(LandPlotService.class);
    }
}
