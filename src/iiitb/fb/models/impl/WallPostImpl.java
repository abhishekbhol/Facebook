package iiitb.fb.models.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.UserComment;
import iiitb.fb.models.UserLike;
import iiitb.fb.models.UserWallPost;
import iiitb.fb.models.WallPost;
//
public class WallPostImpl {

	private int profile_id, isLiked;
	public String getPostToName(int profileId){
		DatabaseConnect dbc = new DatabaseConnect();
		String fullName="";
		
		Connection connection = DatabaseConnect.getConnection();
		String query="select first_name,last_name from profile where profile_id=?";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, profileId);
			
			ResultSet rs = dbc.getData(ps);
			
			while(rs.next()){
				fullName = rs.getString("first_name")+" "+rs.getString("last_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fullName;
		
	}
	
	public int addWallPost(WallPost wp){
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query;
		if(wp.getEventId()!=0){
			query = "insert into wallpost (wallpost_id,post_from, post_to, wallpost_text, timestamp, visibility, event_id)"
					+ "values (default, ?,?,?,?,?,?)";
		}else{
			query = "insert into wallpost (wallpost_id,post_from, post_to, wallpost_text, timestamp, visibility)"
					+ "values (default, ?,?,?,?,(select viewsetting from settings where profile_id=?))";
		}
		try {
			PreparedStatement ps = connection.prepareStatement(query);

			ps.setInt(1, wp.getPostFrom());
			ps.setInt(2, wp.getPostTo());
			ps.setString(3, wp.getWallPostText());
			ps.setString(4, wp.getTimestamp());
			ps.setInt(5, wp.getPostTo());
			if(wp.getEventId()!=0){
				ps.setString(5, "Public");
				ps.setInt(6, wp.getEventId());
			}
			dbc.updateData(ps);
			String queryId = "select last_insert_id()";
			ps = connection.prepareStatement(queryId);
			ResultSet rs = dbc.getData(ps);

			int wallPostId=0;
			if(rs.next()){
				wallPostId =  rs.getInt("last_insert_id()");
			}
			return wallPostId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	public boolean deleteWallPost(WallPost wp){
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query = "delete from wallpost where wallpost_id = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, wp.getWallPostId());
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public List<UserWallPost> getWallPosts(int profileId){
		this.profile_id = profileId;
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query = "select * from (select w.*,p.profile_id,p.first_name,p.last_name,p.profile_pic from wallpost w left join profile p on p.profile_id=w.post_from) as temp, friends f"
				+ " where temp.post_from=? or f.profile_id=? and f.friend_id=temp.post_from group by temp.wallpost_id order by temp.timestamp desc";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//remove hardcoding from here
			ps.setInt(1, profileId);
			ps.setInt(2, profileId);

			ResultSet rs = dbc.getData(ps);
			List<UserWallPost> postsList = new ArrayList<UserWallPost>();
			while(rs.next()){
				//ignore the wallposts which are realted to events
				if(rs.getInt("event_id") == 0){
					UserWallPost uwp = new UserWallPost();
					uwp.setWallPostId(rs.getInt("wallpost_id"));
					uwp.setPostFrom(rs.getInt("post_from"));
					uwp.setPostFromName(rs.getString("first_name")+" "+rs.getString("last_name"));
					uwp.setPostFromPicture(rs.getString("profile_pic"));
					uwp.setPostTo(rs.getInt("post_to"));
					uwp.setPostToName(getPostToName(uwp.getPostTo()));
					uwp.setTimestamp(rs.getString("timestamp"));
					uwp.setVisibility(rs.getString("visibility"));
					uwp.setWallPostText(rs.getString("wallpost_text"));
					
					//get likes and comments for each wallpost through function call
					uwp.setCommentsList(getComments(uwp.getWallPostId()));
					uwp.setLikesList(getLikes(uwp.getWallPostId()));
					if(isLiked == 1){
						uwp.setIsLiked(1);
						isLiked = 0;
					}
					postsList.add(uwp);

				}
			}
			return postsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public List<UserWallPost> getUserWallPosts(int loggedInProfileId, int currentProfileId){
		
		String visibility = "";
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();

		String currentSetting = "select * from settings where profile_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(currentSetting);
			ps.setInt(1	, currentProfileId);
	
			ResultSet rs = dbc.getData(ps);
			while(rs.next()){//if this is true then the logged in user is a friend of the current user so visibility to fire on wallpost should be set to Friends
				visibility = rs.getString("viewsetting");
			}
			
			String checkIsFriend = "select * from friends where (profile_id=? and friend_id=?)";
			ps = connection.prepareStatement(checkIsFriend);
			ps.setInt(1, currentProfileId);
			ps.setInt(2, loggedInProfileId);
			rs = dbc.getData(ps);
			if(rs.next()){

			}else{
				visibility = "Public";
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String query = "select temp.*,p.profile_id,p.first_name,p.last_name,p.profile_pic from"
				+ " (select * from wallpost where ((post_from=? and post_to=?) or (post_from!=? and post_to=?)) and visibility = ?) as temp, profile p"
				+ " where (temp.post_from = p.profile_id) order by temp.timestamp desc";

		try {
			ps = connection.prepareStatement(query);
			//remove hardcoding from here
			ps.setInt(1, currentProfileId);
			ps.setInt(2, currentProfileId);
			ps.setInt(3, currentProfileId);
			ps.setInt(4, currentProfileId);
			ps.setString(5, visibility);

			ResultSet rs = dbc.getData(ps);
			List<UserWallPost> postsList = new ArrayList<UserWallPost>();
			while(rs.next()){
				if(rs.getInt("event_id") == 0){
					UserWallPost uwp = new UserWallPost();
					uwp.setWallPostId(rs.getInt("wallpost_id"));
					uwp.setPostFrom(rs.getInt("post_from"));
					uwp.setPostFromName(rs.getString("first_name")+" "+rs.getString("last_name"));
					uwp.setPostFromPicture(rs.getString("profile_pic"));
					uwp.setPostTo(rs.getInt("post_to"));
					uwp.setPostToName(getPostToName(uwp.getPostTo()));
					uwp.setTimestamp(rs.getString("timestamp"));
					uwp.setVisibility(rs.getString("visibility"));
					uwp.setWallPostText(rs.getString("wallpost_text"));
					uwp.setCommentsList(getComments(uwp.getWallPostId()));
					uwp.setLikesList(getLikes(uwp.getWallPostId()));
					if(isLiked == 1){
						uwp.setIsLiked(1);
						isLiked = 0;
					}
					postsList.add(uwp);

				}
			}
			return postsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public UserWallPost getSingleWallPost(int wallPostId){
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query = "select * from wallpost w , profile p where w.wallpost_id=? and w.post_from=p.profile_id";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//remove hardcoding from here
			ps.setInt(1, wallPostId);

			ResultSet rs = dbc.getData(ps);
			UserWallPost uwp = null;
			while(rs.next()){
				uwp = new UserWallPost();
				uwp.setWallPostId(rs.getInt("wallpost_id"));
				uwp.setPostFrom(rs.getInt("post_from"));
				uwp.setPostFromName(rs.getString("first_name")+" "+rs.getString("last_name"));
				uwp.setPostFromPicture(rs.getString("profile_pic"));
				uwp.setPostTo(rs.getInt("post_to"));
				uwp.setTimestamp(rs.getString("timestamp"));
				uwp.setVisibility(rs.getString("visibility"));
				uwp.setWallPostText(rs.getString("wallpost_text"));
				uwp.setCommentsList(getComments(uwp.getWallPostId()));
				uwp.setLikesList(getLikes(uwp.getWallPostId()));

				//to know whether like link to activate or unlike
				if(isLiked == 1){
					uwp.setIsLiked(1);
					isLiked = 0;
				}

			}

			return uwp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public List<UserWallPost> getProfileWallPosts(){
		return null;
	}
	
	
	
	//get wallposts associated with a event
	public List<UserWallPost> getEventWallPosts(int eventId){

		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query =  "select w.*,p.profile_id,p.profile_pic,p.first_name,p.last_name from wallpost w,profile p where"
				+ " w.event_id=? and p.profile_id=w.post_from order by timestamp desc";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//remove hardcoding from here
			ps.setInt(1, eventId);


			ResultSet rs = dbc.getData(ps);
			List<UserWallPost> postsList = new ArrayList<UserWallPost>();
			while(rs.next()){
				UserWallPost uwp = new UserWallPost();
				uwp.setWallPostId(rs.getInt("wallpost_id"));
				uwp.setPostFrom(rs.getInt("post_from"));
				uwp.setPostFromName(rs.getString("first_name")+" "+rs.getString("last_name"));
				uwp.setPostFromPicture(rs.getString("profile_pic"));
				uwp.setPostTo(rs.getInt("post_to"));
				uwp.setTimestamp(rs.getString("timestamp"));
				uwp.setVisibility(rs.getString("visibility"));
				uwp.setWallPostText(rs.getString("wallpost_text"));
				uwp.setCommentsList(getComments(uwp.getWallPostId()));
				uwp.setLikesList(getLikes(uwp.getWallPostId()));
				if(isLiked == 1){
					uwp.setIsLiked(1);
					isLiked = 0;
				}
				postsList.add(uwp);

			}

			return postsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return null;
		}
	}
	
	
	//get all wallposts associated with a friend category
	public List<UserWallPost> getCategoryWallPosts(String categoryName, int profileId){
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query = "select * from (select p.profile_id,p.first_name,p.last_name,p.profile_pic from profile p,friendscat f"
				+ " where f.cat_name=? and f.profile_id=? and f.friends_profile_id=p.profile_id)as temp,wallpost w"
						+ " where temp.profile_id=w.post_from";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			//remove hardcoding from here
			ps.setString(1, categoryName);
			ps.setInt(2, profileId);

			ResultSet rs = dbc.getData(ps);
			List<UserWallPost> postsList = new ArrayList<UserWallPost>();
			while(rs.next()){
				if(rs.getInt("event_id") == 0){
					UserWallPost uwp = new UserWallPost();
					uwp.setWallPostId(rs.getInt("wallpost_id"));
					uwp.setPostFrom(rs.getInt("post_from"));
					uwp.setPostFromName(rs.getString("first_name")+" "+rs.getString("last_name"));
					uwp.setPostFromPicture(rs.getString("profile_pic"));
					uwp.setPostTo(rs.getInt("post_to"));
					uwp.setTimestamp(rs.getString("timestamp"));
					uwp.setVisibility(rs.getString("visibility"));
					uwp.setWallPostText(rs.getString("wallpost_text"));
					uwp.setCommentsList(getComments(uwp.getWallPostId()));
					uwp.setLikesList(getLikes(uwp.getWallPostId()));
					if(isLiked == 1){
						uwp.setIsLiked(1);
						isLiked = 0;
					}
					postsList.add(uwp);

				}
			}
			return postsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	//helper function to get likes of a particular post
	public List<UserLike> getLikes(int wallPostId) {
		// TODO Auto-generated method stub
		boolean isCurrentUser = false;
		List<UserLike> likesList = new ArrayList<UserLike>();
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query = "select * from likes l, profile p where l.wallpost_id = ? and l.profile_id = p.profile_id";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, wallPostId);
			ResultSet rs = dbc.getData(ps);

			while(rs.next()){
				UserLike ul = new UserLike();
				ul.setFullName(rs.getString("first_name")+" "+rs.getString("last_name"));
				ul.setWallPostId(wallPostId);
				ul.setProfileId(rs.getInt("profile_id"));
				ul.setProfilePic(rs.getString("profile_pic"));
				if(ul.getProfileId() == profile_id){
					ul.setIsLiked(1);
					isLiked = 1;
					isCurrentUser = true;
				}
				ul.setTimestamp(rs.getString("timestamp"));
				likesList.add(ul);
				if (isCurrentUser) {
					UserLike temp = likesList.get(0);
					likesList.set(0, likesList.get(likesList.size()-1));
					likesList.remove(likesList.size()-1);
					likesList.add(temp);
					isCurrentUser = false;
				}
			}

			return likesList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}
	//helper function to get comments of a particular posts
	private List<UserComment> getComments(int wallPostId) {
		// TODO Auto-generated method stub
		List<UserComment> commentsList = new ArrayList<UserComment>();
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query = "select * from comment c, profile p where (c.wallpost_id=? and c.profile_id=p.profile_id) order by timestamp asc";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, wallPostId);

			ResultSet rs = dbc.getData(ps);
			while(rs.next()){
				UserComment uc = new UserComment();
				uc.setCommentText(rs.getString("comment_text"));
				uc.setFullName(rs.getString("first_name")+" "+rs.getString("last_name"));
				uc.setProfileId(rs.getInt("profile_id"));
				uc.setProfilePicture(rs.getString("profile_pic"));
				uc.setTimestamp(rs.getString("timestamp"));
				uc.setVisibility(rs.getString("visibility"));
				uc.setWallPostId(wallPostId);
				commentsList.add(uc);
			}

			return commentsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}


}
