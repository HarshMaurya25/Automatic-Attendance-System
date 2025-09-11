package com.hackathon.authtech.Repository;

import com.hackathon.authtech.domain.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DivisionRepo extends JpaRepository<Division , UUID> {

    Optional<Division> findById(UUID id);
}
