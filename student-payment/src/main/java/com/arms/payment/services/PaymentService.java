package com.arms.payment.services;

import com.arms.payment.models.Payment;
import com.arms.payment.repositories.PaymentRepository;
import com.arms.payment.responses.SaveResponse;
import com.arms.payment.responses.StudentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;

    public List<Payment> getAllPayment() {
        return this.repository.findAll();
    }

    public SaveResponse savePayment(Payment payment) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/student/check-student/"+payment.getStudent();
        StudentResponse studentResponse = restTemplate.getForObject(url,StudentResponse.class);
        assert studentResponse != null;

        if (studentResponse.isAvailable()) {
            return new SaveResponse("saved", repository.save(payment));
        }
        else {
            return new SaveResponse("fail", payment);
        }
    }
}
