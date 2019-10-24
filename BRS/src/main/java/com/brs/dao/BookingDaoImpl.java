package com.brs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brs.bean.Booking;
import com.brs.bean.Customer;
import com.brs.exception.BRSException;

@Repository
@Scope("singleton")
@Transactional(propagation=Propagation.REQUIRED)
public class BookingDaoImpl implements BookingDao {

	@PersistenceContext
	private EntityManager manager;

	private Customer customer = new Customer();

	/*
	 * @Autowired private PassengerDao pdao;
	 * 
	 * @Autowired private CustomerDao cdao;
	 */


	public Integer createNextTicketNo() {

		Query qry = manager.createQuery("select max(ticketNo) from Booking");
		Integer no = (Integer) qry.getSingleResult();
		// System.out.println("MAX ID : "+no);
		return no + 1;
	}


	public Booking doBooking(Booking booking) throws BRSException {

		Integer no = createNextTicketNo();
		booking.setTicketNo(no);
		manager.persist(booking);
		customer = manager.find(Customer.class, booking.getEmail());
		double bal = customer.getWallet() - booking.getCost();
		customer.setWallet(bal);
		manager.persist(customer);
		return booking;
	}


	public Booking viewBooking(int ticketNo) throws BRSException {
		Booking booking = manager.find(Booking.class, ticketNo);

		// System.out.println(booking);
		return booking;
	}

}
