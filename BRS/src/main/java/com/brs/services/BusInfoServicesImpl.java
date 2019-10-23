package com.brs.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brs.bean.Bus_Info_Bean;
import com.brs.dao.BusInfoDao;

@Service("busInfoServices")
//@Scope("singleton")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BusInfoServicesImpl implements BusInfoServices {

	@Resource
	private BusInfoDao busInfoDao;

	@Override
	public List<Bus_Info_Bean> getBusDetails() {
		return busInfoDao.getBusDetails();
	}

	@Override
	public List<Bus_Info_Bean> busFetch(Bus_Info_Bean busInfo) {

		return busInfoDao.busFetch(busInfo);
	}

	@Override
	public boolean isvalidUser(String username, String password) {
		return busInfoDao.isvalidUser(username, password);
	}
	
	@Override
	public Bus_Info_Bean bookBus(int id) {
		return busInfoDao.bookBus(id);
	}

}
