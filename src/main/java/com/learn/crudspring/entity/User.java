package com.learn.crudspring.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {

    private static final long serialversionUID = -9839483849783L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nombre")
    private String nombre;

    @Column(name ="apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name="telefono")
    private String telefono;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;


}
