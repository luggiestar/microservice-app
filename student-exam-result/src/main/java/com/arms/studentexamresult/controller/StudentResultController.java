package com.arms.studentexamresult.controller;

import com.arms.studentexamresult.models.StudentResult;
import com.arms.studentexamresult.responses.StudentResultResponse;
import com.arms.studentexamresult.services.StudentResultService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@RestController
@RequestMapping(path = "/student-result/")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class StudentResultController {
    private final StudentResultService service;

    @PostMapping("add")
    public StudentResultResponse saveStudentResult(@RequestBody StudentResult studentResult) {
        return new StudentResultResponse(service.saveStudentResultService(studentResult));
    }

    @GetMapping(path = "student-result/{student}")
    public List<StudentResult> findStudentResult(@PathVariable("student") Integer student) {
        return service.findStudentResult(student);
    }
}
