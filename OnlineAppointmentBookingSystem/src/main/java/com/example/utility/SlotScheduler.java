package com.example.utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class SlotScheduler {

	private static final List<DayOfWeek> VALID_DAYS = List.of(
            DayOfWeek.MONDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.SATURDAY
    );

   
    public static final List<String> DAILY_SLOTS = List.of(
            "10:00 AM", "11:00 AM", "12:00 PM" ,"1.00 PM","3.00 PM","4.00 PM"
    );

    public static String getNextAvailableSlot(Set<String> bookedSlots) {
        LocalDate date = LocalDate.now();

        while (true) {

            if (VALID_DAYS.contains(date.getDayOfWeek())) {

                for (String slot : DAILY_SLOTS) {
                    String fullSlot = date.toString() + " " + slot;

                    if (!bookedSlots.contains(fullSlot)) {
                        return fullSlot;
                    }
                }
            }

            date = date.plusDays(1); 
        }
    }
	
}

