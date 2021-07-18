package com.example.demo.todo;

import com.example.demo.todo.repository.TodoItemEntity;
import com.example.demo.todo.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TodoConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            TodoRepository repository) {
        return args -> {
            TodoItemEntity item1 = new TodoItemEntity(
                    "Maria",
                    "Buy food",
                    "Food",
                    false
            );

            TodoItemEntity item2 = new TodoItemEntity(
                    "Tomas",
                    "Go running",
                    "Sport",
                    false
            );

            repository.saveAll(
                    List.of(item1, item2)
            );
        };
    }
}


