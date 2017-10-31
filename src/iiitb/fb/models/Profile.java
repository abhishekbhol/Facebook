package iiitb.fb.models;

import java.util.ArrayList;

public class Profile {

	
	private ArrayList<WorkEducation>  workexlist= new ArrayList<WorkEducation>();
	
	
	public ArrayList<WorkEducation> getWorkexlist() {
		return workexlist;
	}
	public void setWorkexlist(ArrayList<WorkEducation> workexlist) {
		this.workexlist = workexlist;
	}
	
	
	public String title;
	public String description;
	public String startDate;
	public String endDate;
	public String graduation;
	public int workeducation_id;
	
	
	
	
	
	
	public int getWorkeducation_id() {
		return workeducation_id;
	}
	public void setWorkeducation_id(int workeducation_id) {
		this.workeducation_id = workeducation_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}


	public String firstName;
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
    public String coverPic;
	public String email;
    
    
    
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	//getter and setter
    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public String getFavQuote() {
		return favQuote;
	}
	public void setFavQuote(String favQuote) {
		this.favQuote = favQuote;
	}
	public String getInterestedIn() {
		return interestedIn;
	}
	public void setInterestedIn(String interestedIn) {
		this.interestedIn = interestedIn;
	}
	public String getReligiousView() {
		return religiousView;
	}
	public void setReligiousView(String religiousView) {
		this.religiousView = religiousView;
	}
	public String getPoliticalView() {
		return politicalView;
	}
	public void setPoliticalView(String politicalView) {
		this.politicalView = politicalView;
	}
	public String getLanguageKnown() {
		return languageKnown;
	}
	public void setLanguageKnown(String languageKnown) {
		this.languageKnown = languageKnown;
	}
	public String getProfessionalSkill() {
		return professionalSkill;
	}
	public void setProfessionalSkill(String professionalSkill) {
		this.professionalSkill = professionalSkill;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getCoverPic() {
		return coverPic;
	}
	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}
    

    
	
}
