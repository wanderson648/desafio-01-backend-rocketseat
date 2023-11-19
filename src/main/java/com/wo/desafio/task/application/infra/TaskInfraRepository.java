package com.wo.desafio.task.application.infra;

import com.wo.desafio.task.application.repository.TaskRepository;
import com.wo.desafio.task.task.domain.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
