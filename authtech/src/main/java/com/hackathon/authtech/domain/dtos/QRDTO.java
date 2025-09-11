package com.hackathon.authtech.domain.dtos;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class QRDTO{

    private UUID teacherID;
    private UUID courseID;
    private UUID divisionID;
    private String sessionID;
}
