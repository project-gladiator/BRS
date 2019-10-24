package com.brs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brs.bean.Passenger;
import com.brs.exception.BRSException;



@Repository
@Scope("singleton")	
@Transactional(propagation=Propagation.REQUIRED)

public class PassengerDaoImpl implements PassengerDao {
	
	@PersistenceContext
	private EntityManager manager;

public Integer createNextPassengerNo() {
		
		Query qry=manager.createQuery("select max(passNo) from Passenger");
		Integer no=(Integer) qry.getSingleResult();
		//System.out.println("MAX ID : "+no);
		return no+1;
	}

public Passenger addPassenger(Passenger passenger, int ticketNo) throws BRSException {
	// TODO Auto-generated method stub
			Integer no = createNextPassengerNo();
			passenger.setPassNo(no);

			// Query qry1=manager.createQuery("select ticketNo from Booking where ");
			// int ticketNo=(Integer)qry1.

			passenger.setTicketNo(ticketNo);
			manager.persist(passenger);

			return passenger;
}



}
