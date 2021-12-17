package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/v1/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/api/v1/add")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "/api/v1/delete/{student_id}")
    public void deleteStudent(@PathVariable("student_id") Long studentID) {
        studentService.deleteStudent(studentID);
    }

    @PutMapping(path = "/api/v1/delete/{student_id}")
    public void updateStudent(
            @PathVariable("student_id") Long studentID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {

        studentService.updateStudent(studentID,name,email);

    }
}
