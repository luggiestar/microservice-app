package com.muarms.registration.controller;

import com.muarms.registration.models.Student;
import com.muarms.registration.responses.MessageResponse;
import com.muarms.registration.responses.StudentResponse;
import com.muarms.registration.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/student/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService service;
    @PostMapping(path = "new-student")
    public Student saveStudentController(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping(path = "check-student/{studentId}")
    public StudentResponse checkStudentController(@PathVariable("studentId") Integer studentId) {
        return new StudentResponse(service.checkStudentService(studentId));
    }

    @GetMapping(path = "all-student")
    public List<Student> findAllStudent() {
        return service.getAllStudent();
    }

    @GetMapping(path = "student/{studentId}")
    public Object findStudent(@PathVariable("studentId") Integer studentId) {
        return service.findStudentById(studentId);
    }

    @DeleteMapping(path = "delete-student/{studentId}")
    public MessageResponse deleteStudentById(@PathVariable("studentId") Integer studentId) {
        return new MessageResponse(service.deleteStudent(studentId));
    }
}
