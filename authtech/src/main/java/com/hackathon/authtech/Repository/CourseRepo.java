package com.hackathon.authtech.Repository;

import com.hackathon.authtech.domain.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepo extends JpaRepository<Course , UUID> {
}
