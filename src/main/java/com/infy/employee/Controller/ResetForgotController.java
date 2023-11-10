package com.infy.employee.Controller;

import com.infy.employee.Service.EmployeeService;
import com.infy.employee.Service.ResetForgotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ResetForgotController {

    @Autowired
    private ResetForgotService service;

    // endpoint to send otp over email if the email is valid
    @GetMapping("/forgotPassword/{emailId}")
    public ResponseEntity<String> forgotPassword(@PathVariable String emailId) throws Exception {
        String otp = service.sendEmail(emailId);
        return new ResponseEntity<>(otp, HttpStatus.OK);
    }

}
