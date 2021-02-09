package com.ndangduc.bn.mybatisspringboot.help.exception;

import com.ndangduc.bn.mybatisspringboot.controller.dto.res.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalHanlderException {
    public ResponseEntity<ResponseObject<?>> studentExceptionHanlder(StudentException studentException) {
        ResponseObject responseObject = new ResponseObject(false, studentException);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
}
