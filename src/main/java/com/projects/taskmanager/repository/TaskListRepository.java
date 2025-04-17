package com.projects.taskmanager.repository;

import com.projects.taskmanager.model.Project;
import com.projects.taskmanager.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskList, Long> {
    List<TaskList> findByProject(Project project);
}
