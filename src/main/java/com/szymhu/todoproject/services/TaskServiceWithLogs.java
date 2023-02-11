package com.szymhu.todoproject.services;

import com.szymhu.todoproject.model.Task;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// design pattern - decorator
@Slf4j
@AllArgsConstructor
public class TaskServiceWithLogs implements TaskService {

    private TaskService wrapped;

    @Override
    public List<Task> getAllTasks() {
        var result = wrapped.getAllTasks();
        log.info("all tasks size: {}" , result.size());
        return result;
    }

    @Override
    public Optional<Task> getTask(UUID id) {
        var result = wrapped.getTask(id);
        result.ifPresentOrElse(
                foundTask -> log.info("task with id: {} returned", foundTask.id()),
                () -> log.info("task with id {} not found", id));
        return result;
    }

    @Override
    public UUID addTask(Task task) {
        var result = wrapped.addTask(task);
        log.info("created task with id {}", result);
        return result;
    }
}
