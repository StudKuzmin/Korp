package pack.model;

import pack.controller.Student;
import pack.controller.StudentData;

import java.util.List;

public interface IModel 
{
	void changeTable(List<Student> students);
	void fillTable(List<Student> students);
	boolean checkUserData(List<StudentData> studentsData);
}