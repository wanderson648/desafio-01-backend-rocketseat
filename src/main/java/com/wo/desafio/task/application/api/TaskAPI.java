package com.wo.desafio.task.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/tasks")
public interface TaskAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TaskResponse postTask(@Valid @RequestBody TaskRequest taskRequest);
}
