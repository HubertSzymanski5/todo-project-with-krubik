package com.szymhu.todoproject.services;

import com.szymhu.todoproject.model.Task;
import com.szymhu.todoproject.repository.TaskDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskDao taskDao;

    public List<Task> getAllTasks() {
        return taskDao.getAll();
    }

    @Override
    public Optional<Task> getTask(UUID id) {
        return taskDao.get(id);
    }

    @Override
    public UUID addTask(Task task) {
        return taskDao.add(task);
    }


}
