package com.wo.desafio.task.application.api;

import jakarta.validation.constraints.NotNull;

public record MarkTaskAsCompleted(@NotNull Boolean completedAt) {
}
