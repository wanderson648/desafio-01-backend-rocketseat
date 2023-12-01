package com.wo.desafio.task.application.service;

import com.wo.desafio.task.application.util.TaskCreator;
import com.wo.desafio.task.application.util.TaskRequestCreator;
import com.wo.desafio.task.task.application.api.TaskListResponse;
import com.wo.desafio.task.task.application.repository.TaskRepository;
import com.wo.desafio.task.task.application.service.TaskServiceImpl;
import com.wo.desafio.task.task.domain.Task;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class TaskServiceImplTest {

    @InjectMocks
    private TaskServiceImpl taskService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    void setup() {
        when(taskRepository.create(any(Task.class)))
                .thenReturn(TaskCreator.createTask());

        when(taskRepository.getAllTasks())
                .thenReturn(List.of(TaskCreator.createTask()));

        doNothing().when(taskRepository).deleteTask(any(Task.class));
    }

    @Test
    void shouldBeAbleToCreateATask() {
        UUID taskId = taskService.createTask(
                TaskRequestCreator.createTaskRequest()).id();

        Assertions.assertThat(taskId).isNotNull();
    }

    @Test
    void shouldBeAbleToListAllTasks() {
        UUID taskId = TaskCreator.createTask().getId();
        String titleTask = TaskCreator.createTask().getTitle();
        String descriptionTask = TaskCreator.createTask().getDescription();
        Boolean completedAt = TaskCreator.createTask().getCompletedAt();
//        LocalDate createdAt = TaskCreator.createTask().getCreatedAt();

        List<TaskListResponse> tasks = taskService.getAllTasks();

        Assertions.assertThat(tasks)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);

        Assertions.assertThat(tasks.get(0).getId()).isEqualTo(taskId);
        Assertions.assertThat(tasks.get(0).getTitle()).isEqualTo(titleTask);
        Assertions.assertThat(tasks.get(0).getDescription()).isEqualTo(descriptionTask);
        Assertions.assertThat(tasks.get(0).getCompletedAt()).isEqualTo(completedAt);
//        Assertions.assertThat(tasks.get(0).getCreatedAt()).isEqualTo(createdAt);
    }

    @Test
    void shouldBeAbleToDeleteATask() {
        Assertions.assertThatCode(() ->
                taskService.deleteTask(UUID.randomUUID()))
                .doesNotThrowAnyException();
    }

}