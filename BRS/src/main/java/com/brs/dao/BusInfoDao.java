package com.brs.dao;

import java.util.List;

import com.brs.bean.Bus_Info_Bean;

public interface BusInfoDao {
	public List<Bus_Info_Bean> getBusDetails();

	public List<Bus_Info_Bean> busFetch(String source, String dest);
}
