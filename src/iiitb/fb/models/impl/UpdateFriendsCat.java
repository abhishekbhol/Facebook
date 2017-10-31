package iiitb.fb.models.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.*;

public class UpdateFriendsCat {

	DatabaseConnect dbconnect=new DatabaseConnect();

	//Function to get all the categories of friends
	public boolean	FetchFriendCatList(int pid,FriendsCat obj){
		ArrayList<String> category = new ArrayList<String>();
		ResultSet rs=dbconnect.getData("SELECT DISTINCT cat_name FROM friendscat WHERE PROFILE_ID='"+pid+"'");
		try {
			if(rs.next()){
				category.add(rs.getString("cat_name"));	
				while (rs.next()){
					category.add(rs.getString("cat_name"));
				}
				obj.setCatList(category);
				return true;
			}
			else{
				category.add("Close Friends");
				category.add("Family");
				obj.setCatList(category);
				int i=dbconnect.updateData("INSERT INTO friendscat (cat_name,profile_id,friends_profile_id) VALUES ('Close Friends','"+pid+"','"+pid+"')");
				int j=dbconnect.updateData("INSERT INTO friendscat (cat_name,profile_id,friends_profile_id) VALUES ('Family','"+pid+"','"+pid+"')");
				if(i>0) return true;
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;			
	}

	//Function to get list of profile id belonging to input category
	public void FriendsListInCategory(String category,FriendsListCat obj,int pid){
		ArrayList<Integer> friend = new ArrayList<Integer>();


		ResultSet rs=dbconnect.getData("SELECT friends_profile_id FROM friendscat WHERE PROFILE_ID='"+pid+"'"+"AND CAT_NAME='"+category+"'");

		try {
			if(rs.next()){
				friend.add(rs.getInt("friends_profile_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.setFriendsList(friend);
	}

	//Function to delete a given profile id from a given friend category
	public int deleteFromCategory(int pid,int friendid,String category){
		int val=dbconnect.updateData("DELETE FROM friendscat WHERE PROFILE_ID='"+pid+"'"+"AND CAT_NAME='"+category+"'"+"AND friends_profile_id='"+friendid+"'");
		return val;
	}

	//Function to add a given profile id to a given friend category
	public int addInCategory(int pid,int friendid,String category){
		int val=dbconnect.updateData("INSERT INTO friendscat (cat_name,profile_id,friends_profile_id) VALUES ('"+category+"','"+pid+"','"+friendid+"')");
		return val;

	}

	public boolean addNewCategory(int pid,String name,int array[]){
		boolean flag=true;
		if(!name.isEmpty() && (array!=null))
			for (int i=0;i<array.length;i++)
			{
				int tokenInt=array[i];
				int val=dbconnect.updateData("INSERT INTO friendscat (cat_name,profile_id,friends_profile_id) VALUES ('"+name+"','"+pid+"','"+tokenInt+"')");
				if (val<=0) flag=false;
			}
		return flag;
	}

	
	public boolean deleteCategory(int profile_id,String CatName){
		boolean flag=true;
		int val=dbconnect.updateData("DELETE FROM friendscat WHERE PROFILE_ID='"+profile_id+"'"+"AND CAT_NAME='"+CatName+"'");
		if (val<=0) 
		flag=false;	
		return flag;
	}

	public boolean renameCategory(int profile_id,String newName,String CatName){
		boolean flag=true;
		int val=dbconnect.updateData("UPDATE friendscat SET CAT_NAME='"+newName+"' WHERE PROFILE_ID='"+profile_id+"'"+"AND CAT_NAME='"+CatName+"'");
		if (val<=0) 
		flag=false;	
		return flag;
	}

	public boolean checkInCategory(int profile_id, String category) {
		ResultSet rs=dbconnect.getData("SELECT * FROM friendscat WHERE PROFILE_ID='"+profile_id+"'"+"AND CAT_NAME='"+category+"'");
		try {
			if(rs.next()){
				 return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
