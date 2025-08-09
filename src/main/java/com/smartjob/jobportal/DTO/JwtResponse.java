package com.smartjob.jobportal.DTO;

public class JwtResponse {
    private String token;
    private String role;
    private String name;

    public JwtResponse(String token, String role, String name) {
        this.token = token;
        this.role = role;
        this.name = name;
    }

    // getters
    public String getToken() { return token; }
    public String getRole() { return role; }
    public String getName() { return name; }
}

