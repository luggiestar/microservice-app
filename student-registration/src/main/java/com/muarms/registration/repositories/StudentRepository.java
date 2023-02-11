package com.muarms.registration.repositories;

import com.muarms.registration.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {}
