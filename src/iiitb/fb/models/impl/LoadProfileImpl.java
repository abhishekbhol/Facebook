package iiitb.fb.models.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.User;

public class LoadProfileImpl {

	User user=new User();
	/**
	 * @param pid
	 * @return
	 */
	public User getUser(int pid)
	{ 
		try {
			DatabaseConnect db=new DatabaseConnect();
			String query="select * from profile where profile_id ="+pid;
			ResultSet rs=db.getData(query);

			while(rs.next())
			{
				user.setBirthday(rs.getString("birthday"));
				user.setCollege(rs.getString("college"));
				user.setCompanyname(rs.getString("company_name"));
				user.setCurrentcity(rs.getString("current_city"));
				user.setFname(rs.getString("first_name"));
				user.setGender(rs.getString("gender"));
				user.setHighschool(rs.getString("high_school"));
				user.setHometown(rs.getString("hometown"));
				user.setLname(rs.getString("last_name"));
				user.setProfile_id(rs.getInt("profile_id"));
				user.setProfilePic(rs.getString("profile_pic"));
				user.setCoverpicFileName(rs.getString("cover_pic"));
			}

			String query1="select * from login where login_id=(select login_id from profile where profile_id="+pid+" )";
			ResultSet rs1=db.getData(query1);
			while(rs1.next())
			{
				user.setEmail(rs1.getString("email"));
				user.setFbemail(rs1.getString("fb_email"));
				user.setUserName(rs1.getString("uname"));
			}
			System.out.println("i am here");
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	public int isFriend(int currentProfileId, int profile_id) {
		// TODO Auto-generated method stub
		if(currentProfileId == profile_id){
			return 3;
		}
		try {
			DatabaseConnect dbc = new DatabaseConnect();

			String query = "select * from friends where profile_id="+profile_id+" and friend_id="+currentProfileId;
			ResultSet rs = dbc.getData(query);
			if(rs.next())
			{
				return 1;
			}
			else
			{
				String query1="select * from friendrequest where request_from="+profile_id+" and request_to="+currentProfileId;
				ResultSet rs1=dbc.getData(query1);

				if(rs1.next())
				{
					return 2;
				}
				else
				{
					return 0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public int canSendFriendRequest(int currentProfileId, int profile_id) {
		// TODO Auto-generated method stub


		DatabaseConnect dbc = new DatabaseConnect();
		String query1 = "select * from settings where profile_id="+profile_id;
		ResultSet settingSet = dbc.getData(query1);
		try {
			while(settingSet.next()){

				if(settingSet.getString("friendreqsetting").equalsIgnoreCase("Public")){
					return 1;
				}else{

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		String query = "SELECT f2.friend_id FROM facebook.friends f1, facebook.friends f2 where (f1.friend_id=f2.profile_id and f1.profile_id=? and f2.friend_id!=?)";
		Connection connection = DatabaseConnect.getConnection();

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, profile_id);
			ps.setInt(2, profile_id);
			ResultSet rs = dbc.getData(ps);
			while(rs.next()){
				if(currentProfileId == rs.getInt("friend_id")){
					return 1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}



}
