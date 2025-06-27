package com.example.strongdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@SpringBootApplication
public class StrongdbDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(StrongdbDemoApplication.class, args);
    }
}

@Entity
class Account {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Double balance;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
}

interface AccountRepository extends org.springframework.data.jpa.repository.JpaRepository<Account, Long> {}

@Service
class AccountService {
    @Autowired private AccountRepository accountRepository;

    @Transactional
    public void transfer(Long fromId, Long toId, Double amount) {
        Account from = accountRepository.findById(fromId).orElseThrow();
        Account to = accountRepository.findById(toId).orElseThrow();
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        accountRepository.save(from);
        accountRepository.save(to);
    }
} 