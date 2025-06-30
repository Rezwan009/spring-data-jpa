package com.rezocoding.jpa.services;

import com.rezocoding.jpa.entities.db1.EmployeeAttendance;
import com.rezocoding.jpa.entities.db2.Attendance;
import com.rezocoding.jpa.repositories.db1.EmployeeAttendanceRepository;
import com.rezocoding.jpa.repositories.db2.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DataExchangeService {

    @Autowired
    private EmployeeAttendanceRepository db1Repo;

    @Autowired
    private AttendanceRepository db2Repo;

    @Transactional("db1TransactionManager")
    public void copyFromDb2ToDb1() {
        List<Attendance> sourceData = db2Repo.findAll();
        List<EmployeeAttendance> converted = sourceData.stream().map(d -> {
            EmployeeAttendance att = new EmployeeAttendance();
            att.setEmployeeId(d.getEmpId());
            att.setRecordDate(d.getRecordDate());
            att.setRecordTime(d.getRecordTime());
            att.setRecordDateTime(d.getRecordDateTime());
            att.setAuthResult(d.getAuthResult());
            att.setCreatedAt(LocalDateTime.now());
            att.setCreatedBy("1");
            return att;
        }).toList();
        db1Repo.saveAll(converted);
    }

    @Transactional("db2TransactionManager")
    public void copyFromDb1ToDb2() {
        List<EmployeeAttendance> sourceData = db1Repo.findAll();
        List<Attendance> converted = sourceData.stream().map(d -> {
            Attendance att = new Attendance();
            att.setEmpId(d.getEmployeeId());
            att.setRecordDate(d.getRecordDate());
            att.setRecordTime(d.getRecordTime());
            att.setRecordDateTime(d.getRecordDateTime());
            att.setAuthResult(d.getAuthResult());
            att.setCreatedAt(LocalDateTime.now());
            att.setCreatedBy("1");

            return att;
        }).toList();
        db2Repo.saveAll(converted);
    }
}
