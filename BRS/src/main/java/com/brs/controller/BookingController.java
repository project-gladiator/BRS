package com.brs.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.brs.bean.Booking;
import com.brs.bean.BusInfo;
import com.brs.bean.Customer;
import com.brs.bean.Passenger;
import com.brs.exception.BRSException;
import com.brs.services.BookingService;
import com.brs.services.BusInfoServices;
import com.brs.services.PassengerService;

@Controller
public class BookingController {
	
	private int ticketNo=0;
	
	@Autowired
	private BusInfoServices busInfoServices;  
	@Autowired
	private BookingService service;
	
	@Autowired
	private PassengerService service1;
	
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response,@RequestParam("id") int bus_id) {
	    ModelAndView mav = new ModelAndView("Booking");
	    mav.addObject("id", bus_id);
	    BusInfo busInfo=busInfoServices.busById(bus_id);
	    mav.addObject("busInfo", busInfo);
	    mav.addObject("book", new Customer());
	    return mav;
	  }
	
	
	
	@RequestMapping(value = "/bookingProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("book") Booking booking) {
	 // userService.register(customer);
		 try 
		 {
			service.doBooking(booking);
			System.out.println("in add user booking"+booking.getBusno());
			ticketNo=booking.getTicketNo();
			System.out.println(ticketNo);
			int x=Integer.parseInt(request.getParameter("noOfPassengers"));
			
			for(int i=0;i<x;i++) 
			{
			Passenger passenger=new Passenger();
			passenger.setPassName(request.getParameter("passName"+i));
			passenger.setAge(Integer.parseInt(request.getParameter("age"+i)));
			char gender[]=request.getParameter("gender"+i).toCharArray();
			passenger.setGender(gender[0]);
			
			passenger.setBusno(booking.getBusno());
			passenger.setEmail(booking.getEmail());
			//to be selected from seat map
			passenger.setSeatNo(20);
			
			service1.addPassenger(passenger, ticketNo);
			}
		} 
		 catch (BRSException e) {
			
			e.printStackTrace();
		}
	  return new ModelAndView("success");
	  }
	
	
	
	
	
	
	
	
	/*
	 * @RequestMapping(value = "/bookticket",method = RequestMethod.POST) public
	 * String bookTicket(BookSeat bookSeat,@RequestParam("id") int busId) { BookSeat
	 * seat=bookSeatServices.bookSeat(bookSeat,busId);
	 * 
	 * return null; }
	 */
}

