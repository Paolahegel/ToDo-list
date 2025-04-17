package com.projects.taskmanager.service;

import com.projects.taskmanager.model.Task;
import com.projects.taskmanager.model.TaskList;
import com.projects.taskmanager.model.User;
import com.projects.taskmanager.model.enums.TaskStatus;
import com.projects.taskmanager.repository.TaskListRepository;
import com.projects.taskmanager.repository.TaskRepository;
import com.projects.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final TaskListRepository taskListRepository;
    private final NotificationService notificationService;

    public Task createTask(Task task, long listId, Long userId) {
        TaskList taskList = taskListRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("List not found"));
        User user = userId != null ?
                userRepository.findById(userId).orElse(null) : null;

        task.setTaskList(taskList);
        task.setUser(user);
        task.setCreateDate(LocalDateTime.now());
        task.setTaskStatus(TaskStatus.PENDENTE);

        Task savedTask = taskRepository.save(task);

        if(task.getDueDate() != null) {
            notificationService.scheduleNotification(savedTask);
        }

        return savedTask;
    }

    public List<Task> findByTaskNearlyDueDate( LocalDateTime start, LocalDateTime end) {
        return taskRepository.findByDueDateBetween(start, end);
    }
}
