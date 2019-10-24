package com.brs.dao;

import com.brs.bean.Customer;
import com.brs.bean.Login;
import com.brs.exception.BRSException;

public interface CustomerDao {
	
	public Customer registerCustomer(Customer c) throws BRSException;
	public boolean validateCustomer(Login login ) throws BRSException;
	public Customer refundInWallet(String email, double refundAmt) throws BRSException;
	

}
