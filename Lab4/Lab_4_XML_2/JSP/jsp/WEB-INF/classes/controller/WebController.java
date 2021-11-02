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
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  {   
    PrintWriter printWriter = null;

	int curInpId = 0;
	String req;
	String view = "log";
	String log = "stud";
	String pas = "1234";
	ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
  
    try	
	{			
        printWriter = response.getWriter();
	}
	catch (Exception ex) {}
	
		 
    try
    {
		HttpSession session = request.getSession();
		
		String url = "jdbc:mysql://localhost/demo?serverTimezone=Europe/Moscow&useSSL=false";
        String username = "StudKuzmin";
        String password = "trewolfol123";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection is OK");
		
             
			 
        String app = "app";
		req = request.getRequestURI().toString();
		
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, /*ResultSet.CONCUR_READ_ONLY,*/ ResultSet.CONCUR_UPDATABLE);               						
		ResultSet rs = stmt.executeQuery("SELECT * FROM students");			


	    String l = request.getParameter("log");
	    String p = request.getParameter("pas");
	    
	    if (l == null || p == null ) {
		    view = "log";
	    }
		if (l != null && p != null ) {
			view = "log";
			session.setAttribute("s_log", l);
			session.setAttribute("s_pas", p);
		}
	    if (log.equals((String)session.getAttribute("s_log")) && pas.equals((String)session.getAttribute("s_pas"))) {
		    view = "main";
		
			if (req.equals(new URI("/" + app + "/Enter").toString())) {

				
				String cellsString = "";
				while(rs.next())
				{
					arr.add(new ArrayList<String>(Arrays.asList(rs.getString("idStudents"), rs.getString("First_Name"), rs.getString("Last_Name"))));
				}
				for (int i = 0; i < arr.size(); i++)
				{
					for(int j = 0; j < arr.get(i).size(); j++)
					{
						if (j == arr.get(i).size() - 1) cellsString = cellsString + arr.get(i).get(j);
						else cellsString = cellsString + arr.get(i).get(j) + ",";
					}
					cellsString = cellsString + ";";
				}
				response.setHeader("cellsString", cellsString);
			}

			if (request.getHeader("key") != null)
			{
				arr.clear();
				stmt.executeUpdate("TRUNCATE students");
		
				String query = "INSERT INTO students(idStudents, First_Name, Last_Name) VALUES (?,?,?)";
				PreparedStatement statement = con.prepareStatement( query );
				
				if(!request.getHeader("cellsString").equals(""))
				{
					String[] rows = request.getHeader("cellsString").split(";");
					for (int i = 0; i < rows.length; i++) 
					{
						String[] rowscols = rows[i].split(",");
					
						statement.setString( 1, rowscols[0] );
						statement.setString( 2, rowscols[1] );
						statement.setString( 3, rowscols[2] );
						statement.execute();			
					}
				}
				
				rs = stmt.executeQuery("SELECT * FROM students");
				while(rs.next())
				{
					arr.add(new ArrayList<String>(Arrays.asList(rs.getString("idStudents"), rs.getString("First_Name"), rs.getString("Last_Name"))));
				}
				
				String cellsString = "";
				for (int i = 0; i < arr.size(); i++)
				{
					for(int j = 0; j < arr.get(i).size(); j++)
					{
						if (j == arr.get(i).size() - 1) cellsString = cellsString + arr.get(i).get(j);
						else cellsString = cellsString + arr.get(i).get(j) + ",";
					}
					cellsString = cellsString + ";";
				}
				response.setHeader("cellsString", cellsString);
			}
		} 
	   
       
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