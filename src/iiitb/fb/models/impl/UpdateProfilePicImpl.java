package iiitb.fb.models.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import iiitb.fb.database.DatabaseConnect;

public class UpdateProfilePicImpl {

	public boolean updateDatabaseProfilePic(int profile_id) {
		// TODO Auto-generated method stub
		String filePath = "/Facebook/asset/images/profilepics/"+profile_id+".jpg";
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query = "update profile set profile_pic=? where profile_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, filePath);
			ps.setInt(2, profile_id);
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updateDatabaseCoverPic(int profile_id) {
		// TODO Auto-generated method stub
		String filePath = "/Facebook/asset/images/profilepics/"+profile_id+"_cover.jpg";
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query = "update profile set cover_pic=? where profile_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, filePath);
			ps.setInt(2, profile_id);
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
