package com.example.demo.todo.service;

import com.example.demo.todo.controller.TodoItemResource;
import com.example.demo.todo.mapper.TodoItemMapper;
import com.example.demo.todo.repository.TodoItemEntity;
import com.example.demo.todo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoService {
    private final TodoRepository toDoRepository;

    private final TodoItemMapper mapper = new TodoItemMapper();

    @Autowired
    public TodoService(TodoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<TodoItemResource> getItems() {
        List<TodoItemEntity> entities = toDoRepository.findAll();

        List<TodoItemResource> items = new ArrayList<>();

        for (TodoItemEntity entity : entities) {
            items.add(mapper.toResource(entity));
        }

        return items;
    }

    public void addNewItem(TodoItemResource todoItemResource) {
        log.info("todoItemResource: {}", todoItemResource);
        TodoItemEntity entity = mapper.toEntity(todoItemResource);
        toDoRepository.save(entity);
    }

    public TodoItemResource getItem(Long id) {
        Optional<TodoItemEntity> entity = toDoRepository.findById(id);

        if (entity.isPresent()) {
            return mapper.toResource(entity.get());
        } else {
            return null;
        }
    }

    public void updateItem(TodoItemResource todoItemResource) {
        Optional<TodoItemEntity> dbResult =
                toDoRepository.findById(todoItemResource.getId());

        if (dbResult.isPresent()) {
            TodoItemEntity todoItemEntity = dbResult.get();
            todoItemEntity.setCompleted(todoItemResource.getCompleted());
            todoItemEntity.setDescription(todoItemResource.getDescription());
            toDoRepository.save(todoItemEntity);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Todo item not found");
        }
    }

    public void deleteItem(Long id) {
        Optional<TodoItemEntity> result = toDoRepository.findById(id);

        if (result.isPresent()) {
            toDoRepository.delete(result.get());
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Todo item not found");
        }
    }
}
