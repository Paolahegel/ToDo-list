package com.projects.taskmanager.service;

import com.projects.taskmanager.model.Task;
import com.projects.taskmanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final TaskRepository taskRepository;
    private final EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void checkTasksUpcoming() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);

        List<Task> tasks = taskRepository.findByDueDateBetween(now, tomorrow);

        tasks.forEach(task -> {
            if(task.getUser() != null) {
                String message = String.format(
                        "The task '%s' due in %s",
                        task.getTitle(),
                        formatDate(task.getDueDate())
                );
                emailService.sendEmail(
                        task.getUser().getEmail(),
                        "Task close to due date",
                        message
                );
            }
        });
    }

    public void scheduleNotification(Task task) {
        LocalDateTime dueDate = task.getDueDate();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);

    }

    public String formatDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
