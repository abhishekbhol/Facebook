package iiitb.fb.models.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.User;

public class UserImpl{

	public boolean isValidUser(User user)//checking for email duplicacy.
	{
		System.out.println(user.getGender());
		System.out.println(user.getBirthday());
		try {
		DatabaseConnect db=new DatabaseConnect();
		String query="select * from login where email='"+user.getEmail()+"'";
		ResultSet rs=db.getData(query);
			if(!rs.next())
			{
			return true;	
			}
			else
			{
			return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public User addUser(User user)
	{
		String loginid="";
		try {
		DatabaseConnect db=new DatabaseConnect();
		Date joindate=new Date();
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay=ft.parse(user.getBirthday());
		System.out.println(birthDay);
		System.out.println(ft.format(birthDay));
		System.out.println(ft.format(joindate));
		
		String query="insert into login (login_id,email,upass,join_date,uname_changed) values(default,'"+user.getEmail()+"','"+user.getPassword()+"','"+ft.format(joindate)+"',0)";
		db.updateData(query);
		String query1="select login_id from login where email='"+user.getEmail()+"'";
		ResultSet rs=db.getData(query1);
		
			while(rs.next())
			{
				loginid=rs.getString("login_id");	
			}
		String query2="insert into profile(profile_id,login_id,isactive,first_name,last_name,birthday,gender)"+"values(default,'"+loginid+"',1,'"+user.getFname()+"','"+user.getLname()+"','"+ft.format(birthDay)+"','"+user.getGender()+"')";	
		db.updateData(query2);
		
		String queryforpid="select profile_id from profile where login_id="+loginid;
		rs=db.getData(queryforpid);
			while(rs.next())
			{
				user.setProfile_id(rs.getInt("profile_id"));
			}
			
					
		return user;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public void addProfileInfo(User user)
	{
		String loginid="";
		try {
			DatabaseConnect db=new DatabaseConnect();
			String query="select login_id from login where email='"+user.getEmail()+"'";
			ResultSet rs=db.getData(query);

			while(rs.next())
			{
				loginid=rs.getString("login_id");	
			}
			int log_id=Integer.parseInt(loginid);
			
		//	String query1="insert into profile(hometown,current_city,high_school,college,company_name)"+"values('"+user.getHometown()+"','"+user.getCurrentcity()+"','"+user.getHighschool()+"','"+user.getCollege()+"','"+user.getCompanyname()+"') where login_id='"+log_id+"'";
			String query1="update profile set hometown='"+user.getHometown()+"',current_city='"+user.getCurrentcity()+"',high_school='"+user.getHighschool()+"',college='"+user.getCollege()+"',company_name='"+user.getCompanyname()+"' where login_id="+log_id;
			db.updateData(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User loginCheck(User user)
	{
		try {
		String userpassword="";
		DatabaseConnect db=new DatabaseConnect();
		String query="select upass  from login where email='"+user.getUserName()+"'or uname='"+user.getUserName()+"'";
		ResultSet rs=db.getData(query);
		
			while(rs.next())
			{
				userpassword=rs.getString("upass");
			}
			if(userpassword.equals(user.getPassword()))
			{
				//Retrieve and set all values for the user
				String q="select profile_id,first_name,last_name,profile_pic,high_school,college,company_name from profile where login_id=(select login_id from login where email='"+user.getUserName()+"'or uname='"+user.getUserName()+"' )";
				ResultSet rs1=db.getData(q);
				while(rs1.next())
				{
				user.setProfile_id(rs1.getInt("profile.profile_id"));
				user.setFname(rs1.getString("profile.first_name"));
				user.setLname(rs1.getString("profile.last_name"));
				user.setProfilePic(rs1.getString("profile.profile_pic"));
				user.setHighschool(rs1.getString("high_school"));
				user.setCollege(rs1.getString("college"));
				user.setCompanyname(rs1.getString("company_name"));
				}
				return user;
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void addProfilepic(User user , String path)
	{
			DatabaseConnect db=new DatabaseConnect();
			String query1="update profile set profile_pic='"+path+"' where profile_id='"+user.getProfile_id()+"'";
			db.updateData(query1);
	}
	
	public void addBirthDayEvent(User user)
	{
		try {
		DatabaseConnect db=new DatabaseConnect();
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay;
		
			birthDay = ft.parse(user.getBirthday());
			System.out.println(birthDay);
			System.out.println(ft.format(birthDay));
			// For storing 1 day before in event table.
			Calendar cal = Calendar.getInstance();
			cal.setTime ( birthDay ); // convert your date to Calendar object
			int daysToDecrement = -1;
			cal.add(Calendar.DATE, daysToDecrement);
			Date beforedate = cal.getTime();
			
			
			int daysToIncrement = 2;
			cal.add(Calendar.DATE, daysToIncrement);
			Date afterDate = cal.getTime();
			
			System.out.println(birthDay);
			System.out.println(beforedate);
			System.out.println(afterDate);
			
			Connection conn = DatabaseConnect.getConnection();
			String query = "insert into event values(default,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps;
			
				ps = conn.prepareStatement(query);
			
			ps.setInt(1, user.getProfile_id());
			ps.setString(2, "Birthday");
			ps.setString(3, "Birthday");
			ps.setString(4, "Birthday");
			ps.setString(5, user.getBirthday());
			ps.setString(6, ft.format(beforedate));
			ps.setString(7, ft.format(afterDate));
			ps.setString(8, "/Faceboook/asset/images/new");
			ps.setInt(9, 1);
			db.updateData(ps);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public void addSettings(User user)
	{
		DatabaseConnect db= new DatabaseConnect();
		String query="insert into settings values(default,"+user.getProfile_id()+",'Public','Public','Public')";
		db.updateData(query);
	}
	
	//populating initial time stamp.
	public void addNotificationClicked(User user)
	{
		DatabaseConnect db=new DatabaseConnect();
		Date currentDateTime=new Date();
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		System.out.println(ft.format(currentDateTime));
		String query="insert into notifications_clicked values(default,"+user.getProfile_id()+",'"+ft.format(currentDateTime)+"','"+ft.format(currentDateTime)+"','"+ft.format(currentDateTime)+"')";
		db.updateData(query);
	}
	
	//Assign username and password to the user.
	public User assignUserNameAndId(User user )
	{
			DatabaseConnect db= new DatabaseConnect();
			user.setUserName(user.getFname().toLowerCase()+"."+user.getLname().toLowerCase()+user.getProfile_id());
			user.setFbemail(user.getUserName()+"@facebook.com");
			String q1="update login set uname='"+user.getUserName()+"',fb_email='"+user.getFbemail()+"' where email='"+user.getEmail()+"'"; 
			db.updateData(q1);
			return user;
	}
	
	public List<User> getTodaysBirthDay(User user)
	{
		List<User> todayBirthdayList=new ArrayList<User>();
		try {
		DatabaseConnect db=new DatabaseConnect();
		String query="select profile_id,first_name, last_name,birthday from profile where profile_id in(select profile_id from friends where (profile_id in(select profile_id from profile where (dayofmonth(birthday) =dayofmonth(curdate()) and month(birthday)=month(curdate()))) and friend_id="+user.getProfile_id()+"))";
		ResultSet rs=db.getData(query);
			while(rs.next())
			{
				User u=new User();
				u.setBirthday(rs.getString("birthday"));
				u.setProfile_id(rs.getInt("profile_id"));
				u.setFname(rs.getString("first_name"));
				u.setLname(rs.getString("last_name"));
				todayBirthdayList.add(u);		
			}
			return todayBirthdayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todayBirthdayList;
	}
	
}