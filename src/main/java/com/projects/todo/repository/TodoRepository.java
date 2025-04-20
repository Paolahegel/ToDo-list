package com.projects.todo.repository;

import com.projects.todo.entity.Todo;
import com.projects.todo.entity.enums.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByTodoStatus(TodoStatus todoStatus);

    @Query("SELECT t FROM Todo t WHERE LOWER(t.nome) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Todo> findByName(@Param("searchTerm") String searchTeam);
}
