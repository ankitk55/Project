package org.ankit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class testConfiguration {

    @Bean("3parameter")
    public car objectcar(){
        return new car("Red",120,"Automatic");
    }
    @Bean("2parameter")
    public car objectcar2(){
        return new car("Blue",140);
    }


}
