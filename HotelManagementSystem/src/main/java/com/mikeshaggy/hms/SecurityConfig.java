//package com.mikeshaggy.hms;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
//        try {
//            http
//                    .authorizeHttpRequests((authz) -> authz
//                            .requestMatchers("/login").permitAll()
//                            .anyRequest().authenticated()
//                            .and()
//                    .formLogin(formLogin ->
//                            formLogin
//                                    .loginPage("/login")
//                                    .permitAll()
//                                    .and()
//                                    .logout()
//                    )
//                    .httpBasic(withDefaults())
//            return http.build();
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//    }
//}