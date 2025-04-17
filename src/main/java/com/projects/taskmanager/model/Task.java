package com.projects.taskmanager.model;

import com.projects.taskmanager.model.enums.TaskStatus;
import com.projects.taskmanager.model.enums.Priority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false)
    private TaskList taskList;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime createDate;
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private Priority status;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
}
