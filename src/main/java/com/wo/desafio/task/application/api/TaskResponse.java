package com.wo.desafio.task.application.api;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.UUID;


@Value
@Builder
public class TaskResponse {
    UUID id;
}
