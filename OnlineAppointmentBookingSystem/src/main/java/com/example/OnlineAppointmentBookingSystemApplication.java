package com.example;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


@SpringBootApplication
public class OnlineAppointmentBookingSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnlineAppointmentBookingSystemApplication.class, args);
    }
}
