package com.dh.fullstack.users.service.config;

import com.dh.fullstack.users.service.bean.Asus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
public class Config {

    //@Bean (name="B-asus")
    @Scope("prototype")
    public Asus beanAsus(){
        Asus asus=new Asus();
        asus.setName("I am Asus");

        return asus;
    }
}
