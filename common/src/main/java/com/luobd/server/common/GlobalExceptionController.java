package com.luobd.server.common;


import com.luobd.server.common.model.ResponseData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionController {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData errorHandler(Exception e){
        return ResponseData.error(e.getMessage());
    }




}
