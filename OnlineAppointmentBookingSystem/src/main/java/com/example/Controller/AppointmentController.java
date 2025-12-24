package com.example.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.AppointmentService;
import com.example.entity.AppointmentEntity;
import com.example.oopsdesgin.Appointment;
import com.example.oopsdesgin.AppointmentMode;

@RestController
public class AppointmentController {

	private AppointmentService service;

    //constructor injection
    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

   
    
    @GetMapping("/slots")
    public List<String> getSlots() {
        return service.getAvailableSlots();
}
   // @GetMapping("/book/{type}/{name}/{appointmentMode}")
    
    @PostMapping(value="/book/{type}/{name}/{appointmentMode}",produces = "text/plain")
    public String book(@PathVariable String type, @PathVariable String name,@PathVariable AppointmentMode appointmentMode) {
        return service.bookAppointment(type, name,appointmentMode);
    }

    @GetMapping("/appointments")
    public List<AppointmentEntity> getAll() {
        return service.getAllAppointments();
     
    }
}
