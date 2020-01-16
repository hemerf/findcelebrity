package com.hemer.findcelebrity.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController{
    @RequestMapping(method = RequestMethod.GET, path = "/Person/add")
    public String addPerson(Integer id,String name){
        return "ok";
    }
}
