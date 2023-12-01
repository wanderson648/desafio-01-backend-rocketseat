package com.wo.desafio.task.task.application.service;

import com.wo.desafio.task.task.application.api.*;
import com.wo.desafio.task.task.application.repository.TaskRepository;
import com.wo.desafio.task.task.domain.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = taskRepository.create(new Task(taskRequest));
        return TaskResponse.builder().id(task.getId()).build();
    }

    @Override
    public List<TaskListResponse> getAllTasks() {
        List<Task> tasks = taskRepository.getAllTasks();
        return TaskListResponse.convert(tasks);
    }

    @Override
    public PutTaskRequest putTask(UUID idTask, PutTaskRequest putTaskRequest) {
        Task task = taskRepository.getById(idTask);
        task.editTask(putTaskRequest);
        taskRepository.create(task);
        return new PutTaskRequest(task.getTitle(), task.getDescription());
    }

    @Override
    public void deleteTask(UUID idTask) {
        Task task = taskRepository.getById(idTask);
        taskRepository.deleteTask(task);
    }

    @Override
    public void markTaskAsCompleted(UUID idTask, MarkTaskAsCompleted markTaskAsCompleted) {
        Task task = taskRepository.getById(idTask);
        task.markAsCompleted(markTaskAsCompleted);
        taskRepository.create(task);
    }
}
