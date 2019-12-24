package com.translation.demo.domain.db;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "MAIL")
    private String mail;

    @OneToMany(mappedBy="user")
    private Set<Poem> poemsSet;

    public User(Long id, String username, String surname, String login, String password, String mail) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.mail = mail;
    }

    public User() {
    }
}
