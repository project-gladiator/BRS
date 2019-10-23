

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.brs.bean.Bus_Info_Bean;
import com.brs.services.BusInfoServices;

public class Test_BusInfo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bus-core.xml");
		BusInfoServices busInfoServicess = context.getBean("busInfoServices", BusInfoServices.class);
		System.out.println("asdfgh");
		try {
			List<Bus_Info_Bean> busList = busInfoServicess.getBusDetails();
			for (Bus_Info_Bean bus_Info_Bean : busList) {
				System.out.println("bus_detail" + bus_Info_Bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
