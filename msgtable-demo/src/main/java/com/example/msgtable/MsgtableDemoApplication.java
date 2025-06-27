package com.example.msgtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class MsgtableDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsgtableDemoApplication.class, args);
    }
}

@Entity
class Message {
    @Id @GeneratedValue
    private Long id;
    private String content;
    private boolean sent = false;
    public Message() {}
    public Message(String content) { this.content = content; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public boolean isSent() { return sent; }
    public void setSent(boolean sent) { this.sent = sent; }
}

interface MessageRepository extends org.springframework.data.jpa.repository.JpaRepository<Message, Long> {
    List<Message> findBySentFalse();
}

@Service
class OrderService {
    @Autowired private MessageRepository messageRepository;

    @Transactional
    public void createOrder(String orderInfo) {
        // 1. 保存订单（略）
        // 2. 保存消息
        messageRepository.save(new Message("order_created:" + orderInfo));
    }
}

@Service
class MessageSender {
    @Autowired private MessageRepository messageRepository;

    @Scheduled(fixedDelay = 5000)
    public void resendMessages() {
        List<Message> messages = messageRepository.findBySentFalse();
        for (Message msg : messages) {
            // 发送到MQ（这里用打印模拟）
            System.out.println("Send message: " + msg.getContent());
            msg.setSent(true);
            messageRepository.save(msg);
        }
    }
} 