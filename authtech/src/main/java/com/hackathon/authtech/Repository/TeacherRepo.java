package com.hackathon.authtech.Repository;

import com.hackathon.authtech.domain.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher , UUID> {
}
