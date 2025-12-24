package com.example.Service;

import java.util.List;

import com.example.entity.AppointmentEntity;
import com.example.oopsdesgin.Appointment;
import com.example.oopsdesgin.AppointmentMode;

public interface AppointmentService {

         String bookAppointment(String type,String customerName,AppointmentMode appointmentMode);
        List<String> getAvailableSlots();
        List<AppointmentEntity> getAllAppointments();
         
         
}
