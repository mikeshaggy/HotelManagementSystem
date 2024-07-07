package com.mikeshaggy.hms.controller;

import com.mikeshaggy.hms.dto.AuthResponseDto;
import com.mikeshaggy.hms.dto.LoginDto;
import com.mikeshaggy.hms.dto.RegisterDto;
import com.mikeshaggy.hms.model.Employee;
import com.mikeshaggy.hms.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private final AuthService authService;

    public AuthRestController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> register(@RequestBody RegisterDto registerDto) {
        if (authService.userExists(registerDto.getUsername())) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(authService.registerUser(registerDto));
    }
}
