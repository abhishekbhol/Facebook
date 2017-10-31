package iiitb.fb.actions;

import java.util.ArrayList;
import java.util.Map;

import iiitb.fb.models.Friend;
import iiitb.fb.models.User;
import iiitb.fb.models.impl.EventImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class inviteFriendsAction extends ActionSupport {
Friend friendObj =new Friend();
private ArrayList<Friend> friendlist ;
String joinStatus;
int eventId;
private ArrayList<User> uninvitedFriends;


public ArrayList<User> getUninvitedFriends() {
	return uninvitedFriends;
}

public void setUninvitedFriends(ArrayList<User> uninvitedFriends) {
	this.uninvitedFriends = uninvitedFriends;
}

public int getEventId() {
	return eventId;
}

public void setEventId(int eventId) {
	this.eventId = eventId;
}

public String getJoinStatus() {
	return joinStatus;
}

public void setJoinStatus(String joinStatus) {
	this.joinStatus = joinStatus;
}




public ArrayList<Friend> getFriendlist() {
	return friendlist;
}



public void setFriendlist(ArrayList<Friend> friendlist) {
	this.friendlist = friendlist;
}



public String execute()
{
	System.out.println("In execute inviteFriendAction");
	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	int profile_id=user.getProfile_id();
	//int profile_id = 1;
	 friendlist =new ArrayList<Friend>();
	EventImpl empl =new EventImpl();
	friendlist =new ArrayList<Friend>();
	empl.inviteFriends(profile_id,friendlist);
	
	
		System.out.println(friendlist.toString());
	

	return SUCCESS;
	
	
}
	
public String uninvitedFriends()
{
	EventImpl ei=new EventImpl();
	uninvitedFriends=new ArrayList<User>();
	ei.uninvitedFriends(eventId,uninvitedFriends);

	
	return SUCCESS;
}

//To update the status of a invited friend whether he is going to the event or not

public String updateJoinStatus()
{
//write query to update status in the eventinvite table for an invitee
	System.out.println("m inside invitefriendaction to update join status: eventid" +eventId);
	Map<String,Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	EventImpl ei =new EventImpl();
	ei.updateJoinStat(user.getProfile_id(),joinStatus,eventId);
	
	
	
	return SUCCESS;
}


	//create list of friend.java model 
	
	
	
	
	
	
	
	
	
}
