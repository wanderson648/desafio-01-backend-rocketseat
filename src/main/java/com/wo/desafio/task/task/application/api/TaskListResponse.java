package com.wo.desafio.task.task.application.api;

import com.wo.desafio.task.task.domain.Task;
import jakarta.persistence.Column;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class TaskListResponse {
    UUID id;
    @NotBlank
    String title;
    @NotBlank
    String description;
    @Column(name = "completed_at")
    Boolean completedAt;
    @Column(name = "created_at")
    LocalDate createdAt;

    public TaskListResponse(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.completedAt = task.getCompletedAt();
        this.createdAt = LocalDate.now();

    }

    public static List<TaskListResponse> convert(List<Task> tasks) {
        return tasks.stream().map(TaskListResponse::new).collect(Collectors.toList());
    }
}
