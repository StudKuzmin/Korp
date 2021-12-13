package pack.controller;

public class StudentData
{	
	private String log;
	private String pas;

	public String getLog() {
        return log;
    }
	public String getPas() {
        return pas;
    }

	public void setLog(String log) {
        this.log = log;
    }
	public void setPas(String pas) {
        this.pas = pas;
    }
	
	public boolean checkData(String log, String pas) {
		if (log.equals(this.log) && pas.equals(this.pas))
			return true;
		return false;
	}
}