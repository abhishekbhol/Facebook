package iiitb.fb.actions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Event;
import iiitb.fb.models.User;
import iiitb.fb.models.UserWallPost;
import iiitb.fb.models.impl.EventImpl;
import iiitb.fb.models.impl.WallPostImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EventAction extends ActionSupport implements ModelDriven<Event> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2616936539514334834L;
	//private List<Event> eventlist= new ArrayList<Event>() ;
	Event newEvent=new Event();
	private ArrayList<ArrayList<Event>> datewiseEventList=null;
	Map<String,ArrayList<Event>> datedEventMap=null;
	public Map<String, ArrayList<Event>> getDatedEventMap() {
		return datedEventMap;
	}

	public void setDatedEventMap(Map<String, ArrayList<Event>> datedEventMap) {
		this.datedEventMap = datedEventMap;
	}

	private String invitedFriendIds;
	private String eventDateTemp;
	private List<UserWallPost> wallPostsList;
	private int eventId;
	
	private List<User> invitedList;
	private List<User> goingList;
	private List<User> maybeList;
	
	
	public List<User> getInvitedList() {
		return invitedList;
	}

	public void setInvitedList(List<User> invitedList) {
		this.invitedList = invitedList;
	}

	public List<User> getGoingList() {
		return goingList;
	}

	public void setGoingList(List<User> goingList) {
		this.goingList = goingList;
	}

	public List<User> getMaybeList() {
		return maybeList;
	}

	public void setMaybeList(List<User> maybeList) {
		this.maybeList = maybeList;
	}

	public String getInvitedfriendIds() {
		return invitedFriendIds;
	}

	public void setInvitedfriendIds(String invitedfriendIds) {
		this.invitedFriendIds = invitedfriendIds;
	}

	public Event getNewEvent() {
		return newEvent;
	}

	public void setNewEvent(Event newEvent) {
		this.newEvent = newEvent;
	}

	public ArrayList<ArrayList<Event>> getDatewiseEventList() {
		return datewiseEventList;
	}

	public void setDatewiseEventList(ArrayList<ArrayList<Event>> datewiseEventList) {
		this.datewiseEventList = datewiseEventList;
	}



	public String showEventsList()	{

		datewiseEventList =new ArrayList<ArrayList<Event>>();
		datedEventMap=new HashMap<String,ArrayList<Event>>();
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		EventImpl ei=new EventImpl();
		//datewiseEventList=ei.showEventsList(user.getProfile_id());	
		datedEventMap=ei.showEventsList(user.getProfile_id());
		return SUCCESS;
	}


	/*.........................................
	 * call impl to add event to database      *
 	  ..........................................*/
	public String addEvent()	{
		System.out.println("m inside addEvent action");
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		int ownerId=user.getProfile_id();
		Date dt =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		try {
			newEvent.setEventDate(sdf.parse(eventDateTemp));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//get date and time and concatenate to save
		String dtStr = new SimpleDateFormat("yyyy-MM-dd").format(newEvent.getEventDate()) ;
		dtStr += " "+newEvent.getEventTime() ;
		try {
			dt=  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dtStr);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		newEvent.setEventOwnerId(ownerId);
		
		//if you want to save event on the home page alongwith bday notification--display event 1day before
		newEvent.setEventStart(	new Date(dt.getTime() - 1 * 24 * 3600 * 1000)) ;
		newEvent.setEventEnd(dt);	
		newEvent.setEventPhoto(" ");	
		newEvent.setIsBirthday(0);

		EventImpl ei=new EventImpl();
		eventId = ei.addEvent(newEvent,invitedFriendIds);
		System.out.println(eventId);
		if(eventId != 0){
			WallPostImpl wi = new WallPostImpl();
			wallPostsList = wi.getEventWallPosts(eventId);
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}

	}
	
	
	

	public String editEvent()	{
		return SUCCESS;
	}

	public String  inviteFriends()	{
       eventId=newEvent.getEventId();
		System.out.println("m inside invite friensds");

		EventImpl ei=new EventImpl();
		ei.addInvitedFriends(eventId, invitedFriendIds);






		return SUCCESS;
	}

	
	public String  cancelEvent(){
		
		System.out.println("m inside cancelevent");
		 eventId=newEvent.getEventId();
			
			EventImpl ei=new EventImpl();
			ei.cancelEvent(eventId);
			
			

		
		return SUCCESS;
		
	}
		
	public String showEventPage()	{
		System.out.println(newEvent.getEventId());
		//query database to get details of that event 
		EventImpl ei=new EventImpl();
		ei.showEventPage(newEvent);
		invitedList=new ArrayList<User>();
		goingList=new ArrayList<User>();
		maybeList=new ArrayList<User>();
		
		ei.setguestsList(newEvent.getEventId(),invitedList,goingList,maybeList);
		
		
		WallPostImpl wi = new WallPostImpl();
		wallPostsList = wi.getEventWallPosts(newEvent.getEventId());
		return SUCCESS;


	}
	public String execute(){

		return SUCCESS;
	}
	
	
	public String getInvitedFriendIds() {
		return invitedFriendIds;
	}

	public void setInvitedFriendIds(String invitedFriendIds) {
		this.invitedFriendIds = invitedFriendIds;
	}

	public String getEventDateTemp() {
		return eventDateTemp;
	}

	public void setEventDateTemp(String eventDateTemp) {
		this.eventDateTemp = eventDateTemp;
	}

	public List<UserWallPost> getWallPostsList() {
		return wallPostsList;
	}

	public void setWallPostsList(List<UserWallPost> wallPostsList) {
		this.wallPostsList = wallPostsList;
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public Event getModel() {
		// TODO Auto-generated method stub
		return newEvent;
	}

}
