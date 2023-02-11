package com.szymhu.todoproject.config;

import com.szymhu.todoproject.repository.InMemoryTaskDao;
import com.szymhu.todoproject.repository.TaskDao;
import com.szymhu.todoproject.services.TaskService;
import com.szymhu.todoproject.services.TaskServiceImpl;
import com.szymhu.todoproject.services.TaskServiceWithLogs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TaskDao taskDao() {
        return new InMemoryTaskDao();
    }

    @Bean
    public TaskService taskService(TaskDao taskDao) {
        return new TaskServiceWithLogs(new TaskServiceImpl(taskDao));
    }
}
