package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

//Maps to the muzix class
@Entity
//Data annotation in lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
//It will create all getters and setters and also constructors
public class Muzix {
    //PrimaryKey in the table
    @Id
    private int id;
    private String name;
    private String track;


}
