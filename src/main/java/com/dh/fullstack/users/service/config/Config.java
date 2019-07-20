package com.dh.fullstack.users.service.config;

import com.dh.fullstack.users.service.bean.Asus;
import com.dh.fullstack.users.service.bean.Prueba;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public Asus beanAsus() {
        Asus asus = new Asus();
        asus.setName("I am Asus");

        return asus;
    }

    @Bean
    @Scope("prototype")
    public Prueba beanPracticeM(){
        Prueba prueba = new Prueba();
        prueba.setName("Soy bean Practica");
        return prueba;
    }
}
