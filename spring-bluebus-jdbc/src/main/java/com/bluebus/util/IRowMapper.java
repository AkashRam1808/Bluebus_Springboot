package com.bluebus.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bluebus.model.Bluebus;


public interface IRowMapper {

	/**
	 * @param resultset
	 * @return
	 * @throws SQLException
	 */
	List<Bluebus> rowMap(ResultSet resultset) throws SQLException; 
}
