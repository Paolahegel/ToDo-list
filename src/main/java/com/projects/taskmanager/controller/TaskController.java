package com.projects.taskmanager.controller;

import com.projects.taskmanager.model.Task;
import com.projects.taskmanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(
        @RequestBody Task task,
        @RequestParam Long listId,
        @RequestParam(required = false) Long userId) {
        Task newTask = taskService.createTask(task, listId, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping("/proximas")
    public ResponseEntity<List<Task>> findTaskCloseToDue(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime de,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime ate) {
        return ResponseEntity.ok(taskService.findByTaskNearlyDueDate(de, ate));
    }
}
