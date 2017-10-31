package iiitb.fb.models.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.opensymphony.xwork2.ActionContext;

import iiitb.fb.database.*;
import iiitb.fb.models.*;

public class SettingsImpl {

	Settings s = new Settings();
	DatabaseConnect db = new DatabaseConnect();
	FriendsCat catg=new FriendsCat();
	ArrayList<String> frndcat= new ArrayList();
	
	


	public Settings getS() {
		return s;
	}

	public void setS(Settings s) {
		this.s = s;
	}

	public Settings getGeneralSettings(int profile_id)
	{
		int login_id = profile_id;
		try{
			ResultSet rs1 = db.getData("select first_name,last_name from facebook.profile where profile_id ="+profile_id+"");
			while(rs1.next())
			{
				s.setFirst_name(rs1.getString("first_name"));
				s.setLast_name(rs1.getString("last_name"));
			}
			
			ResultSet rs2 = db.getData("select sec_email, email,uname,upass from facebook.login where login_id ="+login_id+"");
			while(rs2.next())
			{
				s.setSec_email(rs2.getString("sec_email"));
				s.setEmail(rs2.getString("email"));
				s.setPassword(rs2.getString("upass"));
				s.setUname(rs2.getString("uname"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
	

	
	public Settings getPrivacySettings(int profile_id)
	{
		try{
			ResultSet rs3 = db.getData("select viewsetting,friendreqsetting,messagesetting from facebook.settings where profile_id ="+profile_id+"");
			while(rs3.next())
			{
				s.setViewsetting(rs3.getString("viewsetting"));
				s.setFriendreqsetting(rs3.getString("friendreqsetting"));
				s.setMessagesetting(rs3.getString("messagesetting"));
			}
			//ResultSet rs = db.getData("select cat_name from facebook.friendscat where profile_id ="+profile_id+"");
			frndcat.add("Public");
			frndcat.add("Friends");
			//frndcat.add("Only Me");
			
/*			while(rs.next())
			{	System.out.println("categry:"+rs.getString("cat_name"));
				frndcat.add(rs.getString("cat_name"));
			}*/
			
			catg.setCatList(frndcat);
			s.setCatgname(catg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return s;
	}
	

	
	public boolean updateViewSetting(int profile_id,String viewsetting)
	{
		try{
			db.updateData(" update facebook.settings set viewsetting ='"+viewsetting+"'");
			db.updateData("update wallpost set visibility ='"+viewsetting+"' where post_to="+profile_id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return true;
	}
	
	
	public boolean updateFriendreqSetting(int profile_id,String setting)
	{
		try{
			db.updateData(" update facebook.settings set friendreqsetting ='"+setting+"'");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return true;
	}
	
	
	public boolean updateMsgSetting(int profile_id,String msgsetting)
	{
		try{
			db.updateData(" update facebook.settings set messagesetting ='"+msgsetting+"'");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		return true;
	}
	
	
	public boolean updateName(int profile_id,String newFirstName,String newLastName)
	{
		
		try{
			db.updateData("update facebook.profile set first_name='"+newFirstName+"',last_name='"+newLastName+"' where profile_id ="+profile_id+"   ");
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	public String updateUserName(int profile_id,String newuname)
	{
		int flag=0;
		String uname="";
		String error="";
		try{
			ResultSet rs3 = db.getData("select uname,uname_changed from facebook.login where login_id= "+profile_id+" ");
			while(rs3.next()){
		     flag=rs3.getInt("uname_changed");
			 uname=rs3.getString("uname");
			}
			 
			if(flag!=0){
				error="You have already changed your username earlier!!";
				return error;
			}
				
			ResultSet rs = db.getData("select uname from facebook.login");
			while(rs.next()){
				String name=rs.getString("uname");
				System.out.println("name:"+name+"uname:"+uname);
				if(newuname.equalsIgnoreCase(uname))
				{
					
					error="Username already exist!!!";
					return error;
				}
			}
			
			
			if(flag==0 && error.isEmpty())
			db.updateData("update facebook.login set uname='"+newuname+"',uname_changed="+1+",fb_email='"+newuname+"@facebook.com' where login_id ="+profile_id+"   ");
			else
				return error;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return error;
	}
	
	
	public boolean updateEmail(int profile_id,String Email)
	{
		
		try{
			db.updateData("update facebook.login set sec_email='"+Email+"' where login_id ="+profile_id+"   ");
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean removeEmail(int profile_id)
	{
		
		try{
			db.updateData("update facebook.login set sec_email='' where login_id ="+profile_id+"   ");
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	public String updatePass(int profile_id,String currPass,String newPass)
	{
	
		String pass="";
		try{
			ResultSet rs3 = db.getData("select upass from facebook.login where login_id= "+profile_id+" ");
			while(rs3.next()){
			 pass=rs3.getString("upass");
			}
			
			if(pass.equals(currPass))
			db.updateData("update facebook.login set upass='"+newPass+"' where login_id ="+profile_id+"   ");
			else
				return pass;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return newPass;
	}
	
	
	public boolean updateLang(int profile_id, String language)
	{
		
		try{
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	
}
