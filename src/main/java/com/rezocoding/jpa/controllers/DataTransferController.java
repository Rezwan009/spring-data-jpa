package com.rezocoding.jpa.controllers;

import com.rezocoding.jpa.services.DataExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataTransferController {

    @Autowired
    private DataExchangeService dataExchangeService;

    @PostMapping("/copy-to-db1")
    public String copyToDb1() {
        dataExchangeService.copyFromDb2ToDb1();
        return "✅ Copied from DB2 → DB1";
    }

    @PostMapping("/copy-to-db2")
    public String copyToDb2() {
        dataExchangeService.copyFromDb1ToDb2();
        return "✅ Copied from DB1 → DB2";
    }
}
