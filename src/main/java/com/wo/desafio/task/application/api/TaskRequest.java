package com.wo.desafio.task.application.api;

import jakarta.validation.constraints.NotBlank;


public record TaskRequest(@NotBlank String title, @NotBlank String description) {}

