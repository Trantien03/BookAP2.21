package org.example.bookap22.Controller;


import jakarta.servlet.http.HttpSession;
import org.example.bookap22.Entity.AppUser;
import org.example.bookap22.Service.UserService;
import org.example.bookap22.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin("http://localhost:3000")

public class LoginController {
    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto, HttpSession session) {
        Optional<AppUser> user = Optional.ofNullable(userService.getUserByUsername(loginDto.getUsername()));
        if (user.isPresent() && user.get().getPassword().equals(loginDto.getPassword())) {
            AppUser userDetails = user.get();
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

}
