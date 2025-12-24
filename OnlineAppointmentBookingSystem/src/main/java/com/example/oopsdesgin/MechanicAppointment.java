package com.example.oopsdesgin;

import java.util.List;

public class MechanicAppointment extends Appointment{

	
	
	public MechanicAppointment(String customerName, String slotTime,AppointmentMode appointmentMode) {
		super(customerName, slotTime,appointmentMode);
		
	}

	@Override
	public String getType() {
		
		return "MECHANIC";
	}

	@Override
	public List<String> getFeatures() {
		if(appointmentMode==AppointmentMode.PREMIUM)
		return List.of("Foam Wash Of Vechiles","Free Engine Oil","Priority Checkup and delivery");
	    else
		return List.of("Normal wash of Vechiles","Normal Delivery");
}
}
