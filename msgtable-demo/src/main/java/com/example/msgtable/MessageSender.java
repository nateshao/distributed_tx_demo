package com.example.msgtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageSender {
    @Autowired private MessageRepository messageRepository;

    @Scheduled(fixedDelay = 5000)
    public void resendMessages() {
        List<Message> messages = messageRepository.findBySentFalseAndDeadFalse();
        for (Message msg : messages) {
            try {
                // 发送到MQ（这里用打印模拟）
                System.out.println("Send message: " + msg.getContent());
                msg.setSent(true);
                messageRepository.save(msg);
            } catch (Exception e) {
                msg.setRetryCount(msg.getRetryCount() + 1);
                if (msg.getRetryCount() > 5) msg.setDead(true); // 死信
                messageRepository.save(msg);
            }
        }
    }
} 