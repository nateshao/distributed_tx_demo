package com.example.tcc;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.validation.BindException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseEntity<String> handleValidationException(Exception ex) {
        String msg = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("参数校验失败: " + msg);
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleOtherException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务异常: " + ex.getMessage());
    }
} 