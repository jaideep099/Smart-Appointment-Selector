package com.example.oopsdesgin;

import java.util.List;




public abstract class Appointment {

	private String customerName;
	private String slotTime;
	protected AppointmentMode appointmentMode;
	private Double price;
	
	Appointment(String customerName,String slotTime,AppointmentMode appointmentMode){
		this.customerName=customerName;
		this.slotTime=slotTime;
		this.appointmentMode = appointmentMode;
		this.price=getModePrice();
	};
	
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
	public AppointmentMode getAppointmentMode() {
		return appointmentMode;
	}
	
	
	public double getModePrice() {
		if(appointmentMode==AppointmentMode.PREMIUM) {
			return 600;
		}else
			return 300;
	}
	

	public abstract String getType();
	
	public abstract List<String> getFeatures();

	
}
