package com.brs.services;

import com.brs.bean.Passenger;
import com.brs.exception.BRSException;

public interface PassengerService {
	
	public Passenger addPassenger(Passenger passenger, int ticketNo) throws BRSException;
	//public boolean removePassenger(int ticketNo) throws BusException;


}
