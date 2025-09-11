package com.hackathon.authtech.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "divisions")
@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(nullable = false)
    @UniqueElements
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "departmentID")
    private Department departmentID;

    @ManyToMany
    @JoinTable(
            name = "divisionList",
            joinColumns =@JoinColumn(name = "divisionList"),
            inverseJoinColumns = @JoinColumn(name = "courseList")
    )
    @JsonIgnore
    private List<Course> courseList;

    @Column(nullable = false)
    private String sessionID;

    @JsonIgnore
    @OneToMany(mappedBy = "divisionID" ,cascade = CascadeType.ALL )
    private List<Attendance> attendanceList;

    @JsonIgnore
    @OneToMany(mappedBy = "divisionID" , cascade = CascadeType.ALL)
    public List<Student> studentList;


    public List<Student> s(){
        return studentList;
    }


}
