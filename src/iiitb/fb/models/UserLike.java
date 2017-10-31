package iiitb.fb.models;

public class UserLike {
	private int profileId;
	private String profilePic;
	private String fullName;
	private int wallPostId;
	private String timestamp;
	//to check whether it is liked by logged in user 
	private int isLiked;
	
	public int getIsLiked() {
		return isLiked;
	}
	public void setIsLiked(int isLiked) {
		this.isLiked = isLiked;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getWallPostId() {
		return wallPostId;
	}
	public void setWallPostId(int wallPostId) {
		this.wallPostId = wallPostId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	

}
