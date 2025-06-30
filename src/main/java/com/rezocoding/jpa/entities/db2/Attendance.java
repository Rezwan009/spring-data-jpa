package com.rezocoding.jpa.entities.db2;

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
public class Attendance extends BaseEntity {

    private String empId;

    private LocalDateTime recordDateTime;

    private LocalDate recordDate;

    private LocalTime recordTime;

    private String authResult;

}
