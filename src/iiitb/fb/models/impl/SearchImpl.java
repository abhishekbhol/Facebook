package iiitb.fb.models.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Friend;
import iiitb.fb.models.User;

public class SearchImpl {
List<Friend> searchResult=new ArrayList<Friend>();
Map<String, Object> session;
User user;

public List<Friend> searchresult(String name, int profileId)
{
	try {
	DatabaseConnect db=new DatabaseConnect();
	String query="select profile_id,first_name,last_name,profile_pic from profile where first_name like'%"+name+"%' or last_name like'%"+name+"%'";
	ResultSet rs=db.getData(query);
		while(rs.next())
		{
			Friend f=new Friend();
			f.setProfile_id(rs.getInt("profile_id"));
			//isFrnd=isFriend(f.getProfile_id());
			f.setIsFriend(isFriend(f.getProfile_id(), profileId));
			f.setFname(rs.getString("first_name"));
			f.setLname(rs.getString("last_name"));
			f.setFriendprofilepic(rs.getString("profile_pic"));
			searchResult.add(f);
		}
		return searchResult;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	return searchResult;
}
	

public int isFriend(int friendProfileId, int profileId)
{
	//if isFriend=0---not friend, 1--friend, 2---friend request sent, 3---if current profile and profile id is same
	int isFriend=0;
	try {
	DatabaseConnect db=new DatabaseConnect();
	String query="select * from friends where friend_id="+friendProfileId+" and profile_id="+profileId;
	ResultSet rs=db.getData(query);
		if(rs.next())
		{
			isFriend=1;
		}
		else
		{
			String query1="select * from friendrequest where (request_from="+profileId+" and request_to="+friendProfileId+")";
			ResultSet rs1=db.getData(query1);
			if(rs1.next())
			{
				isFriend=2;
			}
			else
			{
				isFriend=0;
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(isFriend);
	return isFriend;
}
}
