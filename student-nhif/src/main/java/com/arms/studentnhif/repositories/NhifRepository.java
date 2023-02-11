package com.arms.studentnhif.repositories;

import com.arms.studentnhif.models.Nhif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NhifRepository extends JpaRepository<Nhif, Integer> {

    @Query("SELECT COUNT(n) FROM Nhif n WHERE n.cardNumber=?1")
    long findByCardNumber(Integer cardNumber);

    @Query("SELECT COUNT(n) FROM Nhif n WHERE n.student=?1")
    long findByStudent(Integer student);
}
