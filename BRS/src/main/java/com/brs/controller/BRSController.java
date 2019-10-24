package com.brs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.brs.bean.BusInfo;
import com.brs.exception.BRSException;
import com.brs.services.BusInfoServices;
import com.brs.bean.BusInfo;
import com.brs.exception.BRSException;

@Controller
public class BRSController {

	@Resource
	private BusInfoServices busInfoServices;

	private BusInfo bus_info_bean = new BusInfo();

	@RequestMapping(value = "/buslist", method = RequestMethod.GET)
	public String toBusSearch() {
		return "buslist";
	}

	@RequestMapping(value = "/buslist", method = RequestMethod.POST)
	public ModelAndView showBus(ModelMap model, BusInfo busInfo) {
//		
		bus_info_bean.setSource(busInfo.getSource());
		bus_info_bean.setDestination(busInfo.getDestination());
		System.out.println("LoginController.showLoginPage GET method...");
		List<BusInfo> busList = null;
		ModelAndView mAndV = null;
		busList = busInfoServices.busFetch(bus_info_bean);
		// System.out.println(empList);
		mAndV = new ModelAndView();
		// Pass-on this data to JSP
		mAndV.setViewName("busDetails");
		mAndV.addObject("list", busList);
		return mAndV;
	}

	/*
	 * @RequestMapping("/book") public ModelAndView bookBus(@RequestParam("id") int
	 * bus_id) { ModelAndView mAndV = new ModelAndView("Book"); BusInfo bus; bus =
	 * busInfoServices.bookBus(bus_id); System.out.println(bus);
	 * 
	 * // Pass-on this data to JSP mAndV.addObject("emp",bus);
	 * 
	 * return mAndV; }
	 */

}
