package iiitb.fb.models;

public class Like {
	private int wallPostId;
	private int profileId;
	private String timestamp;
	
	
	public int getWallPostId() {
		return wallPostId;
	}
	public void setWallPostId(int wallPostId) {
		this.wallPostId = wallPostId;
	}
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
