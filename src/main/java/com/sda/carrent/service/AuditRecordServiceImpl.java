package com.sda.carrent.service;

import com.sda.carrent.model.AuditRecord;
import com.sda.carrent.repository.AuditRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuditRecordServiceImpl implements AuditRecordService {

    @Autowired
    private AuditRecordRepository auditRecordRepository;

    @Override
    public void addAuditRecord(AuditRecord auditRecord) {
        auditRecordRepository.save(auditRecord);
    }
}
