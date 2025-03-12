package com.todo.services;

import com.todo.models.Task;
import com.todo.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Récupérer toutes les tâches
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Récupérer une tâche par son ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Ajouter une nouvelle tâche
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    // Supprimer une tâche
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Mettre à jour une tâche
    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setCompleted(updatedTask.isCompleted());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }
}