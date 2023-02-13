package com.arms.payment.responses;

import com.arms.payment.models.Payment;

public record SaveResponse(String message, Payment payment) {}
