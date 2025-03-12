package com.pushpak.todo.controller;

import com.pushpak.todo.entity.Task;
import com.pushpak.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/pushpak/tasks

//ResponseEntity improves flexibility by allowing us to customize HTTP status codes and responses.

@RestController
@RequestMapping("/pushpak/tasks")
public class TaskController {

    @Autowired
    private TaskService ts;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task newTask = ts.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
      List<Task> tasks = ts.getAllTasks();
      return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return ts.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTaskById(@PathVariable Long id){
        ts.deleteTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        return ts.updateTask(id, updatedTask);
    }

}
