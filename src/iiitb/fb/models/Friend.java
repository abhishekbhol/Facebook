package iiitb.fb.models;


public class Friend {

	private String friendprofilepic;
	private String fname;
	private String lname;
	private int profile_id;
	private int isFriend; // only used in search 


	public String getFriendprofilepic() {
		return friendprofilepic;
	}
	public void setFriendprofilepic(String friendprofilepic) {
		this.friendprofilepic = friendprofilepic;
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
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public int getIsFriend() {
		return isFriend;
	}
	public void setIsFriend(int isFriend) {
		this.isFriend = isFriend;
	}


}
