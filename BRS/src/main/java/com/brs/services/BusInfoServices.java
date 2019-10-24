package com.brs.services;

import java.util.List;

import com.brs.bean.BusInfo;

public interface BusInfoServices {
	public List<BusInfo> getBusDetails();

	public List<BusInfo> busFetch(BusInfo busInfo);
	public boolean isvalidUser(String username, String password);
	public BusInfo busById(int id);
	
}
