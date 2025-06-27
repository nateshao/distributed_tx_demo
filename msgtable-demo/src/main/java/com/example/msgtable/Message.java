package com.example.msgtable;

import javax.persistence.*;

@Entity
public class Message {
    @Id @GeneratedValue
    private Long id;
    private String content;
    private boolean sent = false;
    private int retryCount = 0;
    private boolean dead = false;
    public Message() {}
    public Message(String content) { this.content = content; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public boolean isSent() { return sent; }
    public void setSent(boolean sent) { this.sent = sent; }
    public int getRetryCount() { return retryCount; }
    public void setRetryCount(int retryCount) { this.retryCount = retryCount; }
    public boolean isDead() { return dead; }
    public void setDead(boolean dead) { this.dead = dead; }
} 