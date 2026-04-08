package com.klu.skill12.service;

import com.klu.skill12.model.Student;
import com.klu.skill12.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student addStudent(Student student) {
        return repository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student student) {
        return repository.update(id, student);
    }

    public boolean deleteStudent(Long id) {
        return repository.deleteById(id);
    }
}
