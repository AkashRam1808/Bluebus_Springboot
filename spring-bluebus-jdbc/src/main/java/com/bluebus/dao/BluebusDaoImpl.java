package com.bluebus.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluebus.model.Bluebus;
import com.bluebus.util.Queries;

@Repository
public class BluebusDaoImpl implements IBluebusDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void addBus(Bluebus bus) {
		Object[] busArray = {bus.getBusNumber(),bus.getBusName(),bus.getStartDate(),bus.getCategory(),bus.getType(),bus.getCost(),bus.getSource(),bus.getDestination(),bus.getSeatsAvailable(),bus.getStartTime()};
		jdbcTemplate.update(Queries.ADDQUERY,busArray);
		
		
	}

	@Override
	public void updateBus(int busNumber, double cost) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(Queries.UPDATEQUERY,cost,busNumber);
		
	}

	@Override
	public Bluebus getByNumber(int busNumber) {

		Bluebus buses = jdbcTemplate.queryForObject(Queries.QUERYBYID, (rs,rowNum)->{
			Bluebus bus = new Bluebus();
			
			bus.setBusNumber(rs.getInt("BusNumber"));
			bus.setBusName(rs.getString("BusName"));
			bus.setStartDate(rs.getDate("StartDate").toLocalDate());
			bus.setCategory(rs.getString("category"));
			bus.setType(rs.getString("type"));
			bus.setCost(rs.getDouble("cost"));
			bus.setSource(rs.getString("Source"));
			bus.setDestination(rs.getString("Destination"));
			bus.setSeatsAvailable(rs.getInt("SeatAvailable"));
			bus.setStartTime(rs.getTimestamp("StartTime").toLocalDateTime());
			
			return bus;
		},busNumber);
		
		return buses;
	}

	@Override
	public void deleteBus(int busNumber) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(Queries.DELETEQUERY,busNumber);
		
	}

	@Override
	public List<Bluebus> findAll(String source, String destination) {

		List<Bluebus> buses = jdbcTemplate.query(Queries.QUERYBYSOURCE, (rs,rowNum)->{
			Bluebus bus = new Bluebus();
			
			bus.setBusNumber(rs.getInt("BusNumber"));
			bus.setBusName(rs.getString("BusName"));
			bus.setStartDate(rs.getDate("StartDate").toLocalDate());
			bus.setCategory(rs.getString("category"));
			bus.setType(rs.getString("type"));
			bus.setCost(rs.getDouble("cost"));
			bus.setSource(rs.getString("Source"));
			bus.setDestination(rs.getString("Destination"));
			bus.setSeatsAvailable(rs.getInt("SeatAvailable"));
			bus.setStartTime(rs.getTimestamp("StartTime").toLocalDateTime());
			
			return bus;
		},source,destination);
		return buses;
	}

	@Override
	public List<Bluebus> findByLessFare(String source, String destination, double cost) {

		Object[] busArray = {source,destination,cost};
		List<Bluebus> buses = jdbcTemplate.query(Queries.QUERYBYCOST, (rs,rowNum)->{
			Bluebus bus = new Bluebus();
			
			bus.setBusNumber(rs.getInt("BusNumber"));
			bus.setBusName(rs.getString("BusName"));
			bus.setStartDate(rs.getDate("StartDate").toLocalDate());
			bus.setCategory(rs.getString("category"));
			bus.setType(rs.getString("type"));
			bus.setCost(rs.getDouble("cost"));
			bus.setSource(rs.getString("Source"));
			bus.setDestination(rs.getString("Destination"));
			bus.setSeatsAvailable(rs.getInt("SeatAvailable"));
			bus.setStartTime(rs.getTimestamp("StartTime").toLocalDateTime());
			
			return bus;
		}, busArray);
		
				return buses;
	}

	@Override
	public List<Bluebus> findbyCategory(String source, String destination, String category) {
		Object[] busArray = {source,destination,category};
		List<Bluebus> buses = jdbcTemplate.query(Queries.QUERYBYCATEGORY, (rs,rowNum)->{
			Bluebus bus = new Bluebus();
			
			bus.setBusNumber(rs.getInt("BusNumber"));
			bus.setBusName(rs.getString("BusName"));
			bus.setStartDate(rs.getDate("StartDate").toLocalDate());
			bus.setCategory(rs.getString("category"));
			bus.setType(rs.getString("type"));
			bus.setCost(rs.getDouble("cost"));
			bus.setSource(rs.getString("Source"));
			bus.setDestination(rs.getString("Destination"));
			bus.setSeatsAvailable(rs.getInt("SeatAvailable"));
			bus.setStartTime(rs.getTimestamp("StartTime").toLocalDateTime());
			
			return bus;
		}, busArray);
		
				return buses;
	}

	@Override
	public List<Bluebus> findbyType(String source, String destination, String type) {
		Object[] busArray = {source,destination,type};
		List<Bluebus> buses = jdbcTemplate.query(Queries.QUERYBYTYPE, (rs,rowNum)->{
			Bluebus bus = new Bluebus();
			
			bus.setBusNumber(rs.getInt("BusNumber"));
			bus.setBusName(rs.getString("BusName"));
			bus.setStartDate(rs.getDate("StartDate").toLocalDate());
			bus.setCategory(rs.getString("category"));
			bus.setType(rs.getString("type"));
			bus.setCost(rs.getDouble("cost"));
			bus.setSource(rs.getString("Source"));
			bus.setDestination(rs.getString("Destination"));
			bus.setSeatsAvailable(rs.getInt("SeatAvailable"));
			bus.setStartTime(rs.getTimestamp("StartTime").toLocalDateTime());
			
			return bus;
		}, busArray);
		
				return buses;
	}

	@Override
	public List<Bluebus> findbyStartTime(String source, String destination, LocalDateTime startTime) {
		
		Timestamp starttimestamp = Timestamp.valueOf(startTime);
		Object[] busArray = {source,destination,starttimestamp};
		List<Bluebus> buses = jdbcTemplate.query(Queries.QUERYBYTYPE, (rs,rowNum)->{
			Bluebus bus = new Bluebus();
			
			bus.setBusNumber(rs.getInt("BusNumber"));
			bus.setBusName(rs.getString("BusName"));
			bus.setStartDate(rs.getDate("StartDate").toLocalDate());
			bus.setCategory(rs.getString("category"));
			bus.setType(rs.getString("type"));
			bus.setCost(rs.getDouble("cost"));
			bus.setSource(rs.getString("Source"));
			bus.setDestination(rs.getString("Destination"));
			bus.setSeatsAvailable(rs.getInt("SeatAvailable"));
			bus.setStartTime(rs.getTimestamp("StartTime").toLocalDateTime());
			
			return bus;
		}, busArray);
		
				return buses;
	}
	

}
