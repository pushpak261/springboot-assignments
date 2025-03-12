package com.pushpak.studentcrud.controller;


import com.pushpak.studentcrud.entity.Student;
import com.pushpak.studentcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Methods: createStudent, getALlStudents, getStudentById, updateStudent, deleteStudent

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pushpak/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "Student Deleted Successfully";
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }
}
