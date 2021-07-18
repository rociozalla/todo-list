package com.example.demo.todo.repository;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class TodoItemEntity {

    @Id
    @SequenceGenerator(
            name = "todo_item_sequence",
            sequenceName = "todo_item_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_item_sequence"
    )

    private Long id;

    @Column(name = "user_name")
    private String userName;

    private String description;

    private String folder;

    private Boolean completed;

    public TodoItemEntity() {
    }

    public TodoItemEntity(
            String userName,
            String description,
            String folder,
            Boolean completed) {
        this.userName = userName;
        this.description = description;
        this.folder = folder;
        this.completed = completed;
    }

    public Long getId() {
        return id;
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
}
