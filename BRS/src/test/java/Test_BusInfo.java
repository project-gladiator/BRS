

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.brs.bean.BusInfo;
import com.brs.services.BusInfoServices;

public class Test_BusInfo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bus-core.xml");
		BusInfoServices busInfoServicess = context.getBean("busInfoServices", BusInfoServices.class);
		System.out.println("asdfgh");
		try {
			List<BusInfo> busList = busInfoServicess.getBusDetails();
			for (BusInfo bus_Info_Bean : busList) {
				System.out.println("bus_detail" + bus_Info_Bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
