package com.rezocoding.jpa.repositories.db1;

import com.rezocoding.jpa.entities.db1.EmployeeAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAttendanceRepository extends JpaRepository<EmployeeAttendance, Integer> {
}
