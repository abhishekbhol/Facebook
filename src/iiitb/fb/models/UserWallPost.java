package iiitb.fb.models;

import java.util.ArrayList;
import java.util.List;

public class UserWallPost {
	
	private int postFrom;
	private String postFromName;
	private String postFromPicture;
	private int postTo;
	private String postToName;
	private int wallPostId;
	private String wallPostText;
	private String timestamp;
	private String visibility;
	private int eventId;
	private int isLiked;
	private List<UserComment> commentsList = new ArrayList<UserComment>();
	private List<UserLike> likesList = new ArrayList<UserLike>();
	
	
	public List<UserComment> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(List<UserComment> commentsList) {
		this.commentsList = commentsList;
	}
	public List<UserLike> getLikesList() {
		return likesList;
	}
	public void setLikesList(List<UserLike> likesList) {
		this.likesList = likesList;
	}
	public int getPostFrom() {
		return postFrom;
	}
	public String getPostFromName() {
		return postFromName;
	}
	public void setPostFromName(String postFromName) {
		this.postFromName = postFromName;
	}
	public String getPostFromPicture() {
		return postFromPicture;
	}
	public void setPostFromPicture(String postFromPicture) {
		this.postFromPicture = postFromPicture;
	}
	public String getPostToName() {
		return postToName;
	}
	public void setPostToName(String postToName) {
		this.postToName = postToName;
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
	public int getWallPostId() {
		return wallPostId;
	}
	public void setWallPostId(int wallPostId) {
		this.wallPostId = wallPostId;
	}
	public int getIsLiked() {
		return isLiked;
	}
	public void setIsLiked(int isLiked) {
		this.isLiked = isLiked;
	}
	
	
}
