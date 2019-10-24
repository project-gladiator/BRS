package com.brs.services;

import com.brs.bean.Booking;
import com.brs.exception.*;
public interface BookingService {
	public Booking doBooking(Booking booking) throws BRSException;
	public Booking viewBooking(int ticketNo) throws BRSException;
}
