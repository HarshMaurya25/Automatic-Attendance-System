package com.hackathon.authtech.domain.entity;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "students")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "departmentID")
    private Department departmentID;

    @ManyToOne
    @JoinColumn(name = "divisionID")
    private Division divisionID;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private LocalDateTime dob;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "studentID" ,cascade = CascadeType.ALL )
    private List<Attendance> attendanceList;



}
