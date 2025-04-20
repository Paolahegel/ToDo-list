package com.projects.todo.controller;

import com.projects.todo.dto.TodoRequestDTO;
import com.projects.todo.dto.TodoResponseDTO;
import com.projects.todo.entity.enums.TodoStatus;
import com.projects.todo.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Operation(summary = "Create a new task")
    @PostMapping
    List<TodoResponseDTO> create(@RequestBody @Valid TodoRequestDTO todoRequest){
        return todoService.create(todoRequest);
    }

    @Operation(summary = "Find all created tasks")
    @GetMapping
    List<TodoResponseDTO> list(){
        return todoService.list();
    }

    @Operation(summary = "Update an existing task")
    @PutMapping
    List<TodoResponseDTO> update(@RequestBody @Valid TodoRequestDTO todoRequest){
        return todoService.update(todoRequest);
    }

    @Operation(summary = "Delete a task by id")
    @DeleteMapping("{id}")
    List<TodoResponseDTO> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

    @Operation(summary = "Delete all tasks")
    @DeleteMapping
    List<TodoResponseDTO> deleteAll(){
        return todoService.deleteAll();
    }

    @Operation(summary = "Filter tasks by status")
    @GetMapping("{status}")
    List<TodoResponseDTO> filterByStatus(@PathVariable("status") TodoStatus status){
        return todoService.findByStatus(status);
    }

    @Operation(summary = "Filter tasks by terms")
    @GetMapping("/search")
    public List<TodoResponseDTO> searchTodos(@RequestParam(required = false) String term){
        return todoService.searchByName(term);
    }
}