package com.wo.desafio.task.task.application.api;

import com.wo.desafio.task.task.application.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponse> postTask(@Valid @RequestBody TaskRequest taskRequest) {
        TaskResponse taskCreated = taskService.createTask(taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @GetMapping
    public ResponseEntity<List<TaskListResponse>> getAllTasks() {
        List<TaskListResponse> tasks = taskService.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @PutMapping("/{idTask}")
    public ResponseEntity<PutTaskRequest> putTask(@PathVariable UUID idTask,
                                                  @Valid @RequestBody PutTaskRequest putTaskRequest) {

        PutTaskRequest putTask = taskService.putTask(idTask, putTaskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(putTask);
    }

    @DeleteMapping("/{idTask}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID idTask) {
        taskService.deleteTask(idTask);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PatchMapping("/{idTask}/complete")
    public ResponseEntity<Void> markTaskAsCompleted(
            @PathVariable UUID idTask,
            @Valid @RequestBody MarkTaskAsCompleted markTaskAsCompleted) {

        taskService.markTaskAsCompleted(idTask, markTaskAsCompleted);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
