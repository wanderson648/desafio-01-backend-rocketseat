package com.wo.desafio.task.task.application.service;

import com.wo.desafio.task.task.application.api.*;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskResponse createTask(TaskRequest taskRequest);
    List<TaskListResponse> getAllTasks();
    PutTaskRequest putTask(UUID idTask, PutTaskRequest putTaskRequest);
    void deleteTask(UUID idTask);
    void markTaskAsCompleted(UUID idTask, MarkTaskAsCompleted markTaskAsCompleted);
}
