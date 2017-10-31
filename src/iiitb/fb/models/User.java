package iiitb.fb.models;

import java.io.File;

public class User {
	private String email;
	private String password;
	private String userName;
	private String fbemail;
	private String fname;
	private String lname;
	private String birthday;
	private String gender;
	private String highschool;
	private String college;
	private String companyname;
	private String currentcity;
	private String hometown;
	private int profile_id;
	private File myFile;
	private String myFileFileName;
	private String myFileContentType;
	private String profilePic;
	private File coverpic;
	private String coverpicFileName;
	private String coverpicContentType;
	

	
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	
	public File getCoverpic() {
		return coverpic;
	}
	public void setCoverpic(File coverpic) {
		this.coverpic = coverpic;
	}
	public String getCoverpicFileName() {
		return coverpicFileName;
	}
	public void setCoverpicFileName(String coverpicFileName) {
		this.coverpicFileName = coverpicFileName;
	}
	public String getCoverpicContentType() {
		return coverpicContentType;
	}
	public void setCoverpicContentType(String coverpicContentType) {
		this.coverpicContentType = coverpicContentType;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHighschool() {
		return highschool;
	}
	public void setHighschool(String highschool) {
		this.highschool = highschool;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCurrentcity() {
		return currentcity;
	}
	public void setCurrentcity(String currentcity) {
		this.currentcity = currentcity;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public String getFbemail() {
		return fbemail;
	}
	public void setFbemail(String fbemail) {
		this.fbemail = fbemail;
	}
}
