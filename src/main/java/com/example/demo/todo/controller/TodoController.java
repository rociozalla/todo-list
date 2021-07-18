package com.example.demo.todo.controller;

import com.example.demo.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/todo")
public class TodoController {
    private final TodoService toDoService;

    @Autowired
    public TodoController(TodoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/items")
    public List<TodoItemResource> getItems() {
        return toDoService.getItems();
    }

    @GetMapping("/{id}")
    public TodoItemResource getItem(@PathVariable Long id) {
        return toDoService.getItem(id);
    }

    @PostMapping
    public void createItem(@RequestBody @Validated TodoItemResource todoItemResource) {
        toDoService.addNewItem(todoItemResource);
    }

    @PatchMapping
    public void editItem(@RequestBody TodoItemResource todoItemResource) {
        Assert.notNull(todoItemResource, "Todo item entity mustn't be null");
        Assert.notNull(todoItemResource.getDescription(), "Description mustn't be null");

        toDoService.updateItem(todoItemResource);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        toDoService.deleteItem(id);
    }
}