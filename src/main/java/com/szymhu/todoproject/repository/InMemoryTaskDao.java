package com.szymhu.todoproject.repository;

import com.szymhu.todoproject.model.Task;

import java.util.*;

public class InMemoryTaskDao implements TaskDao {

    private final Map<UUID, Task> db = new HashMap<>();

    public InMemoryTaskDao() {
        add(Task.builder()
                .id(UUID.randomUUID())
                .done(false)
                .name("Siema eniu")
                .build());
    }


    @Override
    public List<Task> getAll() {
        return db.values().stream().toList();
    }

    @Override
    public Optional<Task> get(UUID id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public UUID add(Task task) {
        UUID taskId = UUID.randomUUID();
        Task complete = Task.builder()
                .id(taskId)
                .name(task.name())
                .description(task.description())
                .done(task.done())
                .build();
        db.put(taskId, complete);
        return taskId;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean complete(UUID id) {
        return false;
    }
}
