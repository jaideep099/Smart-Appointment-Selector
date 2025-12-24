package com.example.Factory;

import org.springframework.stereotype.Component;

import com.example.oopsdesgin.Appointment;
import com.example.oopsdesgin.AppointmentMode;
import com.example.oopsdesgin.DoctorAppointment;
import com.example.oopsdesgin.MechanicAppointment;
import com.example.oopsdesgin.SalonAppointment;

@Component
public class AppointmentFactory {

	public  Appointment createAppointment(String type,String customerName,String slotTime, AppointmentMode appointmentMode){
		
		switch(type.toUpperCase()) {
		case "DOCTOR":
			return new DoctorAppointment(customerName,slotTime,appointmentMode);
		case "SALON":
			return new SalonAppointment(customerName, slotTime,appointmentMode);
		case "MECHANIC":
			return new MechanicAppointment(customerName, slotTime,appointmentMode);	
		default:
		throw new IllegalArgumentException("Invalid Appointment Type");
	}
}
}
