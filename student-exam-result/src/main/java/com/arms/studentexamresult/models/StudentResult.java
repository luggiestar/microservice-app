package com.arms.studentexamresult.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class StudentResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private Integer student;
    private String course;
    private String score;
}
