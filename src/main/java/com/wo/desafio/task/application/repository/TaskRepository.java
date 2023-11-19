package com.wo.desafio.task.application.repository;

import com.wo.desafio.task.task.domain.Task;

public interface TaskRepository {
    Task create(Task task);
}
