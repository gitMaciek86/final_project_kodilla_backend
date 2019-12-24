package com.translation.demo.domain.db;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity(name = "POEMS")
public class Poem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "POEM_LINE")
    private String lines;
    @Column(name = "date_bought")
    private LocalDateTime dateBought;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Poem(Long id, String title, String author, String lines, LocalDateTime dateBought) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.lines = lines;
        this.dateBought = dateBought;
    }

    public Poem() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLines() {
        return lines;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLines(String lines) {
        this.lines = lines;
    }

    public LocalDateTime getDateBought() {
        return dateBought;
    }
    public void setDateBought(LocalDateTime dateBought) {
        this.dateBought = dateBought;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
