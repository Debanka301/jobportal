package com.smartjob.jobportal.DTO;

import lombok.Data;

@Data
public class SignupRequest {
    private String fullName;
    private String email;
    private String password;
    private String role;
}
