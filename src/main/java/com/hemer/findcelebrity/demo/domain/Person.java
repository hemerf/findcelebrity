package com.hemer.findcelebrity.demo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private Integer id;
    private String name;

    public Person(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setId(Integer Id){
        this.id =  id;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;

        Person p = (Person)obj;

        if(this.id.equals(p.id) && this.name.equals(p.name)){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return id+","+name;
    }
}
