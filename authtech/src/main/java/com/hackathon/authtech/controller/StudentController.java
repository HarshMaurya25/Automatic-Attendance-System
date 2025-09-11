package com.hackathon.authtech.controller;

import com.hackathon.authtech.Repository.AttendanceRepo;
import com.hackathon.authtech.domain.Enums.Status;
import com.hackathon.authtech.domain.dtos.ScannedQr;
import com.hackathon.authtech.domain.entity.Attendance;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class StudentController {
    public ResponseEntity<Status> markAttandace(
            @RequestBody ScannedQr dto
            ){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
