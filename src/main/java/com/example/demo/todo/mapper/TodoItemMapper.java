package com.example.demo.todo.mapper;

import com.example.demo.todo.controller.TodoItemResource;
import com.example.demo.todo.repository.TodoItemEntity;

public class TodoItemMapper {

    public TodoItemResource toResource(TodoItemEntity entity) {
        TodoItemResource resource = new TodoItemResource();

        resource.setId(entity.getId());
        resource.setDescription(entity.getDescription());
        resource.setUserName(entity.getUserName());
        resource.setFolder(entity.getFolder());
        resource.setCompleted(entity.getCompleted());

        return resource;
    }

    public TodoItemEntity toEntity(TodoItemResource resource) {
        TodoItemEntity entity = new TodoItemEntity();

        entity.setDescription(resource.getDescription());
        entity.setUserName(resource.getUserName());
        entity.setFolder(resource.getFolder());
        entity.setCompleted(resource.getCompleted());

        return entity;
    }
}
