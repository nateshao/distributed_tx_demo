package com.example.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saga")
public class SagaController {
    @Autowired SagaService sagaService;
    @PostMapping("/book")
    public String book() {
        return sagaService.bookTrip();
    }
} 