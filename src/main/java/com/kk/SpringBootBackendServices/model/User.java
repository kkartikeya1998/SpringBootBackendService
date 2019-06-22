package com.kk.SpringBootBackendServices.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private  Long id;
    @Getter @Setter
    private String firstName;
    @Getter @Setter
    private String lastName;

    // @Getter @Setter includes getters and setters
    // @ToString includes a toString method
    // @AllArgsConstructor includes an all argument constructor
    // @NoArgsConstructor includes a default no constructor
}
