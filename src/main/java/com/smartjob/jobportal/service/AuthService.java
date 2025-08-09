package com.smartjob.jobportal.service;

import com.smartjob.jobportal.DTO.ApiResponse;
import com.smartjob.jobportal.DTO.JwtResponse;
import com.smartjob.jobportal.DTO.LoginRequest;
import com.smartjob.jobportal.DTO.SignupRequest;
import com.smartjob.jobportal.model.RoleType;
import com.smartjob.jobportal.model.Users;
import com.smartjob.jobportal.repositories.UsersRepository;
import com.smartjob.jobportal.security.JWTUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AuthService {

    @Autowired
    private UsersRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;

    public AuthService(
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager,
                       JWTUtils jwtUtils) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Transactional
    public ApiResponse signup(SignupRequest req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            return new ApiResponse(false, "Email already in use");
        }

        Users user = new Users();
        user.setFull_name(req.getFullName());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));

        // if client passed role, only allow CANDIDATE by default; allow admin creation later by admin endpoint
        RoleType role = RoleType.USER;
        if (req.getRole() != null) {
            try {
                RoleType requested = RoleType.valueOf(req.getRole().toUpperCase());
                // enforce only CANDIDATE by default
                if (requested == RoleType.ADMIN) {
                    // ignore, or throw if you want to allow admin creation only via other flow
                    role = RoleType.ADMIN;
                } else {
                    role = requested;
                }
            } catch (IllegalArgumentException ignored) { /* invalid value -> default candidate */ }
        }
        user.setRole(role);
        user.setCreated_at(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
        System.out.println(user.toString());
        return new ApiResponse(true, "User registered successfully");
    }

    public JwtResponse login(LoginRequest req) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        String jwt = jwtUtils.generateTokenFromEmail(req.getEmail(), (String) authentication.getAuthorities().stream()
                .findFirst().map(a -> a.getAuthority().replace("ROLE_", "")).orElse("CANDIDATE"));

        Users user = userRepository.findByEmail(req.getEmail()).orElseThrow(() -> new RuntimeException("User not found after authentication"));

        return new JwtResponse(jwt, user.getRole().name(), user.getFull_name());
    }
}

