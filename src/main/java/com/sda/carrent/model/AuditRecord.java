package com.sda.carrent.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audit_record")
public class AuditRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audit_record_pk")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "method")
    private String method;

    @Column(name = "url")
    private String url;

    @Column(name = "request_json")
    private String requestJson;

    @Column(name = "request_id_v6")
    private String requestIdV6;

    @Column(name = "message")
    private String message;

    @Column(name = "result")
    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
    }

    public String getRequestIdV6() {
        return requestIdV6;
    }

    public void setRequestIdV6(String requestIdV6) {
        this.requestIdV6 = requestIdV6;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
