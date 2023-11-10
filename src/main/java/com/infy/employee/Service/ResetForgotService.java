package com.infy.employee.Service;

import jakarta.mail.MessagingException;

public interface ResetForgotService {
    String sendEmail(String To) throws MessagingException;
}
