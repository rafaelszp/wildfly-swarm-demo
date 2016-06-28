package com.example.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rafael on 6/27/16.
 */

@XmlRootElement
public class Person {

    private Long id;
    private String name;

    public Person(){
        super();
    }

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
