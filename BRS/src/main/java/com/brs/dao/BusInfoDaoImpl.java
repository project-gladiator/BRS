package com.brs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.brs.bean.BusInfo;

@Repository
@Scope("singleton") // By default spring objects are singleton.
//@Transactional(propagation=Propagation.REQUIRED)
public class BusInfoDaoImpl implements BusInfoDao {
//
//	@PersistenceContext
//	private EntityManager manager;
//	@Override
//	public List<Bus_Info_Bean> getBusDetails() {
//		Query qry = manager.createNamedQuery("searchBus");
//		return qry.getResultList();
//	}
//	
//	

	@PersistenceContext
	private EntityManager manager;



	public List<BusInfo> getBusDetails() {
		// TODO Auto-generated method stub
		return null;
	}


	public BusInfo bookBus(int id) {
		BusInfo busById = manager.find(BusInfo.class, id);
		return busById;
	}


	public boolean isvalidUser(String username, String password) {
		// TODO Auto-generated method stub
		return username.equalsIgnoreCase("admin") && password.equals("admin");
	}


	public List<BusInfo> busFetch(BusInfo busInfo) {
		// TODO Auto-generated method stub
		String src = busInfo.getSource();
		String dest = busInfo.getDestination();
		Query qry = manager.createQuery("FROM BusInfo WHERE SOURCE=:src AND DESTINATION=:dest");
		qry.setParameter("src", src);
		qry.setParameter("dest", dest);
		return qry.getResultList();
	}

}
