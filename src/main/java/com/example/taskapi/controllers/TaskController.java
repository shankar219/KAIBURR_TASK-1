package com.example.taskapi.controllers;

import com.example.taskapi.model.Task;
import com.example.taskapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PutMapping
    public String createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public Iterable<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        return taskService.deleteTask(id);
    }

    @PutMapping("/execute")
    public String executeTask(@RequestParam String id) {
        return taskService.executeTask(id);
    }
}