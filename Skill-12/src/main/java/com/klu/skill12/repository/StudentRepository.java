package com.klu.skill12.repository;

import com.klu.skill12.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(3);

    public StudentRepository() {
        students.add(new Student(1L, "Aarav Reddy", "aarav@example.com", "CSE"));
        students.add(new Student(2L, "Diya Sharma", "diya@example.com", "ECE"));
        students.add(new Student(3L, "Rahul Verma", "rahul@example.com", "AI & DS"));
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public Student save(Student student) {
        student.setId(counter.incrementAndGet());
        students.add(student);
        return student;
    }

    public Optional<Student> findById(Long id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public Optional<Student> update(Long id, Student updatedStudent) {
        Optional<Student> existing = findById(id);
        existing.ifPresent(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setCourse(updatedStudent.getCourse());
        });
        return existing;
    }

    public boolean deleteById(Long id) {
        return students.removeIf(student -> student.getId().equals(id));
    }
}
