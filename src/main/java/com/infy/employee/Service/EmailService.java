package com.infy.employee.Service;

import jakarta.mail.MessagingException;

public interface EmailService {
    public void sendOtp(String from, String subject, String otp) throws MessagingException;

}
