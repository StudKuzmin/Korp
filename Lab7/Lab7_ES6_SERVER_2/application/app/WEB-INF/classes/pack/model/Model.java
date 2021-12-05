package pack.model;

import pack.Student;
import pack.StudentData;

import java.util.List;
import java.net.*;
import java.sql.*;

public class Model implements IModel
{    
	Statement stmt;               						
	ResultSet rs;	
	PreparedStatement statement;
	Connection con;
		
	public Model()
	{
		try 
		{
			String url = "jdbc:mysql://localhost/demo?serverTimezone=Europe/Moscow&useSSL=false";
			String username = "StudKuzmin";
			String password = "trewolfol123";
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			con = DriverManager.getConnection(url, username, password);	
			
		} catch (Exception ex) { System.out.println(ex); }
						
	}
	public void changeTable(List<Student> students)
	{
		try 
		{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, /*ResultSet.CONCUR_READ_ONLY,*/ ResultSet.CONCUR_UPDATABLE);  
			rs = stmt.executeQuery("SELECT * FROM students");	
		
			stmt.executeUpdate("TRUNCATE students");
			String query = "INSERT INTO students(idStudents, First_Name, Last_Name) VALUES (?,?,?)";
			statement = con.prepareStatement( query );
			
			for (int i = 0; i < students.size(); i++)
				{
					statement.setString( 1, students.get(i).getId() );
					statement.setString( 2, students.get(i).getFirst_Name() );
					statement.setString( 3, students.get(i).getLast_Name() );
					statement.execute();
				}
		} catch (Exception ex) { System.out.println(ex); }
		
	}
	
	public void fillTable(List<Student> students)
	{
		try
		{
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, /*ResultSet.CONCUR_READ_ONLY,*/ ResultSet.CONCUR_UPDATABLE);               						
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");		
			
			while(rs.next())
			{
				Student st = new Student();
				st.setId(rs.getString("idStudents"));
				st.setFirst_Name(rs.getString("First_Name"));
				st.setLast_Name(rs.getString("Last_Name"));
		
				students.add(st);
			}
		} catch (Exception ex) { System.out.println(ex); }
	}
	
	public boolean checkUserData(List<StudentData> studentsData) 
	{
		StudentData st = new StudentData();
		st.setLog("stud");
		st.setPas("1234");
			
		if (st.checkData(studentsData.get(0).getLog(), studentsData.get(0).getPas()))
			return true;
		return false;
	}
	
	public void finalize()
	{
		try
		{
			rs.close();
			stmt.close();
		} catch (Exception ex) { System.out.println(ex); }
	}		
}