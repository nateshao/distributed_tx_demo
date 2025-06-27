package com.example.saga;

import org.springframework.stereotype.Service;

@Service
public class SagaService {
    public String bookTrip() {
        try {
            // bookHotel();
            // bookFlight();
            return "All booked!";
        } catch (Exception e) {
            // cancelHotel();
            return "Booking failed, compensation done.";
        }
    }
} 