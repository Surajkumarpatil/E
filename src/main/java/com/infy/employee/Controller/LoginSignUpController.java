package com.infy.employee.Controller;

import com.infy.employee.DTO.LoginDTO;
import com.infy.employee.DTO.RegisterDTO;
import com.infy.employee.Service.LoginSignUpService;
import com.infy.employee.Utility.LoginResponse;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class LoginSignUpController {

    @Autowired
    private LoginSignUpService loginSignUpService;

    @Autowired
    private Environment environment;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody RegisterDTO registerDTO) {
       Integer employeeId = loginSignUpService.signUp(registerDTO);
       String successMessage = environment.getProperty("API.INSERT_SUCCESS") + employeeId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@Valid @RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = loginSignUpService.loginEmployee(loginDTO);
        return new ResponseEntity<>(loginResponse,HttpStatus.OK);
    }
}
