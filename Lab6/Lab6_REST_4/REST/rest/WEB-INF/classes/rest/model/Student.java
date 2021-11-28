package rest.model;

public class Student
{
    private String id;
    private String first_Name;
	private String last_Name;

    public String getId() {
        return id;
    }
    public String getFirst_Name() {
        return first_Name;
    }
	public String getLast_Name() {
        return last_Name;
    }

	public void setId(String id) {
        this.id = id;
    }
    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }	
	public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }
}