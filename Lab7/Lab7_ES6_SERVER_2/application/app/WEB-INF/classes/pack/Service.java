package pack;

import jakarta.ws.rs.Path;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.core.Response;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;

import jakarta.inject.Inject;

import pack.model.IModel;
import pack.model.Model;
import pack.model.IFactoryModel;
import pack.model.FactoryModel;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.net.*;
import java.sql.*;





@Path("/")
public class Service {
	
	// @Inject
	// IModel model;
	
	@POST   
	@Path("/changeArray")
	@Consumes("application/json")
	@Produces("application/json")
	public Response changeArray(String userDataJSON) 
	{    
		
		Jsonb jsonb = JsonbBuilder.create();          
		List<Student> students;      
		String resultJSON;
		try 
		{  
			try 
			{ 
				students = jsonb.fromJson(userDataJSON, new ArrayList<Student>(){}.getClass().getGenericSuperclass());  
				
			} catch (Exception e) { throw new Exception("Error while JSON transforming."); }

			// String url = "jdbc:mysql://localhost/demo?serverTimezone=Europe/Moscow&useSSL=false";
			// String username = "StudKuzmin";
			// String password = "trewolfol123";
			// Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			// Connection con = DriverManager.getConnection(url, username, password);
		
			// Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, /*ResultSet.CONCUR_READ_ONLY,*/ ResultSet.CONCUR_UPDATABLE);               						
			// ResultSet rs = stmt.executeQuery("SELECT * FROM students");		
			
			// stmt.executeUpdate("TRUNCATE students");
			// String query = "INSERT INTO students(idStudents, First_Name, Last_Name) VALUES (?,?,?)";
			// PreparedStatement statement = con.prepareStatement( query );
						
		
			// for (int i = 0; i < students.size(); i++)
			// {
				// statement.setString( 1, students.get(i).getId() );
				// statement.setString( 2, students.get(i).getFirst_Name() );
				// statement.setString( 3, students.get(i).getLast_Name() );
				// statement.execute();
			// }
			
			IFactoryModel ifm = new FactoryModel();
			IModel model = ifm.createModel();
			
			model.changeTable(students);
			resultJSON = jsonb.toJson(students);
			
			// rs.close();
			// stmt.close();
		}
		catch (JsonbException e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }
		catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }   
   
		return Response.ok(true).build();
	}
	
	
	@POST
	@Path("/showArray")
	@Consumes("application/json")
	@Produces("application/json")
	public Response showArray() 
	{            
		Jsonb jsonb = JsonbBuilder.create();          
		List<Student> students;      
		String resultJSON;
		try 
		{  
			students = new ArrayList<>();
		
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
	  
			IFactoryModel ifm = new FactoryModel();
			IModel model = ifm.createModel();
			
			model.fillTable(students);
			resultJSON = jsonb.toJson(students);
			
			// rs.close();
			// stmt.close();
		}	
		catch (JsonbException e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }
		catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }   
   
		
		return Response.ok(resultJSON).build();    
	}
	
	@POST   
	@Path("/userData")
	@Consumes("application/json")
	@Produces("application/json")
	public Response userData(String userDataJSON) 
	{            
		Jsonb jsonb = JsonbBuilder.create();          
		List<StudentData> studentsData;      
		String resultJSON;
		try 
		{  
			try 
			{ 
				studentsData = jsonb.fromJson(userDataJSON, new ArrayList<StudentData>(){}.getClass().getGenericSuperclass());                    
			} catch (Exception e) { throw new Exception("Error while JSON transforming."); }
			
			// StudentData st = new StudentData();
			// st.setLog("stud");
			// st.setPas("1234");
			
			// if (st.checkData(studentsData.get(0).getLog(), studentsData.get(0).getPas()))
				// return Response.ok(true).build();
			
			IFactoryModel ifm = new FactoryModel();
			IModel model = ifm.createModel();
			
			if(model.checkUserData(studentsData))
				return Response.ok(true).build();
			return Response.ok(false).build();
			 
		}
		catch (JsonbException e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }
		catch (Exception e) { return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build(); }   
   
	}
 

 
}