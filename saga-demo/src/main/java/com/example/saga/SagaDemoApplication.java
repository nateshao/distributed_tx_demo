package com.example.saga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SagaDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SagaDemoApplication.class, args);

        SagaDemo saga = new SagaDemo();
        saga.bookTrip();
    }
}

class SagaDemo {
    public void bookTrip() {
        try {
            bookHotel();
            bookFlight();
            System.out.println("All booked!");
        } catch (Exception e) {
            System.out.println("Booking failed, start compensation...");
            cancelHotel();
        }
    }
    void bookHotel() {
        System.out.println("Hotel booked");
    }
    void bookFlight() {
        System.out.println("Flight booking failed");
        throw new RuntimeException("Flight booking error");
    }
    void cancelHotel() {
        System.out.println("Hotel booking canceled");
    }
} 