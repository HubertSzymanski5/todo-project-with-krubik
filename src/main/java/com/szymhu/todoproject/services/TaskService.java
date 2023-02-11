package com.szymhu.todoproject.services;

import com.szymhu.todoproject.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    List<Task> getAllTasks();

    Optional<Task> getTask(UUID id);

    UUID addTask(Task task);
}
