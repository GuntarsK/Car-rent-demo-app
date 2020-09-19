package com.sda.carrent.web.interceptors;

import com.sda.carrent.model.AuditRecord;
import com.sda.carrent.service.AuditRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class RestControllerInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(RestControllerInterceptor.class);

    @Autowired
    private AuditRecordService auditRecordService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        String requestBody = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);

        AuditRecord auditRecord = new AuditRecord();
        auditRecord.setDate(new Date());
        auditRecord.setRequestIdV6(request.getRemoteAddr());
        auditRecord.setMethod(request.getMethod());
        auditRecord.setRequestJson(requestBody);
        auditRecord.setUrl(request.getRequestURL().toString());
//        auditRecord.setResult(String.valueOf(response.getStatus()));
        auditRecordService.addAuditRecord(auditRecord);
        logger.info("Entered preHandle interceptor");

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        super.afterCompletion(request,response, handler, ex);
    }

}
