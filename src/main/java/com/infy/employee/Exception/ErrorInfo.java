package com.infy.employee.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorInfo {
    Date timestamp;
    String message;
    Boolean status;
}
