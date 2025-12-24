package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AppointmentEntity;
import com.example.oopsdesgin.Appointment;

public interface AppointmentRepo extends JpaRepository<AppointmentEntity,Long> {

}
