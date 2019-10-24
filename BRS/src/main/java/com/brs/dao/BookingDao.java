package com.brs.dao;

import com.brs.bean.Booking;
import com.brs.exception.BRSException;

public interface BookingDao {
	public Booking doBooking(Booking booking) throws BRSException;
	public Booking viewBooking(int ticketNo) throws BRSException;
}
