package com.example.tcc;

import javax.persistence.*;

@Entity
public class Inventory {
    @Id @GeneratedValue
    private Long id;
    private String productName;
    private int stock;
    public Inventory() {}
    public Inventory(String productName, int stock) {
        this.productName = productName;
        this.stock = stock;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
} 