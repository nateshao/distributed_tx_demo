package com.example.tcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryTccServiceImpl implements InventoryTccService {
    @Autowired InventoryRepository repo;
    @Override
    public boolean tryReserve(Long productId, int count) {
        Inventory inv = repo.findById(productId).orElse(null);
        if (inv != null && inv.getStock() >= count) {
            inv.setStock(inv.getStock() - count);
            repo.save(inv);
            return true;
        }
        return false;
    }
    @Override
    public boolean confirm(Long productId, int count) {
        // 实际业务可做幂等处理
        return true;
    }
    @Override
    public boolean cancel(Long productId, int count) {
        Inventory inv = repo.findById(productId).orElse(null);
        if (inv != null) {
            inv.setStock(inv.getStock() + count);
            repo.save(inv);
        }
        return true;
    }
} 