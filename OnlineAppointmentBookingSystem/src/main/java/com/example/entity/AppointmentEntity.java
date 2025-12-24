package com.example.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(name = "customer_name")
    private String customerName;

    private String slotTime;

    @Enumerated(EnumType.STRING)
    private com.example.oopsdesgin.AppointmentMode appointmentMode;

    private double price;

    private List<String> features;

    public Long getId() {
        return id;
    }

    // Getters and setters
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSlotTime() {
        return slotTime;
    }
    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public com.example.oopsdesgin.AppointmentMode getAppointmentMode() {
        return appointmentMode;
    }
    public void setAppointmentMode(com.example.oopsdesgin.AppointmentMode appointmentMode) {
        this.appointmentMode = appointmentMode;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getFeatures() {
        return features;
    }
    public void setFeatures(List<String> list) {
        this.features = list;
    }
}
