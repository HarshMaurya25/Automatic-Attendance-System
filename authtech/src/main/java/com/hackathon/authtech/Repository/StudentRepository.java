package com.hackathon.authtech.Repository;

import com.hackathon.authtech.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student , UUID> {
    Student findByMail(String mail);
    List<Student> findByDivisionIDUuid(UUID divisionId);
}
