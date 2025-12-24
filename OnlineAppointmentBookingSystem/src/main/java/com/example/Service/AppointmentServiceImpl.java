package com.example.Service;


import java.util.HashSet;
//import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Factory.AppointmentFactory;
import com.example.entity.AppointmentEntity;
import com.example.oopsdesgin.Appointment;
import com.example.oopsdesgin.AppointmentMode;
import com.example.repository.AppointmentRepo;
import com.example.utility.SlotScheduler;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepo ar;
    private final AppointmentFactory factory;

    public AppointmentServiceImpl(AppointmentFactory factory, AppointmentRepo ar) {
        this.factory = factory;
        this.ar = ar;
    }

    @Override
    public String bookAppointment(String type, String customerName, AppointmentMode appointmentMode) {

        // Step 1: Load already booked slots FROM DATABASE
        Set<String> bookedSlots = new HashSet<>();
        List<AppointmentEntity> allBookings = ar.findAll();

        for (AppointmentEntity e : allBookings) {
            bookedSlots.add(e.getSlotTime());
        }

        // Step 2: Get next available slot
        String slot = SlotScheduler.getNextAvailableSlot(bookedSlots);

        // Step 3: Create Appointment (business object)
        Appointment appointment =
                factory.createAppointment(type, customerName, slot, appointmentMode);

        // Step 4: Convert to entity for DB
        AppointmentEntity entity = new AppointmentEntity();
        entity.setType(appointment.getType());
        entity.setCustomerName(appointment.getCustomerName());
        entity.setSlotTime(appointment.getSlotTime());
        entity.setAppointmentMode(appointment.getAppointmentMode());
        entity.setPrice(appointment.getModePrice());
        entity.setFeatures(appointment.getFeatures());

        ar.save(entity);

        return String.format(
                "Appointment booked at: %s\nType: %s\nMode: %s\nPrice: %.2f\nFeatures: %s",
                appointment.getSlotTime(),
                appointment.getType(),
                appointment.getAppointmentMode(),
                appointment.getModePrice(),
                appointment.getFeatures()
        );
    }

    @Override
    public List<String> getAvailableSlots() {
        return SlotScheduler.DAILY_SLOTS;
    }

    @Override
    public List<AppointmentEntity> getAllAppointments() {
        return ar.findAll();
    }
}
