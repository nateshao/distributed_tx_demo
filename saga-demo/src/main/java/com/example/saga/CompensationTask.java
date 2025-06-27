package com.example.saga;

import javax.persistence.*;

@Entity
public class CompensationTask {
    @Id @GeneratedValue
    private Long id;
    private String type; // 如"cancelHotel"
    private String bizId; // 业务唯一标识
    private int retryCount = 0;
    private boolean dead = false;
    private boolean completed = false;

    public CompensationTask() {}
    public CompensationTask(String type, String bizId) {
        this.type = type;
        this.bizId = bizId;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getBizId() { return bizId; }
    public void setBizId(String bizId) { this.bizId = bizId; }
    public int getRetryCount() { return retryCount; }
    public void setRetryCount(int retryCount) { this.retryCount = retryCount; }
    public boolean isDead() { return dead; }
    public void setDead(boolean dead) { this.dead = dead; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
} 