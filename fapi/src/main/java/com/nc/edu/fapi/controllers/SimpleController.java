package com.nc.edu.fapi.controllers;


import com.nc.edu.fapi.models.SimpleObject;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SimpleController {

    @RequestMapping(value = "/get-simple-text")
    public SimpleObject getSimpleString(){
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setId("1");
        simpleObject.setName("Alex");
        return simpleObject;
    }

}
