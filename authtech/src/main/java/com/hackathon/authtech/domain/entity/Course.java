package com.hackathon.authtech.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "courses")
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String course_name;

    @ManyToOne
    @JoinColumn(name = "departmentID")
    private Department departmentID;

    @Column(nullable = false)
    private Integer semester;

    @JsonIgnore
    @Column(nullable = false)
    @OneToMany(mappedBy = "courseID" ,cascade = CascadeType.ALL )
    private List<Attendance> attendanceList;

    @JsonIgnore
    @ManyToMany(mappedBy = "courseList")
    private List<Teacher> teacherList;

    @JsonIgnore
    @ManyToMany(mappedBy = "courseList")
    private List<Division> divisionList;

}
