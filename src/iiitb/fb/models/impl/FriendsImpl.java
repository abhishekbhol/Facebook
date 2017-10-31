package iiitb.fb.models.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Friend;
import iiitb.fb.models.User;

public class FriendsImpl {
	List<Friend> friendsid=new ArrayList<Friend>();
	
	public List<Friend> allFriends(User user)
	{
		
		try {
		DatabaseConnect db=new DatabaseConnect();
		String query="select p.first_name,p.last_name,f.friend_id,p.profile_pic from profile p left join friends f on p.profile_id = f.friend_id where f.profile_id='"+user.getProfile_id()+"'";
		ResultSet rs=db.getData(query);
		while(rs.next())
			{
			Friend f=new Friend();
			f.setProfile_id(rs.getInt("friend_id"));
			f.setFname(rs.getString("first_name"));
			f.setLname(rs.getString("last_name"));
			f.setFriendprofilepic(rs.getString("profile_pic"));
			friendsid.add(f);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friendsid;
	}
	
	public void sendfriendRequest(int loggedinProfileId,int friendProfileId)
	{
		DatabaseConnect db=new DatabaseConnect();
		Date time=new Date();
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String query="insert into friendrequest values(default,"+friendProfileId+","+loggedinProfileId+",'"+ft.format(time)+"')";
		db.updateData(query);
	}

	public void cancleRequest(int loggedinProfileId,int friendProfileId)
	{
		DatabaseConnect db=new DatabaseConnect();
		String query="delete from friendrequest where (request_to="+friendProfileId+" and request_from="+loggedinProfileId+ ")";
		db.updateData(query);
	}
	
}
