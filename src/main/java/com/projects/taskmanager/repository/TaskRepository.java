package com.projects.taskmanager.repository;

import com.projects.taskmanager.model.Task;
import com.projects.taskmanager.model.TaskList;
import com.projects.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskList(TaskList taskList);
    List<Task> findByUser(User user);
    List<Task> findByDueDateBetween(LocalDateTime inicio, LocalDateTime fim);
}
