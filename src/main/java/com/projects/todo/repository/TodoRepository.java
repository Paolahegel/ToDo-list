package com.projects.todo.repository;

import com.projects.todo.entity.Todo;
import com.projects.todo.entity.enums.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByTodoStatus(TodoStatus todoStatus);
}
