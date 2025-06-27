package com.example.tcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired InventoryTccService inventoryTccService;
    @PostMapping("/try")
    public boolean tryReserve(@RequestParam Long id, @RequestParam int count) {
        return inventoryTccService.tryReserve(id, count);
    }
    @PostMapping("/confirm")
    public boolean confirm(@RequestParam Long id, @RequestParam int count) {
        return inventoryTccService.confirm(id, count);
    }
    @PostMapping("/cancel")
    public boolean cancel(@RequestParam Long id, @RequestParam int count) {
        return inventoryTccService.cancel(id, count);
    }
} 