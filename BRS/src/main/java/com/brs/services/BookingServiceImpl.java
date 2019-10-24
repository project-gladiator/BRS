package com.brs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brs.bean.Booking;
import com.brs.dao.BookingDao;
import com.brs.exception.BRSException;

@Service("bookingService")
@Scope("singleton")
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDao dao;

public Booking viewBooking(int ticketNo) throws BRSException {
	return dao.viewBooking(ticketNo);
}


	public Booking doBooking(Booking booking) throws BRSException {
		return dao.doBooking(booking);
	}
}
