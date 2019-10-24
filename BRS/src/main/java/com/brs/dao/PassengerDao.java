package com.brs.dao;

import com.brs.bean.Passenger;
import com.brs.exception.BRSException;

public interface PassengerDao {
	
	public Passenger addPassenger(Passenger passenger, int ticketNo) throws BRSException;


}
