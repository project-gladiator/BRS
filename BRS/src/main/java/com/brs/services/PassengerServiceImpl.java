package com.brs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brs.bean.Passenger;
import com.brs.dao.PassengerDao;
import com.brs.exception.BRSException;


@Service("passengerService")
@Scope("singleton")
@Transactional(propagation=Propagation.REQUIRES_NEW)

public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	PassengerDao dao;

	public Passenger addPassenger(Passenger passenger, int ticketNo) throws BRSException {
		// TODO Auto-generated method stub
		return dao.addPassenger(passenger, ticketNo);
	}
	



}
