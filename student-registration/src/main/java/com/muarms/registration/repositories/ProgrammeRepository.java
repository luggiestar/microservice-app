package com.muarms.registration.repositories;

import com.muarms.registration.models.Programme;
import com.muarms.registration.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgrammeRepository extends JpaRepository<Programme, Integer> {
    @Query("SELECT COUNT(p) FROM Programme  p WHERE  p.name=?1")
    long findByName(String name);
}
