package com.wo.desafio.task.application.service;

import com.wo.desafio.task.application.api.TaskRequest;
import com.wo.desafio.task.application.api.TaskResponse;

public interface TaskService {
    TaskResponse createTask(TaskRequest taskRequest);
}
