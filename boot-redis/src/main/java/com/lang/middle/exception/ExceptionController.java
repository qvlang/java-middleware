package com.lang.middle.exception;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionController {
    //jackson转化json异常
    @ExceptionHandler(JsonProcessingException.class)
    public String jsonProcess(JsonProcessingException e) {
        log.error("json转化出现异常", e);
        return e.getMessage();
    }

    @ExceptionHandler(MyException.class)
    public String MyEx(MyException e) {
        log.error("出现我的错误", e);
        return e.getMessage();
    }
}
