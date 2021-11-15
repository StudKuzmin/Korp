package rest;

import jakarta.ws.rs.Path;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.core.Response;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.net.*;
import java.sql.*;



@Path("/")
public class Model {
	
	// @POST
	// @Path("/showArray")
	// @Consumes("application/json")
	// @Produces("application/json")
	// public Response showArray() 
	// {            
		// Jsonb jsonb = JsonbBuilder.create();          
		// List<Student> students;      
		// String resultJSON;
		// try 
		// {  
			// students = new ArrayList<>();
		
			// String url = "jdbc:mysql://localhost/demo?serverTimezone=Europe/Moscow&useSSL=false";
			// String username = "StudKuzmin";
			// String password = "trewolfol123";
			// Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			// Connection con = DriverManager.getConnection(url, username, password);
		
			// Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, /*ResultSet.CONCUR_READ_ONLY,*/ ResultSet.CONCUR_UPDATABLE);               						
			// ResultSet rs = stmt.executeQuery("SELECT * FROM students");		
		
			// while(rs.next())
			// {
				// Student st = new Student();
				// st.setId(rs.getString("idStudents"));
				// st.setFirst_Name(rs.getString("First_Name"));
				// st.setLast_Name(rs.getString("Last_Name"));
		
				// students.add(st);
			// }
	  
			// resultJSON = jsonb.toJson(students);	  	 
		// }	
		// catch (JsonbException e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }
		// catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }   
   
		// return Response.ok(resultJSON).build();    
	// }
 

 
 
	@POST   
	@Path("/userData")
	@Consumes("application/json")
	@Produces("application/json")
	public Response userData(String userDataJSON) 
	{            
		String login = "stud";
		String password = "1234";
 
		Jsonb jsonb = JsonbBuilder.create();          
		List<StudentData> studentsData;      
		String resultJSON;
		try 
		{  
			try 
			{ 
				studentsData = jsonb.fromJson(userDataJSON, new ArrayList<StudentData>(){}.getClass().getGenericSuperclass());                    
			} catch (Exception e) { throw new Exception("Error while JSON transforming."); }
			
			StudentData st = new StudentData();
			st.setLog("stud");
			st.setPas("1234");
			
			if (st.checkData(studentsData.get(0).getLog(), studentsData.get(0).getPas()))
				return Response.ok(true).build(); 
			return Response.ok(false).build();
			
			//resultJSON = jsonb.toJson(studentsData);	  	 
		}
		catch (JsonbException e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }
		catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }   
   
  
		//return Response.ok(userDataJSON).build(); 
	}
	
 // @POST   
 // @Path("/userData")
 // @Consumes("application/json")
 // @Produces("application/json")
 // public Response userData(String studentsJSON) 
 // {            
   // Jsonb jsonb = JsonbBuilder.create();          
   // List<StudentData> students;      
   // String resultJSON;
   // try {  
      // try { 
       // students = jsonb.fromJson(studentsJSON,new ArrayList<StudentData>(){}.getClass().getGenericSuperclass());                    
      // }
      // catch (Exception e) {
        // throw new Exception("Error while JSON transforming.");  
      // }
      // for (StudentData student : students ) {
		  // student.setLog(student.getLog()+"hi ");
      // }		  
	  // resultJSON = jsonb.toJson(students);	  	 
   // }
   // catch (JsonbException e) {
    // return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	             
   // }
   // catch (Exception e) {
    // return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();	             
   // }    
   // return Response.ok("OKAA").build();           
 // }
 

 
}