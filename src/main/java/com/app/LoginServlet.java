package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
	//JDBC Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "satwika123");
			Statement st = conn.createStatement();
			String query = "select * from user where userid = '"+userId+"' and password = '"+password+"'";
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				out.print("<h1>"+userId+":Welcome to Home page</h1><br>");
				out.print("<h1>Login Successfully!</h1><br>");
		
				
			}else {
				//The userId and password is not available in DB
				out.print("<h1>"+userId+":please enter correct userId and Password</h1><br>");
				out.print("<h1>Login Successfully!</h1><br>");
		
				
			}
			rs.close();
			st.close();
			conn.close();
	} catch (ClassNotFoundException e) {
		out.print("<h1>Login Sucessfully!</h1><br>");
		e.printStackTrace();
	} catch (SQLException e) {
		out.print("<h1>Login Successfully!</h1><br>");
		e.printStackTrace();
		
	}
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}