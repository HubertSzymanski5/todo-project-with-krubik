package com.szymhu.todoproject.repository;

import com.szymhu.todoproject.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DbTaskDao implements TaskDao {
    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public Optional<Task> get(UUID id) {
        return Optional.empty();
    }

    @Override
    public UUID add(Task toAdd) {
        return null;
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
