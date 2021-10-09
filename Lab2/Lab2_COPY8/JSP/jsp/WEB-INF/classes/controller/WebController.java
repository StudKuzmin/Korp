package controller;

import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.*;
import java.net.*;
import java.sql.*;



public class WebController extends HttpServlet
{
  PrintWriter printWriter = null;
	String uri;
	String req;
	ArrayList<String> arr = new ArrayList<String>();
	
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  {    
    
	
    try	
	{			
        printWriter = response.getWriter();
	}
	catch (Exception ex) {}
	
		 
    try
    {
		String url = "jdbc:mysql://localhost/demo?serverTimezone=Europe/Moscow&useSSL=false";
        String username = "StudKuzmin";
        String password = "trewolfol123";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection is OK");
		
             
			 
        
		req = request.getRequestURI().toString();
		uri = new URI("/j93/add").toString();
		
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);               						
		ResultSet rs = stmt.executeQuery("SELECT * FROM students");								
            
		
		
		if (req.equals(new URI("/j93/Enter").toString())) {
			while(rs.next())
			{
				arr.add(rs.getString("idStudents") + "\t" + rs.getString("First_Name") + "\t" + rs.getString("Last_Name"));
			}
		}

		if (req.equals(uri))
		{
			rs.last();
			int id = rs.getInt("idStudents") + 1;
			
			String c1 = request.getParameter("text1");
			String c2 = request.getParameter("text2");
			
			String query = "INSERT INTO students(idStudents, First_Name, Last_Name) VALUES (?,?,?)";
			PreparedStatement statement = con.prepareStatement( query );
			statement.setInt( 1, id );
			statement.setString( 2, c1 );
			statement.setString( 3, c2 );
			statement.execute();

			rs = stmt.executeQuery("SELECT * FROM students");	
			rs.last();
			arr.add(rs.getInt("idStudents") + "\t" + rs.getString("First_Name") + "\t" + rs.getString("Last_Name"));
		}
		else
		{
			req = "ELSE";
		}

        System.out.println(req);

		
	   HttpSession session = request.getSession(true);	   
	   
	   session.setAttribute("arr", arr);
	   session.setAttribute("ur", req);   	   
	   request.setAttribute("arr", arr); 
	   request.setAttribute("ur", req); 
       
	   String view = "main";
	   request.getRequestDispatcher("/WEB-INF/views/"+view+".jsp").forward(request,response);  
	   rs.close();
       stmt.close();
	  
    }    
    catch (Exception ex)
    {       
       printWriter.println("Error: "+ex.getMessage());     
    }
  }
}