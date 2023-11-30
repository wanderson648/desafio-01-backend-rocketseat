package com.wo.desafio.task.application.infra;

import com.wo.desafio.task.application.repository.TaskRepository;
import com.wo.desafio.task.task.domain.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class TaskInfraRepository implements TaskRepository {
    private final TaskSpringDataJpaRepository taskSpringDataJpaRepository;

    @Override
    public Task create(Task task) {
        log.info("[start] TaskInfraRepository - create");
        taskSpringDataJpaRepository.save(task);
        log.info("[finished] TaskInfraRepository - create");
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        log.info("[start] TaskInfraRepository - getAllTasks");
        log.info("[finished] TaskInfraRepository - getAllTasks");
        return taskSpringDataJpaRepository.findAll();
    }

    @Override
    public Task getById(UUID idTask) {
        return taskSpringDataJpaRepository.findById(idTask).orElseThrow(() ->
                new RuntimeException("Task not found"));
    }

    @Override
    public void deleteTask(Task task) {
        taskSpringDataJpaRepository.delete(task);
    }
}
