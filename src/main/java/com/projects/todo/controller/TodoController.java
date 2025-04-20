package com.projects.todo.controller;

import com.projects.todo.entity.Todo;
import com.projects.todo.entity.enums.TodoStatus;
import com.projects.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo){
        return todoService.create(todo);
    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

    @GetMapping("{status}")
    List<Todo> filterByStatus(@PathVariable("status") TodoStatus todoStatus){
        return todoService.findByStatus(todoStatus);
    }

}
