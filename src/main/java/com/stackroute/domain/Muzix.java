package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

//Maps to the muzix class
@Entity
public class Muzix {
    //PrimaryKey in the table
    @Id
    private int id;
    private String name;
    private String track;


    //Default and parameterized constructors
    public Muzix() {
    }

    public Muzix(int id, String name, String track) {
        this.id = id;
        this.name = name;
        this.track = track;
    }

    //Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    @Override
    public String toString() {
        return "Muzix{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", track='" + track + '\'' +
                '}';
    }
}
