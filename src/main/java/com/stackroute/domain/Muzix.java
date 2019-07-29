package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
//To create the muzix table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//Using lombok to create getter and setter methods.
public class Muzix{
    @Id
    private int trackId;
    @Column
    private String trackName;
    @Column
    private String comments;
}
