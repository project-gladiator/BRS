package com.brs.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brs.bean.Customer;
import com.brs.bean.Login;
import com.brs.exception.BRSException;

@Repository
@Scope("singleton")
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager manager;

	public Customer registerCustomer(Customer c) throws BRSException {
		manager.persist(c);
		return c;
	}

	public Customer refundInWallet(String email, double refundAmt) throws BRSException {
		Customer customer = manager.find(Customer.class, email);

		double walletBal = customer.getWallet() + refundAmt;
		customer.setWallet(walletBal);
		/*
		 * String qry0="update Customer set wallet=:walletBal"; Query
		 * qry=manager.createQuery(qry0);
		 */

		// manager.persist(customer);

		return customer;
	}

	public boolean validateCustomer(Login login) throws BRSException {
		// Query validate=manager.createQuery("from Customer where email= '
		// "+login.getEmail() +" 'and password=' "+login.getPassword()+ " ' ");

		String email = login.getEmail();
		String password = login.getPassword();

		Query validate1 = manager.createQuery("from Customer where email=:email and password=:password");

		validate1.setParameter("email", email);
		validate1.setParameter("password", password);

		Customer c = (Customer) validate1.getSingleResult();
		if (c != null) {
			return true;
		} else {
			return false;
		}
	}

}
