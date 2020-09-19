package com.sda.carrent.dto;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ResponseMapper {

    public Response mapSuccess(List<? extends DtoHolder> dtoHolders) {
        Response response = new Response();

        response.setHolderList(dtoHolders);
        response.setDate(new Date());
        response.setResult("SUCCESS");
        return response;
    }

    public Response mapSuccess(DtoHolder dtoHolders) {
        Response response = new Response();

        response.setHolderList(ImmutableList.of(dtoHolders));
        response.setDate(new Date());
        response.setResult("SUCCESS");
        return response;
    }

    public Response mapFail(String message, String errorType) {
        Response response = new Response();

        response.setDate(new Date());
        response.setResult("ERROR");
        response.setMessage(message);
        response.setErrorType(errorType);
        return response;
    }



}


