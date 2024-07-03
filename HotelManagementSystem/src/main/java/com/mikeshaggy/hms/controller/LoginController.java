//package com.mikeshaggy.hms.controller;
//
////import com.mikeshaggy.hms.user.myentity.User;
//import com.mikeshaggy.hms.user.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/app/login")
//public class LoginController {
//
//    private final UserService userService;
//
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String login() {
//        return "login";
//    }
//
//    @PostMapping
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
////        return ResponseEntity.ok().body(userService.validateUser(username, password));
////        User user = userService.validateUser(username, password);
//        return "dashboard";
//    }
//}
