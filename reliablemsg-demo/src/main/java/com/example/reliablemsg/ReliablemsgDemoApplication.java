package com.example.reliablemsg;

import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReliablemsgDemoApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ReliablemsgDemoApplication.class, args);

        TransactionMQProducer producer = new TransactionMQProducer("group");
        producer.setNamesrvAddr("localhost:9876");
        producer.setTransactionListener(new TransactionListener() {
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                System.out.println("Execute local transaction for: " + new String(msg.getBody()));
                return LocalTransactionState.COMMIT_MESSAGE;
            }
            public LocalTransactionState checkLocalTransaction(Message msg) {
                System.out.println("Check local transaction for: " + new String(msg.getBody()));
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        producer.start();
        Message msg = new Message("topic", "tag", "key", "Hello RocketMQ".getBytes());
        producer.sendMessageInTransaction(msg, null);
        System.out.println("Transaction message sent.");
        // producer.shutdown(); // 生产环境请优雅关闭
    }
} 