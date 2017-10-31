package iiitb.fb.models;

public class Notification {
	private String notificationType;
	private int uniqueId;//can be of wallpost or friend request or messages
	private String notificationText;
	private String picture;
	private String timestamp;
	public String getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	public int getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getNotificationText() {
		return notificationText;
	}
	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
