package com.example.demo.beans;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String username ;
    private String password ;
    private String email ;

    public User(){

    }
}
