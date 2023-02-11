package com.szymhu.todoproject.controllers;

import com.szymhu.todoproject.model.Task;
import com.szymhu.todoproject.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<?> getAllTasks() { // @RequestParam(required = false) String name
        List<Task> allTasks = taskService.getAllTasks();
        return ResponseEntity.ok(allTasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskWithId(@PathVariable UUID id) {
        Optional<Task> task = taskService.getTask(id);
        if (task.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("error", "Task with id " + id + " not found"));
        }
        return ResponseEntity.ok(task.get());
    }

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        var resultId = taskService.addTask(task);
        return ResponseEntity
                .status(201)
                .body(Map.of("id", resultId,
                        "message", "Task has been created successfully"));
    }
}
