package com.pushpak.studentcrud.service;

import com.pushpak.studentcrud.entity.Student;
import com.pushpak.studentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student Not found"));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
       Student existingStudent = getStudentById(id);
       existingStudent.setName(student.getName());
       existingStudent.setEmail(student.getEmail());
       existingStudent.setCourse(student.getCourse());
       return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
