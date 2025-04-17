package com.projects.taskmanager.repository;

import com.projects.taskmanager.model.Project;
import com.projects.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByDono(User user);
}
