package com.wo.desafio.task.application.infra;

import com.wo.desafio.task.task.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskSpringDataJpaRepository extends JpaRepository<Task, UUID> {
}
