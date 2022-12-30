package com.springboot.project.demoproject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.project.demoproject.dto.User;


@Repository
public class UserRepository {
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://101.53.155.156:3306/mysql_demo_tnj",
				"mysql_demo_tnj", "Ebrain@20");
		return con;
	}

	public static void save(User data) throws Exception, SQLException {
		
		Connection con = getConnection();
		
		String insertQuery = "insert into tb_manimaran_springboot(movie,actor,ticket,timing) values (?,?,?,?) ";
		PreparedStatement ps = con.prepareStatement(insertQuery);

		ps.setString(1, data.getMovie());
		ps.setString(2, data.getActor());
		ps.setString(3, data.getTicket());
		ps.setString(4, data.getTiming());
		ps.executeUpdate();
		ps.close();
		con.close();
	}


	public List<User> getAllUsers() throws Exception, SQLException {
		Connection con = getConnection();

		String selectQuery = "select * from tb_manimaran_springboot";

		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);

		ResultSet resultSet = preparedStatement.executeQuery();

		List<User> userList = new ArrayList<User>();

		User user = null;

		while (resultSet.next()) {
			user = new User();
			user.setBookingId(resultSet.getInt(1));
			user.setMovie(resultSet.getString(2));
			user.setActor(resultSet.getString(3));
			user.setTicket(resultSet.getString(4));
			user.setTiming(resultSet.getString(5));
			userList.add(user);
		}

		return userList;

		
	}



	public void Update(User data) throws Exception, SQLException {
		Connection con = getConnection();
		String insertQuery = ("update tb_manimaran_springboot set movie=?, actor=?, ticket=?, timing=? where booking_id=?");
        PreparedStatement ps = con.prepareStatement(insertQuery);
     
        ps.setString(1, data.getMovie());
        ps.setString(2,data.getActor());
        ps.setString(3,data.getTicket());
        ps.setString(4, data.getTiming());
        ps.setInt(5, data.getBookingId());
        ps.executeUpdate();
        ps.close();
        con.close();

	}

	public void deletevalue(Integer bookingId) throws Exception {
		Connection con = getConnection();
		String insertQuery = "delete from tb_manimaran_springboot where booking_id = ?";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setInt(1, bookingId);
		ps.executeUpdate();
		ps.close();
		con.close();
	}


	public static User getById(Integer bookingId) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();

		String selectQuery = "select booking_id, movie, actor, ticket, timing from tb_manimaran_springboot where booking_id=?";

		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		
		preparedStatement.setInt(1,bookingId);

		ResultSet resultSet = preparedStatement.executeQuery();

		

		User user = null;

		while (resultSet.next()) {
			user = new User();	
			user.setBookingId(resultSet.getInt(1));
			user.setMovie(resultSet.getString(2));
			user.setActor(resultSet.getString(3));
		    user.setTicket(resultSet.getString(4));
		    user.setTiming(resultSet.getString(5));
		    
			
		}

		return user;
	}


		// TODO Auto-generated method stub
		
	}






