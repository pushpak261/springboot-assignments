package com.pushpak.todo.service;

import com.pushpak.todo.entity.*;

import java.util.List;

//Interface Methods: createTask, getAllTasks, getTaskById, deleteTaskById, updateTask

public interface TaskService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    void deleteTaskById(Long id);

    Task updateTask(Long id, Task task);
}
