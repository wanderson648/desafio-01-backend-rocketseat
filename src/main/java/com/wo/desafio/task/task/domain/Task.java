package com.wo.desafio.task.task.domain;

import com.wo.desafio.task.application.api.TaskRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Entity
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
    private final LocalDate completedAt = null;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public Task(TaskRequest taskRequest) {
        this.title = taskRequest.getTitle();
        this.description = taskRequest.getDescription();
        this.createdAt = LocalDate.now();
    }
}
