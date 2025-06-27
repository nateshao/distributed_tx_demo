package com.example.tcc;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IdempotentRecord {
    @Id
    private String requestId;
    private String result;
    public IdempotentRecord() {}
    public IdempotentRecord(String requestId, String result) {
        this.requestId = requestId;
        this.result = result;
    }
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
} 