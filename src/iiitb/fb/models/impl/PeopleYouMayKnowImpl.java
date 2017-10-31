package iiitb.fb.models.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Friend;
import iiitb.fb.models.User;

public class PeopleYouMayKnowImpl {

	List<Friend> PeopleList=new ArrayList<Friend>();
	/**
	 * @param user
	 * @return
	 */
	public List<Friend> getPeoples(User user)
	{
		boolean flag=true;
		boolean flag1=true; 
		boolean flag2=true;
		try {
		DatabaseConnect db=new DatabaseConnect();
		/*
		 * Get friends of current user's friends who are not current user's friend and current user has not sent friend request to them
		 * ie Friend of Friend to whom friend request not sent
		 * */
		String query="select profile_id,profile_pic,first_name,last_name from profile p where profile_id in(select f2.friend_id from (select profile_id,friend_id from friends where profile_id="+user.getProfile_id()+") as f1,friends as f2"
				+ " where((f1.friend_id=f2.profile_id) and (f2.friend_id!="+user.getProfile_id()+") and (f2.friend_id not in(select friend_id from friends where profile_id="+user.getProfile_id()+") and  f2.friend_id not in(select request_to from friendrequest where request_from="+user.getProfile_id()+")  )))";
		ResultSet rs=db.getData(query);
	
			while(rs.next())
			{
				Friend f=new Friend();
				f.setFname(rs.getString("first_name"));
				f.setLname(rs.getString("last_name"));
				f.setFriendprofilepic(rs.getString("profile_pic"));
				f.setProfile_id(rs.getInt("profile_id"));
				PeopleList.add(f);
			}
			
		/*
		 * Not user friend and not friend request sent but have the same high school as current user
		 * 
		 * */
		String queryByHighSchool="select profile_id,profile_pic,first_name,last_name from profile where profile_id in(select p1.profile_id from(select p.profile_id from profile as p where (p.high_school='"+user.getHighschool()+"' and p.profile_id!="+user.getProfile_id()+")) as p1 where(p1.profile_id not in(select profile_id from friends where friend_id="+user.getProfile_id()+")and p1.profile_id not in(select request_to from friendrequest where request_from="+user.getProfile_id()+")))";	
			ResultSet rs1=db.getData(queryByHighSchool);
			while(rs1.next())
			{
				for(int i=0;i<PeopleList.size();i++)
				{
					if(PeopleList.get(i).getProfile_id()==(rs1.getInt("profile_id")))
					{
						flag=false;
					}
				}
				if(flag==true)
				{
					Friend f=new Friend();
					f.setFname(rs1.getString("first_name"));
					f.setLname(rs1.getString("last_name"));
					f.setFriendprofilepic(rs1.getString("profile_pic"));
					f.setProfile_id(rs1.getInt("profile_id"));
					PeopleList.add(f);
				}
				flag=true;
			}
			
			/*
			 * Not user friend and not friend request sent but have the same college as current user
			 * 
			 * */
			String queryByCollege="select profile_id,profile_pic,first_name,last_name from profile where profile_id in(select p1.profile_id from(select p.profile_id from profile as p where (p.college='"+user.getCollege()+"' and p.profile_id!="+user.getProfile_id()+")) as p1 where(p1.profile_id not in(select profile_id from friends where friend_id="+user.getProfile_id()+")and p1.profile_id not in(select request_to from friendrequest where request_from="+user.getProfile_id()+")))";	
			ResultSet rs2=db.getData(queryByCollege);
			while(rs2.next())
			{
				for(int i=0;i<PeopleList.size();i++)
				{
					if(PeopleList.get(i).getProfile_id()==(rs2.getInt("profile_id")))
					{
						flag1=false;
						break;
					}
				}
				if(flag1==true)
				{
					Friend f=new Friend();
					f.setFname(rs2.getString("first_name"));
					f.setLname(rs2.getString("last_name"));
					f.setFriendprofilepic(rs2.getString("profile_pic"));
					f.setProfile_id(rs2.getInt("profile_id"));
					PeopleList.add(f);
					
				}
				flag1=true;
			}
			
			/*
			 * Not user friend and not friend request sent but have the same hometown as current user
			 * 
			 * */
			String queryByHometown="select profile_id,profile_pic,first_name,last_name from profile where profile_id in(select p1.profile_id from(select p.profile_id from profile as p where (p.hometown='"+user.getHometown()+"' and p.profile_id!="+user.getProfile_id()+")) as p1 where(p1.profile_id not in(select profile_id from friends where friend_id="+user.getProfile_id()+")and p1.profile_id not in(select request_to from friendrequest where request_from="+user.getProfile_id()+")))";
			ResultSet rs3=db.getData(queryByHometown);
			while(rs3.next())
			{
				for(int i=0;i<PeopleList.size();i++)
				{
					if(PeopleList.get(i).getProfile_id()==(rs3.getInt("profile_id")))
					{
						flag2=false;
						break;
					}
				}
				if(flag2==true)
				{
					Friend f=new Friend();
					f.setFname(rs3.getString("first_name"));
					f.setLname(rs3.getString("last_name"));
					f.setFriendprofilepic(rs3.getString("profile_pic"));
					f.setProfile_id(rs3.getInt("profile_id"));
					PeopleList.add(f);
					
				}
				flag2=true;
			}
			
			
			
			
			System.out.println(PeopleList.size());
			return PeopleList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PeopleList;
	}
	
}
