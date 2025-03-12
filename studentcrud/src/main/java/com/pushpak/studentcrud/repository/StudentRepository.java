package com.pushpak.studentcrud.repository;

import com.pushpak.studentcrud.entity.Student;
import com.pushpak.studentcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Methods: save, findAll, findById, deleteById,

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<User> findByEmail(String email);
}
