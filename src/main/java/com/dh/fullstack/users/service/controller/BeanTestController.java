package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.bean.Asus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;


@RestController
@RequestMapping ("/test") //para colocar el path
@RequestScope
public class BeanTestController {

    private Integer value=1;

    @Autowired//Inyeccion por propiedad
    private Asus asus;

// Inyeccion por constructor
//    public AccountController(Asus asus) {
//        this.asus = asus;
//    }

// Inyeccion por Setter
//    @Autowired
//    public void setAsus(Asus asus) {
//        this.asus = asus;
//    }

    @RequestMapping(value="/asus", method = RequestMethod.GET)
    public Asus readAsus(){

        value = value + 1;
        asus.setName(asus.getName()+":GET"+ ", Value: " +value);
        return asus;
    }


}
