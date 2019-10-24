package com.brs.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brs.bean.BusInfo;
import com.brs.dao.BusInfoDao;

@Service("busInfoServices")
//@Scope("singleton")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BusInfoServicesImpl implements BusInfoServices {

	@Resource
	private BusInfoDao busInfoDao;
	
	
	public List<BusInfo> getBusDetails() {
		// TODO Auto-generated method stub
		return busInfoDao.getBusDetails();
	}

	public List<BusInfo> busFetch(BusInfo busInfo) {
		// TODO Auto-generated method stub
		return busInfoDao.busFetch(busInfo);
	}

	public boolean isvalidUser(String username, String password) {
		// TODO Auto-generated method stub
		return busInfoDao.isvalidUser(username, password);
	}

	public BusInfo busById(int id) {
		// TODO Auto-generated method stub
		return busInfoDao.bookBus(id);
	}
	

	

	

	
	
	

}
