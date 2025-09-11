package com.hackathon.authtech.Service;

import com.hackathon.authtech.Repository.AttendanceRepo;
import com.hackathon.authtech.domain.Enums.Status;
import com.hackathon.authtech.domain.dtos.ScannedQr;
import com.hackathon.authtech.domain.entity.Attendance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class StudentQRScanned {

    private final AttendanceRepo attendanceRepo;

    public ResponseEntity<Status> markAttendance(
          ScannedQr dto
    ){
        Attendance studentAttendance = getStudentAttendance(dto.getStudent_id());

    }

    public Attendance getStudentAttendance(UUID studentID){
        return attendanceRepo.getReferenceById(studentID);
    }

}
