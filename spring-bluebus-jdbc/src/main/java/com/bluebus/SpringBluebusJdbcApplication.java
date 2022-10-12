package com.bluebus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bluebus.model.Bluebus;
import com.bluebus.service.IBluebusService;

@SpringBootApplication
public class SpringBluebusJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBluebusJdbcApplication.class, args);
	}

	IBluebusService busService;
	
	public SpringBluebusJdbcApplication(IBluebusService busService) {
		super();
		this.busService = busService;
	}

	@Override
	public void run(String... args) throws Exception {
		
	/*	LocalDate startDate = LocalDate.parse("2022-10-20");
		
		String str = "2022-10-20 12:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime startTime = LocalDateTime.parse(str, formatter);

		Bluebus bus = new Bluebus(107,"KPN Travels",startDate,"Sleeper","AC",2500,"Kochi","Mangalore",35,startTime);
		busService.addBus(bus);
	*/
		
		
	/*	busService.updateBus(102, 2000);*/
		
		
		
    /*  System.out.println(busService.getByNumber(103));*/
		
		
		
	/*	busService.deleteBus(108); */
		
		
		
	/*	List<Bluebus> buses = busService.getAll("Coimbatore", "Bangalore");
		for (Bluebus bluebus : buses) {
			System.out.println(bluebus);
		}*/
		
		
		
	/*	List<Bluebus> buses = busService.getByLessFare("Coimbatore", "Bangalore", 3000);
		for (Bluebus bluebus : buses) {
			System.out.println(bluebus);
		}*/
		
		
	/*	List<Bluebus> buses = busService.getbyCategory("Madurai", "Mysuru", "Sleeper");
		for (Bluebus bluebus : buses) {
			System.out.println(bluebus);
		}*/
		
		
	/*	List<Bluebus> buses = busService.getbyType("Coimbatore", "Bangalore", "AC");
		for (Bluebus bluebus : buses) {
			System.out.println(bluebus);
		}*/
		
		String str = "2022-10-28 09:00"; 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		LocalDateTime startTime = LocalDateTime.parse(str, formatter);

		List<Bluebus> buses = busService.getbyStartTime("Virudhunagar","Erode",startTime);
		
		for (Bluebus bluebus : buses) {
			System.out.println(bluebus);
		}
		
	}

}
