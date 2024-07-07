package com.mikeshaggy.hms.service;

import com.mikeshaggy.hms.dto.AuthResponseDto;
import com.mikeshaggy.hms.dto.LoginDto;
import com.mikeshaggy.hms.dto.RegisterDto;
import com.mikeshaggy.hms.model.Role;
import com.mikeshaggy.hms.model.Employee;
import com.mikeshaggy.hms.repository.RoleRepository;
import com.mikeshaggy.hms.repository.EmployeeRepository;
import com.mikeshaggy.hms.security.jwt.JWTGenerator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;

    public AuthService(AuthenticationManager authenticationManager, EmployeeRepository employeeRepository,
                       RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    public AuthResponseDto login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new AuthResponseDto(token);
    }

    public boolean userExists(String username) {
        return employeeRepository.existsByUsername(username);
    }

    public Employee registerUser(RegisterDto registerDto) {
        Employee user = new Employee();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        employeeRepository.save(user);

        return user;
    }
}
