package com.example.taskapi.services;

import com.example.taskapi.model.Task;
import com.example.taskapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public String createTask(Task task) {
        if (task.getId() == null || task.getId().trim().isEmpty() ||
            task.getName() == null || task.getName().trim().isEmpty() ||
            task.getOwner() == null || task.getOwner().trim().isEmpty() ||
            task.getCommand() == null || task.getCommand().trim().isEmpty()) {
            return "All fields are required";
        }
        taskRepository.save(task);
        return "Task created";
    }

    public Iterable<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public String executeTask(String id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) return "Task not found";
        try {
            Runtime.getRuntime().exec(task.getCommand());
            return "Task executed";
        } catch (Exception e) {
            return "Execution failed: " + e.getMessage();
        }
    }

    public String deleteTask(String id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return "Task deleted";
        }
        return "Task not found";
    }
}