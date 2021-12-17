package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Component
@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }

    public void addStudent(Student student) {
        System.out.println("received student:" + student.toString());
        Optional<Student> optionalStudent = repository.findStudentsByEmail(student.getEmail());
        if (optionalStudent.isPresent()) {
            throw new IllegalStateException("Email is already used!");
        }
        repository.saveAndFlush(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = repository.existsById(id);
        if (!exists)
            throw new IllegalStateException("student with id " + id + " doesn't exist");
        repository.deleteById(id);
        System.out.println("Student is deleted !");
    }


    @Transactional
    public void updateStudent(Long id, String name, String email) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("student with id " + id + " doesn't exist"));


        if (name != null && !name.isEmpty()) {
            student.setName(name);
        }
        if (email != null && !email.isEmpty()) {
            Optional<Student> optionalStudent = repository.findStudentsByEmail(email);
            if (optionalStudent.isPresent()) {
                throw new IllegalStateException("Email is taken!");
            }
            student.setEmail(email);
        }
    }
}
