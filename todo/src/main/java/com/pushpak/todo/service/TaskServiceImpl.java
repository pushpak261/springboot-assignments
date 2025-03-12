package com.pushpak.todo.service;

import com.pushpak.todo.entity.Task;
import com.pushpak.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository tr;

    @Override
    public Task createTask(Task task) {
        return tr.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return tr.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return tr.findById(id).orElseThrow(()->new RuntimeException("Task not found"));
    }

    @Override
    public void deleteTaskById(Long id) {
        tr.deleteById(id);
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
       Task task = getTaskById(id);
       task.setTitle(updatedTask.getTitle());
       task.setDescription(updatedTask.getDescription());
       task.setCompleted(updatedTask.isCompleted());
       return tr.save(task);
    }
}
