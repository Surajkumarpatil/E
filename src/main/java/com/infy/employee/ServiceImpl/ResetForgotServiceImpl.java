package com.infy.employee.ServiceImpl;

import com.infy.employee.Entity.Employee;
import com.infy.employee.Exception.EmployeeException;
import com.infy.employee.Repo.EmployeeRepo;
import com.infy.employee.Service.EmailService;
import com.infy.employee.Service.ResetForgotService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class ResetForgotServiceImpl implements ResetForgotService {

    @Autowired
    private EmployeeRepo repo;

    @Autowired
    EmailService emailService;

    // method to send an otp if the email is valid
    @Override
    public String sendEmail(String to) throws MessagingException {
        Employee employee1 = repo.findByEmailId(to);
        if (employee1.isEmpty())
            throw new EmployeeException("Service.INVALID_EMAIL");

        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000;
        String otp = Integer.toString(randomNumber);

        String subject = "Reset Your Password";
        emailService.sendOtp(to, subject, otp);

        return otp;
    }
}
