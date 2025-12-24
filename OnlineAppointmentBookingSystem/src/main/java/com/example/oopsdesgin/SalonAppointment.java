package com.example.oopsdesgin;

import java.util.List;

public class SalonAppointment  extends Appointment{

	public SalonAppointment(String customerName, String slotTime, AppointmentMode appointmentMode) {
		super(customerName, slotTime,appointmentMode);
		
	}

	@Override
	public String getType() {
		
		return "SALON";
	}

	@Override
	public List<String> getFeatures() {
		if(appointmentMode==AppointmentMode.PREMIUM)
		return List.of("Free Hair wash and Scrub","Free 10 min massage","Priority Service");
		else
			return List.of("Normal Queue","Only Choosen service","Free Hair Wash");
	}

}
