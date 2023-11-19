package com.wo.desafio.task.application.api;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.time.LocalDate;

@Value
public class TaskRequest {
    String title;
    @NotBlank
    String description;
}
