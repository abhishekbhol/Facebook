package iiitb.fb.models.impl;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Like;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//
public class LikeImpl {
	
	public boolean likeWallPost(Like l){
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = dbc.getConnection();
		String query = "insert into likes (like_id, wallpost_id, timestamp, profile_id)"
				+ " values (default, ?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, l.getWallPostId());
			ps.setString(2, l.getTimestamp());
			ps.setInt(3, l.getProfileId());
			
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean unlikeWallPost(Like l) {
		// TODO Auto-generated method stub
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = dbc.getConnection();
		
		String query = "delete from likes where wallpost_id=? and profile_id=?";
		
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, l.getWallPostId());
			ps.setInt(2, l.getProfileId());
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}

}
