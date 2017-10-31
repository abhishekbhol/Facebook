package iiitb.fb.models;

public class WallPost {
	
	private int wallPostId;
	private int postFrom;
	private int postTo;
	private String wallPostText;
	private String timestamp;
	private String visibility;
	private int eventId;
	
	public int getWallPostId() {
		return wallPostId;
	}
	public void setWallPostId(int wallPostId) {
		this.wallPostId = wallPostId;
	}
	public int getPostFrom() {
		return postFrom;
	}
	public void setPostFrom(int postFrom) {
		this.postFrom = postFrom;
	}
	public int getPostTo() {
		return postTo;
	}
	public void setPostTo(int postTo) {
		this.postTo = postTo;
	}
	public String getWallPostText() {
		return wallPostText;
	}
	public void setWallPostText(String wallPostText) {
		this.wallPostText = wallPostText;
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
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
}
