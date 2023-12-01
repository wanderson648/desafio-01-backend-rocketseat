package com.wo.desafio.task.task.domain;

import com.wo.desafio.task.task.application.api.MarkTaskAsCompleted;
import com.wo.desafio.task.task.application.api.PutTaskRequest;
import com.wo.desafio.task.task.application.api.TaskRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @Column(name = "completed_at")
    private Boolean completedAt;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public Task(TaskRequest taskRequest) {
        this.title = taskRequest.title();
        this.description = taskRequest.description();
        this.createdAt = LocalDate.now();
    }

    public void editTask(PutTaskRequest putTaskRequest) {
        this.title = putTaskRequest.title();
        this.description = putTaskRequest.description();
        this.updatedAt = LocalDate.now();
    }

    public void markAsCompleted(MarkTaskAsCompleted markTaskAsCompleted) {
        this.completedAt = markTaskAsCompleted.completedAt();
        this.updatedAt = LocalDate.now();

    }
}
