package com.example.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TccDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TccDemoApplication.class, args);

        InventoryTccService inventory = new InventoryTccServiceImpl();
        // Try
        if (inventory.tryReserve(1L, 2)) {
            // Confirm
            inventory.confirm(1L, 2);
        } else {
            // Cancel
            inventory.cancel(1L, 2);
        }
    }
}

interface InventoryTccService {
    boolean tryReserve(Long productId, int count);
    boolean confirm(Long productId, int count);
    boolean cancel(Long productId, int count);
}

class InventoryTccServiceImpl implements InventoryTccService {
    public boolean tryReserve(Long productId, int count) {
        System.out.println("Try reserve product " + productId + " count " + count);
        return true;
    }
    public boolean confirm(Long productId, int count) {
        System.out.println("Confirm reserve product " + productId + " count " + count);
        return true;
    }
    public boolean cancel(Long productId, int count) {
        System.out.println("Cancel reserve product " + productId + " count " + count);
        return true;
    }
} 