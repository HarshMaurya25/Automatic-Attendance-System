package com.hackathon.authtech.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ScannedQr {
    private UUID student_id;
    private String session_id;
    private UUID division_id;
}
