package com.arms.studentexamresult.services;

import com.arms.studentexamresult.Repositories.StudentResultRepository;
import com.arms.studentexamresult.models.StudentResult;
import com.arms.studentexamresult.responses.StudentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentResultService {
    private final StudentResultRepository repository;

    public String saveStudentResultService(StudentResult result) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/student/check-student/"+result.getStudent();
        StudentResponse studentAvailability = restTemplate.getForObject(url, StudentResponse.class);
        assert studentAvailability != null;
        if (studentAvailability.isAvailable()) {
            repository.save(result);
            return "Saved";
        }
        else {
            return "Student with given id not found";
        }
    }

    public List<StudentResult> findStudentResult(Integer student) {
        return repository.findAllByStudent(student);
    }
}
