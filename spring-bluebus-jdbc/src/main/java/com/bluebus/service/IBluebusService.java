package com.bluebus.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bluebus.exception.BusNotFoundException;

import com.bluebus.model.Bluebus;

public interface IBluebusService {

	/**
	 * @param bus
	 */
	void addBus(Bluebus bus);

	/**
	 * @param busNumber
	 * @param cost
	 */
	void updateBus(int busNumber, double cost);

	/**
	 * @param busNumber
	 * @return
	 * @throws BusNotFoundException
	 */
	Bluebus getByNumber(int busNumber) throws BusNotFoundException;

	/**
	 * @param busNumber
	 */
	void deleteBus(int busNumber);

	/**
	 * @param source
	 * @param destination
	 * @return
	 */
	List<Bluebus> getAll(String source, String destination);

	/**
	 * @param source
	 * @param destination
	 * @param cost
	 * @return
	 * @throws BusNotFoundException
	 */
	List<Bluebus> getByLessFare(String source, String destination, double cost) throws BusNotFoundException;

	/**
	 * @param source
	 * @param destination
	 * @param category
	 * @return
	 * @throws BusNotFoundException
	 */
	List<Bluebus> getbyCategory(String source, String destination, String category) throws BusNotFoundException;

	/**
	 * @param source
	 * @param destination
	 * @param type
	 * @return
	 * @throws BusNotFoundException
	 */
	List<Bluebus> getbyType(String source, String destination, String type) throws BusNotFoundException;

	/**
	 * @param source
	 * @param destination
	 * @param startTime
	 * @return
	 * @throws BusNotFoundException
	 */
	List<Bluebus> getbyStartTime(String source, String destination, LocalDateTime startTime)
			throws BusNotFoundException;

}
