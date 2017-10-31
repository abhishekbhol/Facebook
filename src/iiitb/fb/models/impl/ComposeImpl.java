package iiitb.fb.models.impl;

import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import iiitb.fb.models.*;
import iiitb.fb.database.*;

public class ComposeImpl {
	boolean res= false;
	
	Profile p = new Profile();

	public boolean sendMessage(Message m)
	{
		System.out.println("in composeimpl sendmessage()");

		String firstname;
		String lastname;
		List<String> name = new ArrayList<String>();
		
		StringTokenizer st = new StringTokenizer(m.getReceiver_name());
		while(st.hasMoreElements())
		{
			name.add(st.nextToken());
		}
		int size;
		size = name.size();
		firstname = name.get(0);
		lastname =  name.get(size-1);
		try
		{
			DatabaseConnect db = new DatabaseConnect();

			ResultSet rs = db.getData("select profile_id from profile where first_name = '"+firstname +"'and last_name = '"+lastname +"'");
			while(rs.next())
			{
				m.setReceiver_id(rs.getInt("profile_id"));
				System.out.println(" receiver id = "+ m.getReceiver_id());
				m.setVisible2(rs.getInt("profile_id"));

			}
			db.updateData("INSERT into messages(sender_id,receiver_id,message_text,isread,timestamp,visible1,visible2) VALUES("+m.getSender_id()+","+m.getReceiver_id()+",'"+m.getMessage_body()+"',"+m.getIsRead()+",'"+m.getTimestamp()+"',"+m.getVisible1()+","+m.getVisible2()+") ");
		res=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public boolean sendReply(Message m)
	{
		System.out.println("in composeimpl sendreply()");

		try
		{
			DatabaseConnect db = new DatabaseConnect();
			db.updateData("INSERT into messages(sender_id,receiver_id,message_text,isread,timestamp,visible1,visible2) VALUES("+m.getSender_id()+","+m.getReceiver_id()+",'"+m.getMessage_body()+"',"+m.getIsRead()+",'"+m.getTimestamp()+"',"+m.getVisible1()+","+m.getVisible2()+") ");
			res = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return res;
	}

	public Profile getProfileInfo(int profile_id)
	{
		System.out.println("in composeimpl getprofileinfo()");

		DatabaseConnect db = new DatabaseConnect();
		try{
			ResultSet rs1 = db.getData("select first_name,last_name,profile_pic from profile where profile_id = "+profile_id+" ");
			while(rs1.next())
			{
				p.setFirstName(rs1.getString("first_name"));
				p.setLastName(rs1.getString("last_name"));
				p.setProfilePic(rs1.getString("profile_pic"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		return p;
	}
}
