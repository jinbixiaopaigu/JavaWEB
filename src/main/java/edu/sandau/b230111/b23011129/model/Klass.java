package edu.sandau.b230111.b23011129.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Klass {
    @Id
    private String id;
    private String name;
    private String major;

    public String getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setName(String name) {
        this.name = name;
    }
}
