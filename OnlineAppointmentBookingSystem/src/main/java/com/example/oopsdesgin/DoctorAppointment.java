package com.example.oopsdesgin;

import java.util.List;

public class DoctorAppointment extends Appointment {

	public DoctorAppointment(String customerName,String slotTime,AppointmentMode appointmentMode){
		super(customerName,slotTime,appointmentMode);
		
	}
	
	@Override
	public String getType() {
		
		return "Doctor";
	}

	@Override
	public List<String> getFeatures() {
		if(appointmentMode==AppointmentMode.PREMIUM)
		return List.of("Priority checkup", "Faster service", "Extra 20 minutes Discussion with Doctor");
		else
			return List.of("Normal QUEUE","No extendedtime with Doctor");
	}

}
