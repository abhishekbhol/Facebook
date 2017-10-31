package iiitb.fb.models.impl;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import iiitb.fb.database.*;
import iiitb.fb.models.*;

public class MessagePageImpl {

	List<MessageNameList> chatlist = new ArrayList<MessageNameList>();
	DatabaseConnect db = new DatabaseConnect();
	List<MessageNameList> conversationList = new ArrayList<MessageNameList>();

	String firstChatName;
	int firstChatId;
	int unreadmsg;
	List<String> times = new ArrayList<String>();
	List<Integer> conversation_ids= new ArrayList<Integer>();
	List<String> chatting = new ArrayList<String>();   // for individual conversation ids
	List<Integer> chatting_ids= new ArrayList<Integer>();
	List<Integer> message_ids= new ArrayList<Integer>();




	public List<MessageNameList> getConversationList() {
		return conversationList;
	}

	public void setConversationList(List<MessageNameList> conversationList) {
		this.conversationList = conversationList;
	}

	//Get names of all the person with whom the current user have conversation sort by timestamp
	public List<MessageNameList> getnames(int profile_id)
	{
		int i=0,j,flag=0,size;
		System.out.println("in messagepageImpl getnames()");
		try{
			ResultSet rs = db.getData("select sender_id,receiver_id from facebook.messages where "+profile_id+" in (sender_id,receiver_id) and "+profile_id+" in (visible1,visible2) order by timestamp desc");
			while (rs.next())
			{
				if(rs.getInt("receiver_id")==profile_id)
				{
					size = conversation_ids.size();
					for(j=0;j<size;j++)
					{
						if(conversation_ids.get(j)==rs.getInt("sender_id"))
						{
							flag=1;
						}
					}
					if(flag==0)
					{
						conversation_ids.add(rs.getInt("sender_id"));  
					}
					flag=0;
				}
				else
				{
					size = conversation_ids.size();
					for(j=0;j<size;j++)
					{
						if(conversation_ids.get(j)==rs.getInt("receiver_id")) // checking if profile if already in the list.
						{
							flag=1;
						}
					}
					if(flag==0)
					{
						conversation_ids.add(rs.getInt("receiver_id")); 
					}
					flag=0;
				}
			}

			size = conversation_ids.size();
			i=0;
			while(i<size)
			{
				System.out.println(" conv ids"+conversation_ids.get(i));
				i++;
			}

			i=0;
			while(i<size)
			{
				ResultSet rs1 = db.getData("select first_name,last_name,profile_pic,profile_id from facebook.profile where profile_id ="+conversation_ids.get(i)+"");
				while(rs1.next())
				{
					MessageNameList nm1 = new MessageNameList();
					nm1.setFirstname(rs1.getString("first_name"));
					nm1.setLastname(rs1.getString("last_name"));
					nm1.setProfile_pic(rs1.getString("profile_pic"));
					nm1.setProfile_id(rs1.getInt("profile_id"));
					chatlist.add(nm1);

				}
				i++;
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return chatlist;
	}

	public List<MessageNameList> getconversation(int profile_id,int conversation_id)
	{
		System.out.println("in messagepageImpl getconversation()");

		try{
			//makes isread=1 to indicate message is read
			db.updateData(" update facebook.messages set isread=1 where (sender_id="+profile_id+" and receiver_id="+conversation_id+") or  (sender_id="+conversation_id+" and receiver_id="+profile_id+")");
			ResultSet rs2 = db.getData("select message_id,sender_id,message_text,timestamp from facebook.messages where ((sender_id="+profile_id+" and receiver_id="+conversation_id+") or (sender_id="+conversation_id+" and receiver_id="+profile_id+")) and "+profile_id+" in (visible1,visible2)  order by timestamp;");
			while(rs2.next())
			{
				chatting_ids.add(rs2.getInt("sender_id")); 
				chatting.add(rs2.getString("message_text"));
				message_ids.add(rs2.getInt("message_id"));
				times.add(rs2.getString("timestamp").substring(0, 19));
			}

			int i=0,size;
			size = chatting.size();
			while(i<size)
			{

				ResultSet rs3 = db.getData("select first_name,last_name,profile_pic from profile where profile_id = "+chatting_ids.get(i)+" ");
				while(rs3.next())
				{
					MessageNameList nm3 = new MessageNameList();
					nm3.setProfile_id(chatting_ids.get(i));
					nm3.setConversation_body(chatting.get(i));
					nm3.setFirstname(rs3.getString("first_name"));
					nm3.setLastname(rs3.getString("last_name"));
					nm3.setProfile_pic(rs3.getString("profile_pic"));
					nm3.setMessage_id(message_ids.get(i));
					nm3.setTime(times.get(i).replace(".", ":"));
					conversationList.add(nm3);
				}
				i++;
			}


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		return conversationList;
	}

	//On passing the profile id, get the  name of the profile with whom last chat is done 
	public String getFirstChatName(int Profile_id)
	{

		try
		{
			
			/*
			 * Visible1: sender_id
			 * Visible2: receiver_id
			 * initially both have profile-id, if anyone deletes message, then make it 0
			 * While getting first message from db, sort by timestamp and visible1, visible2 should be not 0 
			 * */
			ResultSet rs5 = db.getData("select sender_id,receiver_id from facebook.messages where "+Profile_id+" in (sender_id , receiver_id) and "+Profile_id+" in (visible1,visible2) order by timestamp asc ");
			while(rs5.next())
			{
				if(rs5.getInt("sender_id")==Profile_id)
				{
					firstChatId = rs5.getInt("receiver_id");
				}
				else
					firstChatId = rs5.getInt("sender_id");

			}
			
			//last element in rs5.next() would be firstchatId 
			ResultSet rs6 = db.getData("select first_name,last_name from profile where profile_id ="+firstChatId+"");
			while(rs6.next())
			{
				firstChatName = rs6.getString("first_name")+" "+ rs6.getString("last_name");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("in messagepageImpl getFirstchatname() " +firstChatName);

		return firstChatName;
	}

	//On passing the profile id, get the  id of the profile with whom last chat is done
	public Integer getFirstChatId(int Profile_id)
	{

		try
		{
			ResultSet rs5 = db.getData("select sender_id,receiver_id from facebook.messages where "+Profile_id+" in (sender_id , receiver_id) and "+Profile_id+" in (visible1,visible2)  order by timestamp asc") ;
			while(rs5.next())
			{
				if(rs5.getInt("sender_id")==Profile_id)
				{
					firstChatId = rs5.getInt("receiver_id");
				}
				else
					firstChatId = rs5.getInt("sender_id");

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("in messagepageImpl getFirstChatId() "+firstChatId);

		return firstChatId;
	}
	public int totalUnreadMessages(int profile_id)
	{
		try
		{
			ResultSet rs7 = db.getData("select  count(*) as t from facebook.messages where receiver_id="+profile_id+" and isread=0 ;");
			while(rs7.next())
			{
				unreadmsg = rs7.getInt("t");
				System.out.println(" in impl un = "+ unreadmsg);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return unreadmsg;
	}

	public String getChatPersonName(int conversation_id1)
	{
		System.out.println("in messagepageImpl getchatPrsonName()");

		String name=null;
		try{
			ResultSet rs9 = db.getData("select first_name,last_name from profile where profile_id ="+conversation_id1+"");
			while(rs9.next())
			{
				name = rs9.getString("first_name")+" "+ rs9.getString("last_name");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return name;
	}


	/*
	 * Get names of the friends in the autocomplete 
	 * 
	 * */
	
	public ArrayList<String> getFriendsName(int profile_id)
	{
		ArrayList<String> friendsName = new ArrayList<String>();
		List<Integer> friendsId = new ArrayList<Integer>();
		try{
			ResultSet rs10 = db.getData("select friend_id from friends where profile_id ="+profile_id+"");
			while(rs10.next())
			{
				friendsId.add(rs10.getInt("friend_id"));
			}
			int size = friendsId.size();
			int i=0;
			while(i<size)
			{
				ResultSet rs11 = db.getData("select first_name,last_name from profile where profile_id ="+friendsId.get(i)+"");
				while(rs11.next())
				{
					friendsName.add(rs11.getString("first_name")+" "+rs11.getString("last_name"));
				}
				i++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("In MessagePageImpl friends name are : "+friendsName);
		return friendsName;
	}
	
	public void deleteConversation(int profile_id,int conversation_id)
	{
		System.out.println("in messagepageImpl deleteConvrsatn()");

		try{
			ResultSet rs3 = db.getData("select visible1,visible2,message_id from facebook.messages where (sender_id="+profile_id+" and receiver_id="+conversation_id+") or (sender_id="+conversation_id+" and receiver_id="+profile_id+")");			
			while(rs3.next())
			{
				if(rs3.getInt("visible1")==profile_id)
				{
					if(rs3.getInt("visible2")==0)
					{
						db.updateData("Delete from facebook.messages where message_id ="+rs3.getInt("message_id")+"");	
					}
					else
					{
						db.updateData("update facebook.messages set visible1=0 where message_id="+rs3.getInt("message_id")+"");
					}
				}
				else if(rs3.getInt("visible2")==profile_id)
				{
					if(rs3.getInt("visible1")==0)
					{
						db.updateData("Delete from facebook.messages where message_id ="+rs3.getInt("message_id")+"");	
					}
					else
					{
						db.updateData("update facebook.messages set visible2=0 where message_id="+rs3.getInt("message_id")+"");
					}				
				}				
				
			}			
			//db.updateData("Delete from facebook.messages where (sender_id="+profile_id+" and receiver_id="+conversation_id+") or (sender_id="+conversation_id+" and receiver_id="+profile_id+")");			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteSelectedMessage(int profile_id,int message_id)
	{
		System.out.println("in messagepageImpl deleteSelctdMsgs()");

		try{
			ResultSet rs2=db.getData("select visible1,visible2 from facebook.messages where message_id="+message_id+"");
			while(rs2.next())
			{
				if(rs2.getInt("visible1")==profile_id)
				{
					if(rs2.getInt("visible2")==0)
					{
						db.updateData("Delete from facebook.messages where message_id ="+message_id+"");	
					}
					else
					{
						db.updateData("update facebook.messages set visible1=0 where message_id="+message_id+"");
					}
				}
				else if(rs2.getInt("visible2")==profile_id)
				{
					if(rs2.getInt("visible1")==0)
					{
						db.updateData("Delete from facebook.messages where message_id ="+message_id+"");	
					}
					else
					{
						db.updateData("update facebook.messages set visible2=0 where message_id="+message_id+"");
					}				
				}
			}
			//db.updateData("Delete from facebook.messages where message_id ="+message_id+"");			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
