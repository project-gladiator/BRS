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

import com.brs.bean.Bus_Info_Bean;

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

	@Override
	public List<Bus_Info_Bean> getBusDetails() {
//		String qry = "SELECT * FROM BUS_DETAILS";
//		List<Map<String, Object>> mapEmpList = jt.queryForList(qry,new Object[] {});
//		List<Bus_Info_Bean> contList = new ArrayList<Bus_Info_Bean>();
//		System.out.println("ASDFGASDFGH");
//		for(Map<String, Object> mapRec : mapEmpList) {
//			System.out.println("ASDFGASDFGHQQWESDFGB");
//			BigDecimal busid=(BigDecimal)mapRec.get("BUS_ID");
//			String btype = (String) mapRec.get("BUS_TYPE");
//			String src = (String) mapRec.get("SOURCE");
//			String dest= (String) mapRec.get("DESTINATION");
//			BigDecimal cap=(BigDecimal)mapRec.get("CAPACITY");
//			
//			
//			System.out.println("saadfgb");
//			//BigDecimal Phone = (BigDecimal) mapRec.get("PHONE");
//			Bus_Info_Bean cont = new Bus_Info_Bean(busid.intValue(),btype,cap.intValue(),src,dest);
//			
//			
//			//cont.setBus_info_bean(mapEmpList);
//			//System.out.println("ASDFG");
//			contList.add(cont);
//		//return null;		
//	}
		return null;
	}

	@Override
	public List<Bus_Info_Bean> busFetch(Bus_Info_Bean busInfo) {
		String src = busInfo.getSource();
		String dest = busInfo.getDestination();
		Query qry = manager.createQuery("FROM Bus_Info_Bean WHERE SOURCE=:src AND DESTINATION=:dest");
		qry.setParameter("src", src);
		qry.setParameter("dest", dest);
		return qry.getResultList();
	}

	@Override
	public Bus_Info_Bean bookBus(int id) {
		Bus_Info_Bean busById = manager.find(Bus_Info_Bean.class, id);
		return busById;
	}

	@Override
	public boolean isvalidUser(String username, String password) {
		return username.equalsIgnoreCase("admin") && password.equals("admin");
	}

}
