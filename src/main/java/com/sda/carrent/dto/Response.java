package com.sda.carrent.dto;

import java.util.Date;
import java.util.List;

public class Response {

    private String result;
    private Date date;
    private String message;
    private List<? extends DtoHolder> holderList;
    private String errorType;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<? extends DtoHolder> getHolderList() {
        return holderList;
    }

    public void setHolderList(List<? extends DtoHolder> holderList) {
        this.holderList = holderList;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    @Override
    public String toString() {
        return "Response{" +
                "result='" + result + '\'' +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", holderList=" + holderList +
                ", errorType='" + errorType + '\'' +
                '}';
    }
}
