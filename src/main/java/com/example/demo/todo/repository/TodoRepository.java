package com.example.demo.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository
        extends JpaRepository<TodoItemEntity, Long> {

}
