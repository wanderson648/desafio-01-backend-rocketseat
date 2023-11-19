package com.wo.desafio.task.application.service;

import com.wo.desafio.task.application.api.TaskRequest;
import com.wo.desafio.task.application.api.TaskResponse;
import com.wo.desafio.task.application.repository.TaskRepository;
import com.wo.desafio.task.task.domain.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        log.info("[start] TaskServiceImpl - createTask");
        Task task = taskRepository.create(new Task(taskRequest));
        log.info("[finished] TaskServiceImpl - createTask");
        return TaskResponse.builder().id(task.getId()).build();
    }
}
