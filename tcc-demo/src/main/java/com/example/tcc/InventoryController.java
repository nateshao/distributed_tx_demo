package com.example.tcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/inventory")
@Validated
public class InventoryController {
    @Autowired InventoryTccService inventoryTccService;
    @PostMapping("/try")
    public boolean tryReserve(@RequestParam @NotNull Long id, @RequestParam @Min(1) int count) {
        return inventoryTccService.tryReserve(id, count);
    }
    @PostMapping("/confirm")
    public boolean confirm(@RequestParam @NotNull Long id, @RequestParam @Min(1) int count) {
        return inventoryTccService.confirm(id, count);
    }
    @PostMapping("/cancel")
    public boolean cancel(@RequestParam @NotNull Long id, @RequestParam @Min(1) int count) {
        return inventoryTccService.cancel(id, count);
    }
} 