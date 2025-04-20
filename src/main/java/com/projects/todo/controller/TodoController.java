package com.projects.todo.controller;

import com.projects.todo.entity.Todo;
import com.projects.todo.entity.enums.TodoStatus;
import com.projects.todo.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Operation(summary = "create a new task")
    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo){
        return todoService.create(todo);
    }

    @Operation(summary = "returns all created tasks")
    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }

    @Operation(summary = "update a task")
    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }

    @Operation(summary = "delete a task by id")
    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

    @Operation(summary = "filter tasks by status")
    @GetMapping("{status}")
    List<Todo> filterByStatus(@PathVariable("status") TodoStatus todoStatus){
        return todoService.findByStatus(todoStatus);
    }

}
