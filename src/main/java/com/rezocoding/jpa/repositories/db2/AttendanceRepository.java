package com.rezocoding.jpa.repositories.db2;

import com.rezocoding.jpa.entities.db2.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
}
