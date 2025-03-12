package com.pushpak.studentcrud.service;


//methods: saveStudent, getAllStudents, getStudentById, updateStudent, deleteStudent


import com.pushpak.studentcrud.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student student);

    void deleteStudentById(Long id);
}
