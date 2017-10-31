package iiitb.fb.models;

public class WorkEducation {

   public String workeducation_title;
   public int workeducation_id;
	public int getWorkeducation_id() {
	return workeducation_id;
}
public void setWorkeducation_id(int workeducation_id) {
	this.workeducation_id = workeducation_id;
}
	//Modify data type if necessary
	public String start_date;
    public String end_date;
    public String graduated;
    public String description;
    /*public String firstName;
	public String lastName;
    public String birthday;
    public String gender;
    public String homeTown;
    public String currentCity;
    public String phoneNo;
    public String relationshipStatus;
	public String aboutMe;
	public String favQuote;
	public String interestedIn;
	public String religiousView;
	public String politicalView;
	public String languageKnown;
	public String professionalSkill;
    public String profilePic;
    public String coverPic;*/
	public String getWorkeducation_title() {
		return workeducation_title;
	}
	public void setWorkeducation_title(String workeducation_title) {
		this.workeducation_title = workeducation_title;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getGraduated() {
		return graduated;
	}
	public void setGraduated(String graduated) {
		this.graduated = graduated;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    
    
    

}
