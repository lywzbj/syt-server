package com.luobd.server.common;


import com.luobd.server.common.model.ResponseData;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionController {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData<?> errorHandler(Exception e){
        if(e instanceof MethodArgumentNotValidException) {
            List<ObjectError> errors = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
          StringBuilder sb = new StringBuilder();
            Iterator<ObjectError> iterator = errors.iterator();
            while (iterator.hasNext()) {
                ObjectError next = iterator.next();
                sb.append(next.getDefaultMessage());
                if(iterator.hasNext()) {
                    sb.append(",");
                }
            }
            return ResponseData.error(sb.toString());
        }
        return ResponseData.error(e.getMessage());
    }




}
