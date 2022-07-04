package com.phoenix.springfun.handler;

import com.phoenix.springfun.handler.exceptions.ApiRestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MessageErrorHandle {
    private static final Logger logger = LoggerFactory.getLogger("error");

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            final MethodArgumentNotValidException ex) {
        final Map<String, String> errors = new HashMap<>();
        logger.info("Bad request at "+ex.getParameter());
        ex.getBindingResult().getAllErrors().forEach((error) -> {

            final String fieldName = ((FieldError) error).getField();
            logger.warn(fieldName);
            final String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        logger.error("Errors "+errors);
        return errors;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApiRestException.class)
    ErrorMessage messageErrorHandle(final ApiRestException ex) {
        logger.info("ApiRestException... ");
        logger.error(ex.getMessage());
        ex.printStackTrace();
        return new ErrorMessage(ex.getMessage());
    }
}
