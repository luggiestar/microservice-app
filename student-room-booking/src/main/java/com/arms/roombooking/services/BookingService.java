package com.arms.roombooking.services;

import com.arms.roombooking.repositories.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository repository;
}
