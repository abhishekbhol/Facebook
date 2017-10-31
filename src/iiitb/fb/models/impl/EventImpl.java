package iiitb.fb.models.impl;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Event;
import iiitb.fb.models.Friend;
import iiitb.fb.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import oracle.jrockit.jfr.tools.ConCatRepository;

import com.opensymphony.xwork2.ActionContext;

public class EventImpl {

	public Map<String,ArrayList<Event>> showEventsList(int profile_id)	{

		ArrayList<Event> myEvents =new ArrayList<Event>();
		//ArrayList<ArrayList<Event>> datewiseEventList = new ArrayList<ArrayList<Event>>();
		ArrayList<Event> myallEvents =new ArrayList<Event>();
		ArrayList<ArrayList<Event>> allEventList = new ArrayList<ArrayList<Event>>();//unused
		ArrayList<Event> onDate =null;
		Date eventDtTm; 
		
		Map<String,ArrayList<Event>> datedEventMap=new TreeMap<String,ArrayList<Event>>();
		//String datematch="";


		String now=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").format(System.currentTimeMillis());
		System.out.println("current date " + now );

        /*events without bdays*/
		DatabaseConnect dc=new DatabaseConnect();
		String getEventsQuery = "select e.* from event e,eventinvite ei where (e.profile_id="+profile_id+" or (ei.invite_id="+profile_id+" and ei.event_id=e.event_id)) and e.isBirthday=0 and e.event_date>='"+now+"' group by e.event_id order by e.event_date ";


		ResultSet eventset = dc.getData(getEventsQuery);
		try {
			while(eventset.next())
			{
				Event ev = new Event();
				eventDtTm=new Date();
				ev.setEventId(eventset.getInt("event_id"));
				eventDtTm=eventset.getTimestamp("event_date");
				ev.setEventDateHdr(new SimpleDateFormat("EEEE, MMMM dd yyyy").format(eventDtTm));
				ev.setEventTime(new SimpleDateFormat("hh:mm:ss").format(eventDtTm));									
				ev.setEventId(eventset.getInt("event_id"));
				ev.setEventTitle(eventset.getString("event_title"));
				ev.setEventOwnerId(eventset.getInt("profile_id"));
				ev.setDescription(eventset.getString("description"));
				ev.setEventDate(eventset.getTimestamp("event_date"));
				ev.setEvent_where(eventset.getString("event_where"));
				ev.setEventStart(eventset.getTimestamp("event_start"));
				ev.setEventEnd(eventset.getTimestamp("event_end"));
				ev.setEventPhoto(eventset.getString("event_photo"));
				ev.setIsBirthday(eventset.getInt("isBirthday"));
				
				myEvents.add(ev);			

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		/*Sorted B'day list for a given profile id on the basis of month and date*/

		class CustomComparator implements Comparator<Event> {
			@Override
			public int compare(Event o1, Event o2) {
				String bday1=new SimpleDateFormat("MM-dd").format(o1.getEventDate());
				String bday2=new SimpleDateFormat("MM-dd").format(o2.getEventDate());

				return bday1.compareTo(bday2);
			}
		}

		/*get bday of friends */
		String getBdayQuery = "select * from event e ,friends f where e.isBirthday=1 and f.profile_id='"+profile_id+"' and e.profile_id=f.friend_id";
		ArrayList< Event> bDayList=new ArrayList<Event>();
		ResultSet bDayset = dc.getData(getBdayQuery);
		try {
			while(bDayset.next())
			{
				Event ev = new Event();
				eventDtTm=new Date();
				eventDtTm=bDayset.getTimestamp("event_date");
				ev.setEventId(bDayset.getInt("event_id"));
				ev.setEventDateHdr(new SimpleDateFormat("EEEE, MMMM dd yyyy").format(eventDtTm));
				ev.setEventTime(new SimpleDateFormat("hh:mm:ss").format(eventDtTm));									
				ev.setEventId(bDayset.getInt("event_id"));
				ev.setEventTitle(bDayset.getString("event_title"));
				ev.setEventOwnerId(bDayset.getInt("profile_id"));
				ev.setDescription(bDayset.getString("description"));
				ev.setEventDate(bDayset.getTimestamp("event_date"));
				ev.setEvent_where(bDayset.getString("event_where"));
				ev.setEventStart(bDayset.getTimestamp("event_start"));
				ev.setEventEnd(bDayset.getTimestamp("event_end"));
				ev.setEventPhoto(bDayset.getString("event_photo"));
				ev.setIsBirthday(bDayset.getInt("isBirthday"));
				
				bDayList.add(ev);


			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Collections.sort(bDayList, new CustomComparator());

		System.out.println("Birthdays");
		for(int i=0;i<bDayList.size() ; i++)

		{

			System.out.println(bDayList.get(i).getEventTitle() +" at " + bDayList.get(i).getEventDateHdr());
		} 


		/*Merge the list of b'day and other events on the basis of their dates*/
		int i=0,j=0 ;

		while(i<myEvents.size() && j<bDayList.size())
		{
			String eventdate=new SimpleDateFormat("MM-dd").format(myEvents.get(i).getEventDate());
			String bdaydate=new SimpleDateFormat("MM-dd").format(bDayList.get(j).getEventDate());

			if((eventdate.compareTo(bdaydate))<0)
			{
				myallEvents.add(myEvents.get(i));
				System.out.println("added "+myEvents.get(i).getEventTitle() + "on" + new SimpleDateFormat("MM-dd").format(myEvents.get(i).getEventDate()) );
				i++;
			}

			else if((eventdate.compareTo(bdaydate))==0)
			{
				myallEvents.add(myEvents.get(i));
				System.out.println("added "+myEvents.get(i).getEventTitle()+ "on" + new SimpleDateFormat("MM-dd").format(myEvents.get(i).getEventDate()));
				i++;

			}
			else if((eventdate.compareTo(bdaydate))>0)
			{
				myallEvents.add(bDayList.get(j));
				System.out.println("added "+bDayList.get(j).getEventTitle()+ "on" + new SimpleDateFormat("MM-dd").format(bDayList.get(j).getEventDate()));
				j++;
			}

		}


		if(i<myEvents.size())
		{
			for(int k=i;k<myEvents.size();k++)
			{myallEvents.add(myEvents.get(k));
			System.out.println("added "+ myEvents.get(k).getEventTitle()+"on " + new SimpleDateFormat("MM-dd").format(myEvents.get(k).getEventDate()));
			}
		}

		else if (j<bDayList.size())
		{
			for(int k=j;k<bDayList.size();k++)
			{	myallEvents.add(bDayList.get(k));
			System.out.println("added "+bDayList.get(k).getEventTitle() +"on" + new SimpleDateFormat("MM-dd").format(bDayList.get(k).getEventDate()));
			}


		}

		for(Event e: myallEvents)
		{
			System.out.println("event" + e.getEventTitle() + "date" +e.getEventDate());
		}


		int p=0;

		while(p< myallEvents.size())
		{   
			onDate=new ArrayList<Event>(); 
			String datecheck =new SimpleDateFormat("MM-dd").format(myallEvents.get(p).getEventDate());
			while(p< myallEvents.size() && datecheck.equals(new SimpleDateFormat("MM-dd").format(myallEvents.get(p).getEventDate())))
			{ 
				onDate.add(myallEvents.get(p));
				p++;
			}
			
		//	int len=onDate.get(0).getEventDate().length();
			
			/*datewiseEventMap  contains datewise eventlist */
				datedEventMap.put(new SimpleDateFormat("MM-dd , EEEE").format(onDate.get(0).getEventDate()), onDate);
				
			allEventList.add(onDate); //unused

		}



		System.out.println("allEventList");

		for(int q=0;i<allEventList.size() ; i++)
		{
			System.out.println("sublist");
			for(int r=0;j<allEventList.get(q).size() ; j++)
				System.out.println(allEventList.get(q).get(r).getEventTitle());
		}




		//return allEventList ;
		return datedEventMap;
	}

	public int addEvent(Event newEvent,String invited)	
	{
		DatabaseConnect dc=new DatabaseConnect();
		Connection connection = dc.getConnection();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		String getAddEventsQuery = "INSERT into event(profile_id,event_title,description,event_where,event_date,event_start,event_end,event_photo,isBirthday)" + "VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			
			
			PreparedStatement ps = connection.prepareStatement(getAddEventsQuery);
			ps.setInt(1,newEvent.getEventOwnerId());
			ps.setString(2,newEvent.getEventTitle());
			ps.setString(3,newEvent.getDescription());
			ps.setString(4,newEvent.getEvent_where());
			ps.setString(5,(sdf.format(newEvent.getEventDate())+" "+newEvent.getEventTime()));
			ps.setString(6,sdf.format(newEvent.getEventStart()));
			ps.setString(7,sdf.format(newEvent.getEventEnd()));
			ps.setString(8,newEvent.getEventPhoto());
			ps.setInt(9,newEvent.getIsBirthday());

			dc.updateData(ps);
			String queryId = "select last_insert_id()";
			ps = connection.prepareStatement(queryId);
			ResultSet rs = dc.getData(ps);

			int eventId=0;
			if(rs.next()){
				eventId =  rs.getInt("last_insert_id()");
			}
			
			
			//call method to make entry in eventinvite table
			
			addInvitedFriends(eventId,invited);
			Map<String, Object> session = ActionContext.getContext().getSession();
			User user = (User)session.get("user");
			newEvent.setEventOwnerName(user.getFname()+" " +user.getLname());
			newEvent.setEventDateHdr(new SimpleDateFormat("EEEE, MMMM dd yyyy").format(newEvent.getEventDate()));
			return eventId;

			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;

		}





	}



	/*.............................................................................
	 * 	Add invited friends to the invite table.								   *
	 ..............................................................................*/

	public boolean addInvitedFriends(int eventId,String invited)
	{
		System.out.println(eventId);
		System.out.println(invited);
		DatabaseConnect dc=new DatabaseConnect();
		Connection  connection = dc.getConnection();
		for (String token : invited.split(","))
		{
			int inviteId = Integer.parseInt(token);
			String addInvitequery = "Insert into eventinvite(event_id,invite_id,status )" + "values(?,?,?)";
			try {
				PreparedStatement ps = connection.prepareStatement(addInvitequery);
				ps.setInt(1,eventId);
				ps.setInt(2, inviteId);
				ps.setString(3,"sent");
				dc.updateData(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}

	public boolean editEvent()	{
		return true ;
	}



	/*.........................................................................
	 * This function get the complete friendlist of the user to show in modal  *
	 ..........................................................................*/

	public void  inviteFriends(int profileId, ArrayList<Friend> friendlist)	{

		DatabaseConnect dc=new DatabaseConnect();
		String getfriendidQuery = "select friend_id from friends where profile_id='"+profileId+"'";


		ResultSet friendset = dc.getData(getfriendidQuery);
		try {
			while(friendset.next())
			{
				Friend fr=new Friend();
				fr.setProfile_id(friendset.getInt("friend_id"));
				String getfrienddetailQuery = "select first_name,last_name,profile_pic from profile where profile_id='"+fr.getProfile_id()+"'";
				ResultSet frienddetailset = dc.getData(getfrienddetailQuery);
				while(frienddetailset.next()){
					fr.setFriendprofilepic(frienddetailset.getString("profile_pic"));
					fr.setFname(frienddetailset.getString("first_name"));
					fr.setLname(frienddetailset.getString("last_name"));
				}

				friendlist.add(fr);

			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	

	public boolean showEventPage(Event newEvent)
	{
		DatabaseConnect dc=new DatabaseConnect();
		String getEventDetailQuery = "select e.*,p.first_name,p.last_name from event e, profile p where event_id='"+newEvent.getEventId()+"' and e.profile_id=p.profile_id";
		Date eventDtTm;
		ResultSet eventset = dc.getData(getEventDetailQuery);
		try {
			while(eventset.next())
			{eventDtTm=new Date();
			newEvent.setEventTitle(eventset.getString("event_title"));
			newEvent.setDescription(eventset.getString("description"));
			newEvent.setEventOwnerId(eventset.getInt("profile_id"));
			newEvent.setEventOwnerName(eventset.getString("first_name")+" " +eventset.getString("last_name"));
			eventDtTm=eventset.getTimestamp("event_date");
			newEvent.setEventDateHdr(new SimpleDateFormat("EEEE, MMMM dd yyyy").format(eventDtTm));
			newEvent.setEventTime(new SimpleDateFormat("HH:MM aa").format(eventDtTm));
			newEvent.setEvent_where(eventset.getString("event_where"));
			newEvent.setEventPhoto(eventset.getString("event_photo"));

			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return true;
	}

	/*change the join status of invited person whether he is going or not*/
public void updateJoinStat(int profile_id, String joinStatus,int eventId)
	
	{
	System.out.println("m inside update join status");
		DatabaseConnect dc=new DatabaseConnect();
		String query ="update eventinvite set status='"+joinStatus+"' where invite_id ='"+profile_id+"' and event_id='"+eventId+"'";
		dc.updateData(query);
		
	
	}


public void cancelEvent(int eventid)

{
	DatabaseConnect dc=new DatabaseConnect();
	String query ="delete from event where event_id ='"+eventid+"' ";
	dc.updateData(query);
	

}



public void setguestsList(int eventId,List<User> invitedList,List<User> goingList,List<User> maybeList)
{/*set who all friends are invited */
	
	
	System.out.println("setguestlist" +eventId);
	
	
	DatabaseConnect dc=new DatabaseConnect();
	
		try
		{
			
			String query2="select p.first_name,p.last_name,p.profile_id,p.profile_pic from profile p,eventinvite ei where ei.event_id='"+eventId+"' and ei.status='Maybe' and p.profile_id=ei.invite_id" ;
			ResultSet maybeset = dc.getData(query2);
			
				while(maybeset.next())
				{
					User u = new User();
					u.setFname(maybeset.getString("first_name"));
					u.setLname(maybeset.getString("last_name"));
					u.setProfile_id(maybeset.getInt("profile_id"));
					u.setProfilePic(maybeset.getString("profile_pic"));
					maybeList.add(u);
				}
				System.out.println("maybe list" +maybeList);
	    String query="select p.first_name,p.last_name,p.profile_id,p.profile_pic from profile p,eventinvite ei where ei.event_id='"+eventId+"' and ei.status='sent' and p.profile_id=ei.invite_id" ;
	    ResultSet invitedset = dc.getData(query);
		
	    
	    	while(invitedset.next())
			{
				User u = new User();
				u.setFname(invitedset.getString("first_name"));
				u.setLname(invitedset.getString("last_name"));
				u.setProfile_id(invitedset.getInt("profile_id"));
				u.setProfilePic(invitedset.getString("profile_pic"));
				invitedList.add(u);
				
			}
			
			String query1="select p.first_name,p.last_name,p.profile_id,p.profile_pic from profile p,eventinvite ei where ei.event_id='"+eventId+"' and ei.status='Going' and p.profile_id=ei.invite_id" ;
			ResultSet goingset = dc.getData(query1);
			
				while(goingset.next())
				{
					User u = new User();
					u.setFname(goingset.getString("first_name"));
					u.setLname(goingset.getString("last_name"));
					u.setProfile_id(goingset.getInt("profile_id"));
					u.setProfilePic(goingset.getString("profile_pic"));
					goingList.add(u);
				}
				
				
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
					
	}

public void  uninvitedFriends(int eventId,ArrayList<User> uninvitedFriends)
{
	
	DatabaseConnect dc=new DatabaseConnect();
	
	
    String query="select profile_id from event where event_id='"+eventId+"'";
    ResultSet rs = dc.getData(query);
	try {
		while(rs.next())
		{
			 String query1="select profile_id,first_name,last_name from profile where profile_id in(select friend_id from friends f,eventinvite ei where "
			 		+ "ei.event_id='"+eventId+"' and f.profile_id='"+rs.getInt("profile_id")+"' and f.friend_id not in(select invite_id from eventinvite where event_id='"+eventId+"'))";
			    ResultSet rs1 = dc.getData(query1);
			    while(rs1.next())
			    {
			    	User u =new User();
			    	u.setProfile_id(rs1.getInt("profile_id"));
			    	u.setFname(rs1.getString("first_name"));
			    	u.setLname(rs1.getString("last_name"));
			    	uninvitedFriends.add(u);
			    }
			    
			
		}
		
		
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}


}

	



