package com.arms.roombooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roomId;
    private String roomNumber;
    private Integer capacity;
}
