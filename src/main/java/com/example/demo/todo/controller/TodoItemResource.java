package com.example.demo.todo.controller;

import com.fasterxml.jackson.annotation.JsonKey;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TodoItemResource {

    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String description;

    @NotNull
    @Size(min = 1, max = 100)
    private String folder;

    private Boolean completed = false;

    public TodoItemResource() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodoItemResource{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", folder='" + folder + '\'' +
                ", completed=" + completed +
                '}';
    }
}
