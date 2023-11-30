package com.wo.desafio.task.application.api;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;


@Builder
public record TaskResponse(UUID id) {
}

