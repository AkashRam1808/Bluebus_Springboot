package com.bluebus.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.bluebus.model.Bluebus;

public interface IBluebusDao {

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
	 */
	Bluebus getByNumber(int busNumber);

	/**
	 * @param busNumber
	 */
	void deleteBus(int busNumber);

	/**
	 * @param source
	 * @param destination
	 * @return
	 */
	List<Bluebus> findAll(String source, String destination);

	/**
	 * @param source
	 * @param destination
	 * @param cost
	 * @return
	 */
	List<Bluebus> findByLessFare(String source, String destination, double cost);

	/**
	 * @param source
	 * @param destination
	 * @param category
	 * @return
	 */
	List<Bluebus> findbyCategory(String source, String destination, String category);

	/**
	 * @param source
	 * @param destination
	 * @param type
	 * @return
	 */
	List<Bluebus> findbyType(String source, String destination, String type);

	/**
	 * @param source
	 * @param destination
	 * @param startTime
	 * @return
	 */
	List<Bluebus> findbyStartTime(String source, String destination, LocalDateTime startTime);

}
