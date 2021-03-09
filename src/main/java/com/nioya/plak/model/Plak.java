package com.nioya.plak.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "plaks")
public class Plak {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    String singer;
    String type;
    String song1;
    String song2;

}
