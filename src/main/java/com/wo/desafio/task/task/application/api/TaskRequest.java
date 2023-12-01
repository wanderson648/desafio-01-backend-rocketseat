package com.wo.desafio.task.task.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


@Builder
public record TaskRequest(@NotBlank String title, @NotBlank String description) {}

