package com.pushpak.todo.repository;

import com.pushpak.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaMethods: save, findAll, findById, deleteById

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
