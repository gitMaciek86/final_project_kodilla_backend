package com.translation.demo.domain.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Builder
public class PoemDto {
    private Long id;
    private String title;
    private String author;
    private String lines;
    private LocalDateTime dateBought;

    public PoemDto(Long id, String title, String author, String lines, LocalDateTime dateBought) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.lines = lines;
        this.dateBought = dateBought;
    }

    public PoemDto() {
    }

    public LocalDateTime getDateBought() {
        return dateBought;
    }

    public void setDateBought(LocalDateTime dateBought) {
        this.dateBought = dateBought;
    }

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
}
