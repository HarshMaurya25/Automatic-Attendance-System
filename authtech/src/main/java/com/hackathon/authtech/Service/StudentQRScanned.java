package com.hackathon.authtech.Service;

import com.hackathon.authtech.Repository.AttendanceRepo;
import com.hackathon.authtech.Repository.DivisionRepo;
import com.hackathon.authtech.Repository.StudentRepository;
import com.hackathon.authtech.domain.Enums.Status;
import com.hackathon.authtech.domain.dtos.ScannedQr;
import com.hackathon.authtech.domain.entity.Attendance;
import com.hackathon.authtech.domain.entity.Division;
import com.hackathon.authtech.domain.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Data
public class StudentQRScanned {

    private final AttendanceRepo attendanceRepo;
    private final DivisionRepo divisionRepo;
    private final StudentRepository studentRepository;

    public ResponseEntity<Status> markAttendance(ScannedQr dto) {
        Division division = divisionRepo.getReferenceById(dto.getDivision_id());
        Attendance studentAttendance = getStudentAttendance(dto.getStudent_id() , dto.getSession_id());

        if(division.getSessionID().equals(dto.getSession_id())){
            studentAttendance.setStatus(Status.PRESENT);
            attendanceRepo.save(studentAttendance);
            return ResponseEntity.ok(Status.PRESENT);
        }else{
            return (ResponseEntity<Status>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }

    }

    public Attendance getStudentAttendance(UUID ID , String session) {
        Student student = studentRepository.getReferenceById(ID);
        return attendanceRepo.getReferenceByStudentidAndSession(student , session);
    }
}

