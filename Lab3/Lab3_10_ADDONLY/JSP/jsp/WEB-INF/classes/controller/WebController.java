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

  int curInpId = 0;
  String req;
  String view = "log";
  String log = "stud";
  String pas = "1234";
  ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
	
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  {    
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
		
             
			 
        String app = "jsp";
		req = request.getRequestURI().toString();
		// add = new URI("/" + app + "/add").toString();
		// del = new URI("/" + app + "/del").toString();
		
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
	    
			// else {	   
				// String view = "notfound";
				// request.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp").forward(request,response);
			// }
            
		    //Object objCurInpId = session.getAttribute("s_curInpId");
			// if (objCurInpId != null)
			// {
				// curInpId = (int)objCurInpId;
			// }			
			if (req.equals(new URI("/" + app + "/Enter").toString())) {
				//request.setAttribute("curInpId", curInpId);
				
				while(rs.next())
				{
					arr.add(new ArrayList<String>(Arrays.asList(rs.getString("idStudents"), rs.getString("First_Name"), rs.getString("Last_Name"))));
				}
			}
			//curInpId = curInpId + 3;
			//session.setAttribute("s_curInpId", curInpId);
			
			
			if (req.equals(new URI("/" + app + "/save").toString())) {
				int numberOfIdCells = Integer.parseInt(request.getParameter("counterInpID"));
				
				String query = "INSERT INTO students(idStudents, First_Name, Last_Name) VALUES (?,?,?)";
				PreparedStatement statement = con.prepareStatement( query );
				for (int i = 0; i <= numberOfIdCells-2; i+=3) 
				{
					statement.setString( 1, request.getParameter(Integer.toString(i)) );
					statement.setString( 2, request.getParameter(Integer.toString(i+1)) );
					statement.setString( 3, request.getParameter(Integer.toString(i+2)) );
					statement.execute();
					
					rs = stmt.executeQuery("SELECT * FROM students");	
				    rs.last();
					arr.add(new ArrayList<String>(Arrays.asList(rs.getString("idStudents"), rs.getString("First_Name"), rs.getString("Last_Name"))));
				}
				
				//rs = stmt.executeQuery("SELECT * FROM STUDENTS WHERE idStudents > " + );
				
			}
			

			// if (req.equals(add))
			// {
				// rs.last();
				// int id = rs.getInt("idStudents") + 1;
				
				// String c1 = request.getParameter("col1");
				// String c2 = request.getParameter("col2");
			
				// String query = "INSERT INTO students(idStudents, First_Name, Last_Name) VALUES (?,?,?)";
				// PreparedStatement statement = con.prepareStatement( query );
				// statement.setInt( 1, id );
				// statement.setString( 2, c1 );
				// statement.setString( 3, c2 );
				// statement.execute();

				// rs = stmt.executeQuery("SELECT * FROM students");	
				// rs.last();
				// arr.add(new ArrayList<String>(Arrays.asList(rs.getString("idStudents"), rs.getString("First_Name"), rs.getString("Last_Name"))));
			// }
			// if (req.equals(del))
			// {			
				// arr = (ArrayList<ArrayList<String>>)session.getAttribute("arr");
			
				// int idDel = Integer.parseInt(request.getParameter("idDel"));
				// request.setAttribute("id", idDel);
			
				// rs = stmt.executeQuery("SELECT * FROM students");	
				// rs.absolute(idDel);
				// rs.deleteRow();
			

			// }
		}
	   
	   session.setAttribute("arr", arr);  
	   request.setAttribute("arr", arr); 
       
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