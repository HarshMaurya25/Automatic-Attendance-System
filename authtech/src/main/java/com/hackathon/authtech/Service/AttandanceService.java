package com.hackathon.authtech.Service;

import com.hackathon.authtech.Repository.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
@Builder
public class AttandanceService{

    private DivisionRepo lectureRepo;

    private StudentRepository studentRepo;

    private AttendanceRepo attendanceRepo;

    private CourseRepo crepo;

    private TeacherRepo trepo;



}
