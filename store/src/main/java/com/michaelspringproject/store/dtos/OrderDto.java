package com.michaelspringproject.store.dtos;


public class OrderDto {
    private Long id;
    private String status;
    private Double totalAmount;
    private Long userId;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}

