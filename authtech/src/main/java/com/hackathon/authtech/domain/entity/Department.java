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
@Table(name = "departments")
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false , unique = true)
    private String name;

    @Column(nullable = false , name = "COLLEGENAME")
    private String collegeName;

    @JsonIgnore
    @OneToMany(mappedBy = "departmentID" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Division> divisionList;

    @JsonIgnore
    @OneToMany(mappedBy = "departmentID" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Course> courseList;

    @JsonIgnore
    @OneToMany(mappedBy = "departmentID" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Student> studentList;

    @JsonIgnore
    @OneToMany(mappedBy = "departmentID" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Teacher> teacherID;
}
