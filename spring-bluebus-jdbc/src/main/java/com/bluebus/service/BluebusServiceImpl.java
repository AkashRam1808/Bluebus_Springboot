package com.bluebus.service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bluebus.dao.BluebusDaoImpl;
import com.bluebus.dao.IBluebusDao;
import com.bluebus.exception.BusNotFoundException;

import com.bluebus.model.Bluebus;

@Service
public class BluebusServiceImpl implements IBluebusService {

	IBluebusDao bluebusdao;
	
	

	public BluebusServiceImpl(IBluebusDao bluebusdao) {
		super();
		this.bluebusdao = bluebusdao;
	}

	/**
	 * @param bus
	 * functionality - gets bus object, send the object to be added in the database to IBluebusDao layer
	 */
	@Override
	public void addBus(Bluebus bus) {
		bluebusdao.addBus(bus);
	}

	/**
	 * @param busNumber
	 * @param cost
	 * functionality - gets busNumber and cost, send busNumber and cost to IBluebusDao layer
	 */
	@Override
	public void updateBus(int busNumber, double cost) {

		bluebusdao.updateBus(busNumber, cost);

	}

	/**
	 * @param busNumber
	 * @return
	 * @throws BusNotFoundException
	 * functionality - gets busNumber, send busNumber to IBluebusDao layer
	 */
	@Override
	public Bluebus getByNumber(int busNumber) throws BusNotFoundException {

		Bluebus bus = bluebusdao.getByNumber(busNumber);
		if (bus != null) {
			return bus;
		} else {
			throw new BusNotFoundException("Bus Number not found");
		}

	}

	/**
	 * @param busNumber
	 * functionality - gets busNumber, send busNumber to IBluebusDao layer
	 */
	@Override
	public void deleteBus(int busNumber) {

		bluebusdao.deleteBus(busNumber);

	}

	/**
	 * @param source
	 * @param destination
	 * functionality - gets source and destination, send source and destination to IBluebusDao layer
	 * @return
	 */
	@Override
	public List<Bluebus> getAll(String source, String destination) {

		List<Bluebus> buses = bluebusdao.findAll(source, destination).stream()
				.sorted((bus1, bus2) -> bus1.getBusName().compareTo(bus2.getBusName())).collect(Collectors.toList());
		return buses;
	}

	/**
	 * @param source
	 * @param destination
	 * @param cost
	 * @return
	 * @throws BusNotFoundException
	 * functionality - gets source, destination and cost, send source, destination and cost to IBluebusDao layer
	 */
	@Override
	public List<Bluebus> getByLessFare(String source, String destination, double cost) throws BusNotFoundException {

		List<Bluebus> buses = bluebusdao.findByLessFare(source, destination, cost).stream()
				.sorted((bus1, bus2) -> bus1.getBusName().compareTo(bus2.getBusName())).collect(Collectors.toList());

		if (buses.isEmpty()) {

			throw new BusNotFoundException("No bus found!");
		} else {
			return buses;
		}
	}

	/**
	 * @param source
	 * @param destination
	 * @param category
	 * @return
	 * @throws BusNotFoundException
	 * functionality - gets sourc, destination and category, send source, destination and category to IBluebusDao layer
	 */
	@Override
	public List<Bluebus> getbyCategory(String source, String destination, String category) throws BusNotFoundException {

		List<Bluebus> buses = bluebusdao.findbyCategory(source, destination, category).stream()
				.sorted((bus1, bus2) -> bus1.getBusName().compareTo(bus2.getBusName())).collect(Collectors.toList());
		if (buses.isEmpty()) {
			throw new BusNotFoundException("No bus found!");
		} else {
			return buses;
		}
	}

	/**
	 * @param source
	 * @param destination
	 * @param type
	 * @return
	 * @throws BusNotFoundException
	 * functionality - gets source, destination and type, send source, destination and type to IBluebusDao layer
	 */
	@Override
	public List<Bluebus> getbyType(String source, String destination, String type) throws BusNotFoundException {

		List<Bluebus> buses = null;
		buses = bluebusdao.findbyType(source, destination, type).stream()
				.sorted((bus1, bus2) -> bus1.getBusName().compareTo(bus2.getBusName())).collect(Collectors.toList());
		if (buses.isEmpty()) {
			throw new BusNotFoundException("No bus found!");
		} else {
			return buses;
		}
	}

	/**
	 * @param source
	 * @param destination
	 * @param startTime
	 * @return
	 * @throws BusNotFoundException
	 * functionality - gets source, destination and startTime, send source, destination and startTime to IBluebusDao layer
	 */
	@Override
	public List<Bluebus> getbyStartTime(String source, String destination, LocalDateTime startTime)
			throws BusNotFoundException {

		List<Bluebus> buses = null;
		buses = bluebusdao.findbyStartTime(source, destination, startTime).stream()
				.sorted((bus1, bus2) -> bus1.getBusName().compareTo(bus2.getBusName())).collect(Collectors.toList());
		if (buses.isEmpty()) {
			throw new BusNotFoundException("No bus found!");
		} else {
			return buses;
		}
	}

}
