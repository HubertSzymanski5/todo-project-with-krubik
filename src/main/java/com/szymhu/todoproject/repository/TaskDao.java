package com.szymhu.todoproject.repository;

import com.szymhu.todoproject.model.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskDao {

    List<Task> getAll();
    Optional<Task> get(UUID id);
    UUID add(Task toAdd);
    boolean delete(UUID id);
    boolean complete(UUID id);

    default void method() {
        //
    }
}
