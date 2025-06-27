package com.example.saga;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompensationTaskRepository extends JpaRepository<CompensationTask, Long> {
    List<CompensationTask> findByCompletedFalseAndDeadFalse();
} 