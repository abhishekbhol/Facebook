package iiitb.fb.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import iiitb.fb.models.Friend;
import iiitb.fb.models.User;






import iiitb.fb.models.impl.FriendsImpl;
import iiitb.fb.models.impl.LoadProfileImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FriendsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user=new User();
	
	int numberoffriends;
	List<Friend> allfriends;
	private int profileId;
	Map<String, Object> session=ActionContext.getContext().getSession();
	
	
	public String getFriends()
	{
		
		FriendsImpl friends=new FriendsImpl();
		LoadProfileImpl lpi = new LoadProfileImpl();
		user.setProfile_id(profileId);
		allfriends=friends.allFriends(user);
		user = lpi.getUser(profileId);
		numberoffriends=allfriends.size();
		System.out.println(numberoffriends);		
		return SUCCESS;
	}
	
	public String sendFriendRequest()
	{
		System.out.println("SEND FRIEND REQUEST.");
		System.out.println(profileId);
		FriendsImpl friends=new FriendsImpl();
		User user=(User) session.get("user");
		int loggedinProfileId=user.getProfile_id();
		int friendProfileId=(int)session.get("currentProfile");
		friends.sendfriendRequest(loggedinProfileId,friendProfileId);
		return SUCCESS;
	}

	public String peopleYouMayKnowSendRequest()
	{
		FriendsImpl friends=new FriendsImpl();
		User user=(User) session.get("user");
		int loggedinProfileId=user.getProfile_id();
		friends.sendfriendRequest(loggedinProfileId,profileId);
		return SUCCESS;
	}
	
	public String cancleFriendRequest()
	{
		FriendsImpl friends=new FriendsImpl();
		User user=(User) session.get("user");
		int loggedinProfileId=user.getProfile_id();
		int friendProfileId=(int)session.get("currentProfile");
		friends.cancleRequest(loggedinProfileId,friendProfileId);
		return SUCCESS;
	}
	
	public List<Friend> getAllfriends() {
		return allfriends;
	}




	public void setAllfriends(List<Friend> allfriends) {
		this.allfriends = allfriends;
	}


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public int getNumberoffriends() {
		return numberoffriends;
	}



	public void setNumberoffriends(int numberoffriends) {
		this.numberoffriends = numberoffriends;
	}



	public Map<String, Object> getSession() {
		return session;
	}




	public int getProfileId() {
		return profileId;
	}




	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	
}
