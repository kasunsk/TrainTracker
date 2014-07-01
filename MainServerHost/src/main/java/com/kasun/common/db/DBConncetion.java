package com.kasun.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.kasun.common.calculation.Calculations;
import com.kasun.common.data.GPSLocation;
import com.kasun.common.data.Train;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConncetion {
	
	private static final Logger log = LoggerFactory.getLogger(DBConncetion.class);

	public static Connection conn;
	public static Statement stmnt;

	public static void createConnecction() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/TrainTracker", "root", "root");
			log.info("Create connection");
		} catch (SQLException ex) {
			log.error("SQLError " + ex);
		}
	}

	public static void closeConnection() throws SQLException {
		conn.close();
		conn = null;
	}

	public static void addTrain(Train train) throws ClassNotFoundException {

//		String QUERY = "INSERT INTO " + train.getId() + " VALUES(" + num
//				+ ",'" + train.getGpslocation().getLan() + "','"
//				+ train.getGpslocation().getLat() + "','"+train.getLocation()+"'," + train.getSpeed()
//				+ ");";
		
		String QUERY = "UPDATE "+train.getId()+" SET Lon = '"+
		train.getGpslocation().getLan()+"', Lat = '"+train.getGpslocation().getLat()+
		"',Location  = '"+train.getLocation()+"',Speed  = '"+
		train.getSpeed()+"' WHERE Num = 1;";
		
		log.info("QUERY: "+QUERY);
		try {
			createConnecction();
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(QUERY);
			log.info("Added data succesfully");
			closeConnection();
			log.info("Added details to the data base");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Error in adding data to the database");
		}
	}

	public static Train getTrain(String id) {

		String QUERY = "SELECT * FROM " + id + " WHERE Num = 1;";
		Train train = null;

		try {
			createConnecction();
			Connection connection = conn;
			java.sql.Statement stm = (java.sql.Statement) connection
					.createStatement();
			ResultSet res = stm.executeQuery(QUERY);
			if (res.next()) {
				GPSLocation gpslocation = new GPSLocation(res.getString("Lon"),
						res.getString("Lat"));
				train = new Train(id, "Udarata Manike", gpslocation,
						res.getString("Location"), res.getInt("Speed"));
			}
			closeConnection();
		} catch (Exception ex) {
			// throw new RunTimeException("swf");
			System.out.println("Exception in SQL " + ex);
			return null;
		}
		log.info("Train Returned from Database");
		log.info("Previas Location: "+train.getLocation());
		return train;
	}

	// public static void main(String [] args){
	// Train train = getTrain("abc");
	// System.out.println("Location: "+train.getLocation()+" Speed: "+train.getSpeed());
	// }
}
