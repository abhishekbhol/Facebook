package iiitb.fb.actions;


import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxExample extends ActionSupport{
	
	ArrayList<String> subjects=new ArrayList<String>();
	String name;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String subjectList()
	{
		name="Dipesh";
		subjects.add("OOAD");
		subjects.add("Data Modeling");
		subjects.add("SE");
		subjects.add("Web IR");
		return SUCCESS;
	}

	public ArrayList<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(ArrayList<String> subjects) {
		this.subjects = subjects;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
