package com.hackathon.authtech.controller;


import com.hackathon.authtech.Repository.*;
import com.hackathon.authtech.Service.AttandanceService;
import com.hackathon.authtech.domain.Enums.Status;
import com.hackathon.authtech.domain.dtos.Id;
import com.hackathon.authtech.domain.dtos.QRDTO;
import com.hackathon.authtech.domain.entity.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class QRController {

    private DivisionRepo drepo;
    private AttendanceRepo arepo;
    private AttandanceService attandaceService;
    private CourseRepo courseRepo;
    private TeacherRepo teacherRepo;

    @GetMapping("/division/student")
    public List<Student> getStudentFromDivision(
            @RequestBody Id ID
            ){
        Division div = division(ID.id);

        List<Student> students = div.studentList;

        return students;

    }

    public Division division(UUID ID){
        return drepo.findById(ID)
                    .orElseThrow(() -> new RuntimeException("User not found with id: " ));
    }

    @PostMapping("/division/lecture")
    public ResponseEntity QrMake(
            @RequestBody QRDTO dto
    ){
        Division div = division(dto.getDivisionID());

        List<Student> students = div.studentList;
        Teacher teachers = teacherRepo.getById(dto.getTeacherID());

        Course course = courseRepo.getById(dto.getCourseID());

        List<Attendance> attendanceList = students.stream()
                .map(student -> new Attendance(null, student , course, LocalDate.now(),teachers, div , Status.ABSENT))
                .toList();

        for(Attendance attendance : attendanceList){
            System.out.println(attendance.toString());
        }

        Division division = drepo.getReferenceById(dto.getDivisionID());
        division.setSessionID(dto.getSessionID());
        drepo.save(division);

        arepo.saveAll(attendanceList);

        return ResponseEntity.ok().build();
    }
}
