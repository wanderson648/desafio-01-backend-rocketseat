package com.wo.desafio.task.application.util;

import com.wo.desafio.task.task.domain.Task;

import java.util.UUID;

public class TaskCreator {
    private static final UUID taskId = UUID.randomUUID();

    public static Task createTask() {
        return Task.builder()
                .id(taskId)
                .title("tarefa")
                .description("tarefa teste")
                .build();
    }

    public static Task createUpdateTask() {
        return Task.builder()
                .id(taskId)
                .title("tarefa atualiza")
                .description("tarefa atualizada")
                .build();
    }
}
