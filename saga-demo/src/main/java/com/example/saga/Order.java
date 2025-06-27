package com.example.saga;

import javax.persistence.*;

@Entity
public class Order {
    @Id @GeneratedValue
    private Long id;
    private String name;
    public Order() {}
    public Order(String name) { this.name = name; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
} 