package com.arms.studentexamresult.Repositories;

import com.arms.studentexamresult.models.StudentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface StudentResultRepository extends JpaRepository<StudentResult, Integer> {

    @Query("SELECT r FROM StudentResult r WHERE r.student = ?1")
    List<StudentResult> findAllByStudent(Integer student);
}
