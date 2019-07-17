package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.bean.BeanPractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/practica")
@RequestScope
public class BeanPracticeController {

    @Autowired
    private BeanPractice beanPractice;

    @RequestMapping(value="/bean",method = RequestMethod.GET)
    public BeanPractice readBeanPractice(){
        beanPractice.setName(beanPractice.getName()+":GET");
        return beanPractice;
    }


}
