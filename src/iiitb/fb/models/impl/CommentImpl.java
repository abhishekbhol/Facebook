package iiitb.fb.models.impl;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentImpl {
	
	public boolean commentWallPost(Comment c){
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = dbc.getConnection();
		String query = "insert into comment (comment_id, wallpost_id, profile_id, comment_text, timestamp, visibility)"
				+ " values (default, ?,?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, c.getWallPostId());
			ps.setInt(2, c.getProfileId());
			ps.setString(3, c.getCommentText());
			ps.setString(4, c.getTimestamp());
			ps.setString(5, c.getVisibility());
			
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
