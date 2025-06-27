package com.example.tcc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IdempotentRecordRepository extends JpaRepository<IdempotentRecord, String> {} 