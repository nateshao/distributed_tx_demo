package com.example.saga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompensationTaskProcessor {
    @Autowired CompensationTaskRepository compensationTaskRepository;
    @Autowired SagaService sagaService;

    @Scheduled(fixedDelay = 10000)
    public void processCompensations() {
        List<CompensationTask> tasks = compensationTaskRepository.findByCompletedFalseAndDeadFalse();
        for (CompensationTask task : tasks) {
            try {
                if ("cancelHotel".equals(task.getType())) {
                    sagaService.cancelHotel(task.getBizId());
                }
                task.setCompleted(true);
                compensationTaskRepository.save(task);
            } catch (Exception e) {
                task.setRetryCount(task.getRetryCount() + 1);
                if (task.getRetryCount() > 5) task.setDead(true); // 死信
                compensationTaskRepository.save(task);
            }
        }
    }
} 