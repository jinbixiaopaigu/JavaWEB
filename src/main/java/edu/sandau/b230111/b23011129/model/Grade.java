package edu.sandau.b230111.b23011129.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Grade {
    @Id
    private String id;
    private String name;
    private Integer java;
    private Integer python;
    private Integer c;

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getPython() {
        return python;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPython(Integer python) {
        this.python = python;
    }

    public Integer getJava() {
        return java;
    }

    public void setJava(Integer java) {
        this.java = java;
    }
}
