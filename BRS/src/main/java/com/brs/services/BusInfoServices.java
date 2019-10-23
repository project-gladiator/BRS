package com.brs.services;

import java.util.List;

import com.brs.bean.Bus_Info_Bean;

public interface BusInfoServices {
	public List<Bus_Info_Bean> getBusDetails();

	public List<Bus_Info_Bean> busFetch(String source, String dest);
}
