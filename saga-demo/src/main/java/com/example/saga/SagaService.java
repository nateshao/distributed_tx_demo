package com.example.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SagaService {
    @Autowired CompensationTaskRepository compensationTaskRepository;

    public String bookTrip(String bizId) {
        try {
            bookHotel(bizId);
            bookFlight(bizId);
            return "All booked!";
        } catch (Exception e) {
            compensationTaskRepository.save(new CompensationTask("cancelHotel", bizId));
            return "Booking failed, compensation scheduled.";
        }
    }

    public void bookHotel(String bizId) {
        // ...业务逻辑...
    }
    public void bookFlight(String bizId) {
        // ...业务逻辑，抛异常模拟失败...
        throw new RuntimeException("Flight booking error");
    }
    public void cancelHotel(String bizId) {
        // ...补偿逻辑...
        System.out.println("Hotel booking canceled for bizId=" + bizId);
    }
} 