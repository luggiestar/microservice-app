package com.arms.roombooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingId;
    private Integer room;
    private LocalDate bookingDate;
}
