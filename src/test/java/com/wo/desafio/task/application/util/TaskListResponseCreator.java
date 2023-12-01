package com.wo.desafio.task.application.util;

import com.wo.desafio.task.task.application.api.TaskRequest;

public class TaskListResponseCreator {
    public static TaskRequest createTaskRequest() {
        return TaskRequest.builder()
                .title("cria tarefa")
                .description("tarefa criada")
                .build();

    }
}
