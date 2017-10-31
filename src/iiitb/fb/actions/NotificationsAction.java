package iiitb.fb.actions;

import iiitb.fb.models.Notification;
import iiitb.fb.models.User;
import iiitb.fb.models.UserWallPost;
import iiitb.fb.models.impl.LoadProfileImpl;
import iiitb.fb.models.impl.NotificationImpl;
import iiitb.fb.models.impl.WallPostImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.catalina.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NotificationsAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6524643316235426247L;
	private List<Notification> notificationsList;
	private List<Notification> friendRequestsList;
	private List<Notification> messageNotificationList;
	private String notificationType;
	private int friendRequestCount;
	private int messagesCount;
	
	private int uniqueId;

	//to get to a notification
	private UserWallPost uwp = new UserWallPost();
	private User user = new User();
	List<UserWallPost> wallPostsList;
	//to be moved to friend impl
	public String acceptFriendRequest(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u = (User)session.get("user");

		NotificationImpl ni = new NotificationImpl();
		if(ni.acceptFriendRequest(uniqueId, u.getProfile_id())){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String rejectFriendRequest(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u = (User)session.get("user");

		NotificationImpl ni = new NotificationImpl();
		if(ni.deleteFriendRequest(uniqueId, u.getProfile_id())){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public String updateFriendClickedTimestamp(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		NotificationImpl ni = new NotificationImpl();
		
		if(ni.updateFriendClickedTimestamp(u.getProfile_id())){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String updateMessageClickedTimestamp(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		NotificationImpl ni = new NotificationImpl();
		
		if(ni.updateMessageClickedTimestamp(u.getProfile_id())){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	public String updateNotificationClicked(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		NotificationImpl ni = new NotificationImpl();
		
		if(ni.updateNotificationClicked(u.getProfile_id())){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String loadNotifications(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");

		notificationsList = new ArrayList<Notification>();
		friendRequestsList = new ArrayList<Notification>();
		messageNotificationList = new ArrayList<Notification>();

		NotificationImpl ni = new NotificationImpl();
		notificationsList = ni.loadNotifications(user.getProfile_id());
		friendRequestCount = ni.friendRequestCount(user.getProfile_id());
		//if(friendRequestCount != 0){
			friendRequestsList = ni.loadFriendRequestsNotifications(user.getProfile_id());
		//}
		messagesCount = ni.messagesCount(user.getProfile_id());
	//	if(messagesCount != 0){
			messageNotificationList = ni.loadMessageNotifications(user.getProfile_id());
	//	}
		System.out.println("");
		return SUCCESS;
	}

	
	//On clicking single notification displayed in notification list
	public String loadSingleNotification(){
		if(notificationType.equalsIgnoreCase("Likes") || notificationType.equalsIgnoreCase("Comment")){
			WallPostImpl wpi = new WallPostImpl();
			uwp = wpi.getSingleWallPost(uniqueId);
			if(uwp != null){
				return "loadWallpost";
			}else{
				return ERROR;
			}
		}
		if(notificationType.equalsIgnoreCase("Friends")){
			LoadProfileImpl lpi = new LoadProfileImpl();
			user = lpi.getUser(uniqueId);
			if(user != null){
				WallPostImpl wpi = new WallPostImpl();
				wallPostsList = new ArrayList<UserWallPost>();
				wallPostsList = wpi.getWallPosts(user.getProfile_id());
				return "loadProfile";
			}else{
				return ERROR;
			}
		}
		return ERROR;
	}
	public List<Notification> getNotificationsList() {
		return notificationsList;
	}
	public void setNotificationsList(List<Notification> notificationsList) {
		this.notificationsList = notificationsList;
	}

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

	public UserWallPost getUwp() {
		return uwp;
	}

	public void setUwp(UserWallPost uwp) {
		this.uwp = uwp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserWallPost> getWallPostsList() {
		return wallPostsList;
	}

	public void setWallPostsList(List<UserWallPost> wallPostsList) {
		this.wallPostsList = wallPostsList;
	}

	public List<Notification> getFriendRequestsList() {
		return friendRequestsList;
	}

	public void setFriendRequestsList(List<Notification> friendRequestsList) {
		this.friendRequestsList = friendRequestsList;
	}

	public List<Notification> getMessageNotificationList() {
		return messageNotificationList;
	}

	public void setMessageNotificationList(
			List<Notification> messageNotificationList) {
		this.messageNotificationList = messageNotificationList;
	}
	public int getFriendRequestCount() {
		return friendRequestCount;
	}
	public void setFriendRequestCount(int friendRequestCount) {
		this.friendRequestCount = friendRequestCount;
	}
	public int getMessagesCount() {
		return messagesCount;
	}
	public void setMessagesCount(int messagesCount) {
		this.messagesCount = messagesCount;
	}
	

}
