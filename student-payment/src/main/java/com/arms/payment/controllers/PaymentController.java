package com.arms.payment.controllers;

import com.arms.payment.models.Payment;
import com.arms.payment.responses.SaveResponse;
import com.arms.payment.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "payment/")
@CrossOrigin(origins = "*")
public class PaymentController {
    private final PaymentService service;

    @GetMapping(path = "all")
    public List<Payment> findAllPayment() {
        return this.service.getAllPayment();
    }

    @PostMapping(path = "new-payment")
    public SaveResponse savePayment(@RequestBody Payment payment) {
        return this.service.savePayment(payment);
    }
}
