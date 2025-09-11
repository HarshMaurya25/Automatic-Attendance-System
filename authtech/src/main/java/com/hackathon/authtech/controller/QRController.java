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
    private final StudentRepository studentRepo;

    @GetMapping("/division/{id}/students")
    public List<Student> getStudentFromDivision(@PathVariable UUID id) {
        List<Student> students = studentRepo.findByDivisionIDUuid(id);
        return students;
    }

    public Division division(UUID ID){
        return drepo.getReferenceById(ID);
    }

    @PostMapping("/division/lecture")
    public ResponseEntity<?> QrMake(@RequestBody QRDTO dto) {
        Division div = division(dto.getDivisionID());

        List<Student> students = div.getStudentList();
        if (students == null || students.isEmpty()) {
            return ResponseEntity.status(404)
                    .body("No students found for division " + dto.getDivisionID());
        }

        Teacher teacher = teacherRepo.getById(dto.getTeacherID());
        Course course = courseRepo.getById(dto.getCourseID());

        List<Attendance> attendanceList = students.stream()
                .map(student -> new Attendance(
                        null, student, course, LocalDate.now(), teacher, div, Status.ABSENT , dto.getSessionID()
                ))
                .toList();

        // assign session ID to division
        div.setSessionID(dto.getSessionID());
        drepo.save(div);

        arepo.saveAll(attendanceList);

        return ResponseEntity.ok(attendanceList);
    }
}
