package com.wo.desafio.task.task.application.api;

import jakarta.validation.constraints.NotBlank;

public record PutTaskRequest(@NotBlank String title, @NotBlank String description) {
}
