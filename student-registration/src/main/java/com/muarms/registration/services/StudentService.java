package com.muarms.registration.services;

import com.muarms.registration.models.Student;
import com.muarms.registration.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public boolean checkStudentService(Integer studentId) {
        long student = repository.findById(studentId).stream().count();
        return student == 1;
    }

    public String deleteStudent(Integer studentId) {
        long count = repository.findById(studentId).stream().count();
        if (count==1) {
            repository.deleteById(studentId);
            return "deleted";
        }
        else {
            return "student with given id not not registered";
        }

    }

    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    public Object findStudentById(Integer studentId) {
        return repository.findById(studentId);
    }
}
