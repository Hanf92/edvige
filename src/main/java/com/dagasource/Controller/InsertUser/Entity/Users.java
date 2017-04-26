package com.dagasource.Controller.InsertUser.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by fabio on 25/01/17.
 */
@Entity
@Data
@RequiredArgsConstructor
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name= "nome")
    private String nome;

    @NotNull
    @Column(name= "cognome")
    private String cognome;

    @NotNull
    @Column(name= "citta")
    private String citta;

    @NotNull
    @Email
    @Column(name= "email")
    private String email;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", citta='" + citta + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



}