package com.sda.carrent.handler;

import com.sda.carrent.dto.Response;
import com.sda.carrent.dto.ResponseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@Component
public class GlobalExceptionHandler {

    private final ResponseMapper responseMapper;
    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    public GlobalExceptionHandler(ResponseMapper responseMapper) {
        this.responseMapper = responseMapper;
    }

    @ExceptionHandler(value = {Exception.class})
    public Response handleAnyException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return responseMapper.mapFail(ex.getMessage(), "ERROR");
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Response handleAnyException(MethodArgumentNotValidException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return responseMapper.mapFail("Provided data is not correct", "ERROR");
    }


}
