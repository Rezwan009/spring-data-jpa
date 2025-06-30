package com.rezocoding.jpa.entities.db1;

import com.rezocoding.jpa.entities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "attendance")
public class EmployeeAttendance extends BaseEntity {

    private String employeeId;

    private LocalDateTime recordDateTime;

    private LocalDate recordDate;

    private LocalTime recordTime;

    private String authResult;
}
