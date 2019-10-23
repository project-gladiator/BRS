package com.brs.dao;

import java.util.List;

import com.brs.bean.Bus_Info_Bean;

public interface BusInfoDao {
	public List<Bus_Info_Bean> getBusDetails();

	public List<Bus_Info_Bean> busFetch(Bus_Info_Bean busInfo);
	public boolean isvalidUser(String username, String password);
	public Bus_Info_Bean bookBus(int id);
	
}
