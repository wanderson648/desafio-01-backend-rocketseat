package com.wo.desafio.task.task.application.repository;

import com.wo.desafio.task.task.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {
    Task create(Task task);
    List<Task> getAllTasks();
    Task getById(UUID idTask);
    void deleteTask(Task task);
}
