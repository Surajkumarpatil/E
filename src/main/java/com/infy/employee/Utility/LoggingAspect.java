package com.infy.employee.Utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;

public class LoggingAspect {
    public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.infy.employee.service.*Impl.*(..))", throwing = "exception")
    public void logServiceException(Exception exception) throws Exception {
        LOGGER.error(exception.getMessage(), exception);
    }
}
