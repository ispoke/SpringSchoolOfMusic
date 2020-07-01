package com.francine.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		// set up connection variables
    	String user = "musicadmin";
    	String pass = "musicadmin";
    	

    	String jdbcUrl = "jdbc:mysql://localhost:3306/music_school_admin?useSSL=false";
    	
    	// load jdbc driver class from mySQl
    	String driver = "com.mysql.jdbc.Driver";
    	
    	// get a connection to the database
    	try {
    		//java.io.PrintWriter
			PrintWriter out = response.getWriter(); //prints to browser and not console
			out.println("Connecting to database "+ jdbcUrl);
			
			// This code loads the JDBC Driver for connecting to the database
			// Hibernate does this behind the scenes based on the Hibernate config file
			Class.forName(driver);
			
			// java.sql.Connection
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("\nSuccess!!");
			conn.close();
			
    	}catch (Exception ex) {
    		ex.printStackTrace();
    		throw new ServletException(ex);
    	}
    	
	}

}
