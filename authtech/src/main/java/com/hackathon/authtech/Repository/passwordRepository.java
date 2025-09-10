package com.hackathon.authtech.Repository;

import com.hackathon.authtech.domain.entity.Passwords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface passwordRepository extends JpaRepository<Passwords, UUID> {
    Passwords findByMail(String mail);
}
