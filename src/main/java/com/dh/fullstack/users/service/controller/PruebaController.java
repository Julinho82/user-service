package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.bean.Prueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Santiago Mamani
 */
@RestController
@RequestMapping("/beans")
@RequestScope
public class PruebaController {



    @Autowired
    private Prueba prueba;
// DI por setter
//    @Autowired
//    public void setAsus(Asus asus) {
//        this.asus = asus;
//    }
// DI Por constructor
//    public AccountController(Asus asus) {
//        this.asus = asus;
//    }
//    public AccountController() {
//        this.asus = new Asus(); NO usar jamas
//    }
    @RequestMapping(value = "/prueba", method = RequestMethod.GET)
    public Prueba readPrueba() {

        return prueba;
    }
}
