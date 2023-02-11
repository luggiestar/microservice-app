package com.arms.studentnhif.servces;

import com.arms.studentnhif.models.Nhif;
import com.arms.studentnhif.repositories.NhifRepository;
import com.arms.studentnhif.responses.StudentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class NhifService {

    private final NhifRepository repository;

    public List<Nhif> getAllNhif() {
        return repository.findAll();
    }

    public String saveNhif(Nhif nhif) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/student/check-student/"+nhif.getStudent();
        StudentResponse studentResponse = restTemplate.getForObject(url,StudentResponse.class);
        long countCardNumber = repository.findByCardNumber(nhif.getCardNumber());
        long countStudent = repository.findByStudent(nhif.getStudent());
        if(countStudent < 1) {
            if(countCardNumber < 1) {
                assert studentResponse != null;
                if (studentResponse.isAvailable()) {
                    repository.save(nhif);
                    return "saved";
                } else {
                    return "Student not found";
                }
            }
            else {
                return "Card already exist";
            }
        }
        else {
            return "Student already exist in our database";
        }
    }
}
