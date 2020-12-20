package main.controller.exceptionhandling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.InputMismatchException;
import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    void handleIllegalArgumentException(Exception ex, WebRequest request) {
        log.info("There was an illegal argument exception on request {} . An exception {}", request, ex);
    }

    @ExceptionHandler(value = InputMismatchException.class)
    void handleInputMismatchException(Exception ex, WebRequest request) {
        log.info("There was an input mismatch exception on request {} . An exception {}", request, ex);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    void handleNotFoundException(Exception ex, WebRequest request) {
        log.info("There was a not found exception on request {} . An exception {}", request, ex);
    }

    @ExceptionHandler(value = Exception.class)
    void handleException(Exception ex, WebRequest request) {
        String exceptionID = UUID.randomUUID().toString();
        log.error("There was an error on request {} with exceptionID {} {}", request, exceptionID, ex);
    }
}
