package com.hackathon.authtech.controller;


import com.hackathon.authtech.Repository.passwordRepository;
import com.hackathon.authtech.Repository.StudentRepository;
import com.hackathon.authtech.domain.dtos.LoginRequest;
import com.hackathon.authtech.domain.entity.Passwords;
import com.hackathon.authtech.domain.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final passwordRepository passwordRepository;
    private final StudentRepository studentRepository;

    @GetMapping("/login")
    public ResponseEntity<Optional<Student>> login(@RequestBody LoginRequest request) {
        Passwords passwordEntry = passwordRepository.findByMail(request.getMail());

        if (passwordEntry != null && passwordEntry.getPassword().equals(request.getPassword())) {
            Passwords passwords= passwordRepository.findByMail(request.getMail());
            Optional<Student> student = studentRepository.findById(passwords.getUuid());
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}