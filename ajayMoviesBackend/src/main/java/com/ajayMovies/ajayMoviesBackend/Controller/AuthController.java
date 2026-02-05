package com.ajayMovies.ajayMoviesBackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.ajayMovies.ajayMoviesBackend.DTO.LoginReqDTO;
import com.ajayMovies.ajayMoviesBackend.DTO.LoginResponseDTO;
import com.ajayMovies.ajayMoviesBackend.Entity.Admin;
import com.ajayMovies.ajayMoviesBackend.JWT.JwtUtil;
import com.ajayMovies.ajayMoviesBackend.Repository.AdminRepo;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="http://localhost:4200")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AdminRepo adminRepo;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDTO loginReq){
        logger.info("Login attempt for email: {}", loginReq.getEmail());
        
        try {
            //checks the email 
            Admin admin = adminRepo.findByEmail(loginReq.getEmail())
                .orElseThrow(() -> {
                    logger.warn("Email not found: {}", loginReq.getEmail());
                    return new RuntimeException("Invalid Email");
                });

            //Match the Real Admin and Req Admin Password
            if(!passwordEncoder.matches(loginReq.getPassword(), admin.getPassword())){
                logger.warn("Invalid password for email: {}", loginReq.getEmail());
                throw new RuntimeException("Invalid Password");
            }

            //if Correct Generate token
            String token = jwtUtil.generateToken(admin.getEmail());
            logger.info("Login successful for email: {}", loginReq.getEmail());
            
            return ResponseEntity.ok(new LoginResponseDTO(token));
            
        } catch (Exception e) {
            logger.error("Login failed for email: {} - Error: {}", loginReq.getEmail(), e.getMessage());
            return ResponseEntity.badRequest().body("Login failed: " + e.getMessage());
        }
    }

    @PostMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Backend is working!");
    }
}