package com.dagasource.InsertUser;

import lombok.Data;
import lombok.RequiredArgsConstructor;

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

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}