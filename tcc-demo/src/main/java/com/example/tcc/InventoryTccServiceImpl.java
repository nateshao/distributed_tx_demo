package com.example.tcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class InventoryTccServiceImpl implements InventoryTccService {
    private static final Logger log = LoggerFactory.getLogger(InventoryTccServiceImpl.class);
    @Autowired InventoryRepository repo;
    @Override
    public boolean tryReserve(Long productId, int count) {
        try {
            Inventory inv = repo.findById(productId).orElse(null);
            if (inv != null && inv.getStock() >= count) {
                inv.setStock(inv.getStock() - count);
                repo.save(inv);
                log.info("Try reserve success: productId={}, count={}", productId, count);
                return true;
            }
            log.warn("Try reserve failed: productId={}, count={}", productId, count);
            return false;
        } catch (Exception e) {
            log.error("Try reserve exception", e);
            throw e;
        }
    }
    @Override
    public boolean confirm(Long productId, int count) {
        log.info("Confirm reserve: productId={}, count={}", productId, count);
        return true;
    }
    @Override
    public boolean cancel(Long productId, int count) {
        try {
            Inventory inv = repo.findById(productId).orElse(null);
            if (inv != null) {
                inv.setStock(inv.getStock() + count);
                repo.save(inv);
                log.info("Cancel reserve: productId={}, count={}", productId, count);
            }
            return true;
        } catch (Exception e) {
            log.error("Cancel reserve exception", e);
        Inventory inv = repo.findById(productId).orElse(null);
        if (inv != null) {
            inv.setStock(inv.getStock() + count);
            repo.save(inv);
        }
        return true;
    }
} 