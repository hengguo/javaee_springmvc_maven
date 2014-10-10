package test.databinding;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.service.FlightService;

public class AspectTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/spring-config.xml");
		FlightService b = (FlightService)ac.getBean("flightService");
		System.out.println(b.getClass());
		

	}

}
