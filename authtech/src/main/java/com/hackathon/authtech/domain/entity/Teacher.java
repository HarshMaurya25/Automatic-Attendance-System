package com.hackathon.authtech.domain.entity;

import com.hackathon.authtech.domain.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "teachers")
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "departmentID")
    private Department departmentID;

    @ManyToMany
    @JoinTable(
            name = "teacherList",
            joinColumns =@JoinColumn(name = "teacherList"),
            inverseJoinColumns = @JoinColumn(name = "courseList")
    )
    private List<Course> courseList;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false)
    private String contactNumber;

    @Column(nullable = false)
    private String mail;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @OneToMany(mappedBy = "teacherID" ,cascade = CascadeType.ALL )
    private List<Attendance> attendanceList;

}
