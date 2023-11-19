package com.wo.desafio.task.application.api;

import com.wo.desafio.task.application.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TaskController implements TaskAPI {

    private final TaskService taskService;
    @Override
    public TaskResponse postTask(TaskRequest taskRequest) {
        log.info("[start] TaskController - postTask");
        TaskResponse taskCreated = taskService.createTask(taskRequest);
        log.info("[finished] TaskController - postTask");
        return taskCreated;
    }
}
