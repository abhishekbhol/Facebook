package iiitb.fb.models;

public class UserComment {
	
	private int profileId;
	private String fullName;
	private String profilePicture;
	private int wallPostId;
	private String commentText;
	private String timestamp;
	private String visibility;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	
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
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
}
