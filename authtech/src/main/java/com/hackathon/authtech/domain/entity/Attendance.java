package com.hackathon.authtech.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathon.authtech.domain.Enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "attendances")
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "studentID")
    private Student studentid;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "courseID")
    private Course courseID;

    @Column(nullable = false)
    private LocalDate localDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "teacherID")
    private Teacher teacherID;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "divisionID")
    private Division divisionID;

    @JsonIgnore
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private String session;

}
