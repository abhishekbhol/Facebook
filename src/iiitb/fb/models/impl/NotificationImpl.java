package iiitb.fb.models.impl;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Notification;
import iiitb.fb.models.UserWallPost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;


public class NotificationImpl {
	String lastRead = "2014-03-29 00:00:00";
	
	public int friendRequestCount(int profileId){
		
		int cnt = 0;
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		
		String query = "select count(f.friendrequest_id) as cnt from friendrequest f,notifications_clicked nc where (f.request_to=? and nc.profile_id=? and f.timestamp>=nc.friendrequest)";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, profileId);
			ps.setInt(2, profileId);
			ResultSet rs = dbc.getData(ps);
			while(rs.next()){
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	public int messagesCount(int profileId){
		int cnt = 0;
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		String query="select count(m.message_id) as cnt from messages m,notifications_clicked nc where (m.receiver_id=? and nc.profile_id=? and m.timestamp>nc.messages)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, profileId);
			ps.setInt(2, profileId);
			ResultSet rs = dbc.getData(ps);
			while(rs.next()){
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	
	public List<Notification> loadNotifications(int profileId){
		
		setLastRead(profileId);
		List<Notification> notificationsList = new ArrayList<Notification>();
		
		notificationsList.addAll(getLikesNotifications(profileId));
		notificationsList.addAll(getCommentsNotification(profileId));
		notificationsList.addAll(getPokes(profileId));
		notificationsList.addAll(getAcceptedFriendRequests(profileId));

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Collections.sort(notificationsList, new Comparator<Notification>() {

			@Override
			public int compare(Notification n1, Notification n2) {
				// TODO Auto-generated method stub

				try {
					return sdf.parse(n1.getTimestamp()).compareTo(sdf.parse(n2.getTimestamp()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return 0;
				}
			}

		});
		Collections.reverse(notificationsList);
		return notificationsList;
	}

	private void setLastRead(int profileId){
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		
		String query = "select notification from notifications_clicked where profile_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, profileId);
			ResultSet rs = dbc.getData(ps);
			while(rs.next()){
				lastRead = rs.getString("notification");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	//helper function to get likes
	private List<Notification> getLikesNotifications(int profileId){
		List<Notification> likesNotificationsList = new ArrayList<Notification>();
		DatabaseConnect dbc = new DatabaseConnect();
		//retrive the last read from notifications table 
		Connection connection = DatabaseConnect.getConnection();
		//get all the likes and their corresponding wallpost_id and profile details of the users who have liked it
		String query = "select p.first_name,p.last_name,p.profile_id,p.profile_pic,temp.wallpost_id,temp.timestamp from"
				+ " (select w.wallpost_id,l.profile_id,l.timestamp from wallpost w, likes l where (w.post_from=? or w.post_to=?) and w.wallpost_id=l.wallpost_id and l.profile_id!=? and l.timestamp>? order by l.timestamp desc) as temp, profile p"
				+ " where temp.profile_id=p.profile_id order by wallpost_id,timestamp desc;";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, profileId);
			ps.setInt(2, profileId);
			ps.setInt(3, profileId);

			ps.setString(4, lastRead);
			// list flag to check when to add notitification to the list
			ResultSet rs = dbc.getData(ps);
			if(rs.isBeforeFirst()){
				Notification n = null;
				int currentWallpost=0, listFlag=0;
				while(rs.next()){
					if(currentWallpost != rs.getInt("wallpost_id")){
						if(listFlag == 1){
							n.setNotificationText(n.getNotificationText()+" likes your wallpost");
							likesNotificationsList.add(n);
						}
						listFlag = 1;
						currentWallpost = rs.getInt("wallpost_id");
						n = new Notification();
						n.setNotificationType("Likes");
						n.setTimestamp(rs.getString("timestamp"));
						n.setPicture(rs.getString("profile_pic"));
						n.setUniqueId(currentWallpost);
						n.setNotificationText(new String());
					}

					n.setNotificationText(n.getNotificationText()+rs.getString("first_name")+" "+rs.getString("last_name")+",");
				}
				//to add last notification
				n.setNotificationText(n.getNotificationText()+" likes your wallpost");

				likesNotificationsList.add(n);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return likesNotificationsList;
	}

	//helper function to get comments
	private List<Notification> getCommentsNotification(int profileId){
		List<Notification> commentsNotificationsList = new ArrayList<Notification>();
		DatabaseConnect dbc = new DatabaseConnect();
		//retrive the last read from notifications table 
		Connection connection = DatabaseConnect.getConnection();
		String query = "select p.first_name,p.last_name,p.profile_id,p.profile_pic,temp.wallpost_id,temp.timestamp from"
				+ " (select w.wallpost_id,c.profile_id,c.timestamp from wallpost w, comment c where (w.post_from=? or w.post_to=?) and w.wallpost_id=c.wallpost_id and c.profile_id!=? and c.timestamp>? order by c.timestamp desc) as temp, profile p"
				+ " where temp.profile_id=p.profile_id order by wallpost_id,timestamp desc;";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, profileId);
			ps.setInt(2, profileId);
			ps.setInt(3, profileId);

			ps.setString(4, lastRead);

			ResultSet rs = dbc.getData(ps);
			if(rs.isBeforeFirst()){
				Notification n = null;
				int currentWallpost=0, listFlag=0,lastCommented=0;
				while(rs.next()){

					if(currentWallpost != rs.getInt("wallpost_id")){
						if(listFlag == 1){
							n.setNotificationText(n.getNotificationText()+" commented on your wallpost");
							commentsNotificationsList.add(n);
						}
						listFlag = 1;
						currentWallpost = rs.getInt("wallpost_id");
						n = new Notification();
						n.setNotificationType("Comment");
						n.setTimestamp(rs.getString("timestamp"));
						n.setPicture(rs.getString("profile_pic"));
						n.setUniqueId(currentWallpost);
						n.setNotificationText(new String());
					}
					System.out.println(rs.getString("first_name")+rs.getString("last_name"));
					if(lastCommented != rs.getInt("profile_id")){
						n.setNotificationText(n.getNotificationText()+rs.getString("first_name")+" "+rs.getString("last_name")+",");
						lastCommented = rs.getInt("profile_id");

					}
				}
				n.setNotificationText(n.getNotificationText()+" commented on your wallpost");

				commentsNotificationsList.add(n);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return commentsNotificationsList;
	}

	//helper function to get accepted friend requests
	private List<Notification> getAcceptedFriendRequests(int profileId) {
		// TODO Auto-generated method stub
		List<Notification> friendsNotificationsList = new ArrayList<Notification>();
		DatabaseConnect dbc = new DatabaseConnect();
		//retrive the last read from notifications table 
		Connection connection = DatabaseConnect.getConnection();
		String query = "select p.profile_id,p.first_name,p.last_name,p.profile_pic,f.timestamp from friends f, profile p where"
				+ " f.profile_id=? and f.friend_id=p.profile_id and f.timestamp>? order by f.timestamp desc";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, profileId);
			ps.setString(2, lastRead);

			ResultSet rs = dbc.getData(ps);

			while(rs.next()){
				Notification n = new Notification();
				n.setNotificationType("Friends");
				n.setTimestamp(rs.getString("timestamp"));
				n.setPicture(rs.getString("profile_pic"));
				n.setUniqueId(rs.getInt("profile_id"));
				n.setNotificationText("You and "+rs.getString("first_name")+" "+rs.getString("last_name")+" are now friends");
				friendsNotificationsList.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friendsNotificationsList;
	}
	
	//helper functions to get pokes(have to define)
	private List<Notification> getPokes(int profileId) {
		// TODO Auto-generated method stub
		List<Notification> pokesNotificationList = new ArrayList<Notification>();

		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();

		String query = "select po.*,p.profile_pic,p.first_name,p.last_name,p.profile_id "
				+ "from profile p, poke po where (p.profile_id = po.poke_from and po.poke_to=? and po.timestamp>?)";

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, profileId);
			ps.setString(2, lastRead);
			ResultSet rs = dbc.getData(ps);

			while(rs.next()){
				Notification n = new Notification();
				if(rs.getInt("ispokeback") == 0){
					n.setNotificationText(rs.getString("first_name")+" "+rs.getString("last_name")+" poked you");
					n.setNotificationType("Poke");
					n.setPicture("profile_pic");
					//n.setTimestamp(timestamp);
					n.setUniqueId(rs.getInt("profile_id"));
					pokesNotificationList.add(n);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return pokesNotificationList;
	}



	public List<Notification> loadFriendRequestsNotifications(int profile_id) {
		// TODO Auto-generated method stub
		List<Notification> friendsRequestsList = new ArrayList<Notification>();
		DatabaseConnect dbc = new DatabaseConnect();
		//retrive the last read from notifications table 
		String query = "select p.profile_id,p.profile_pic,p.first_name,p.last_name,fr.timestamp from friendrequest fr, profile p"
				+ " where (fr.request_to=? and fr.request_from=p.profile_id)";
		Connection connection = DatabaseConnect.getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, profile_id);

			ResultSet rs = dbc.getData(ps);

			while(rs.next()){
				Notification n = new Notification();
				n.setNotificationText(rs.getString("first_name")+" "+rs.getString("last_name")+" added you as a friend");
				n.setNotificationType("FriendRequest");
				n.setPicture(rs.getString("profile_pic"));
				n.setTimestamp(rs.getString("timestamp"));
				//unique id here is the person who sent the request
				n.setUniqueId(rs.getInt("profile_id"));
				friendsRequestsList.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return friendsRequestsList;
	}



	public List<Notification> loadMessageNotifications(int profile_id) {
		// TODO Auto-generated method stub
		List<Notification> messageNotificationList = new ArrayList<Notification>();

		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();

		String query = "select p.profile_pic,p.first_name,p.last_name,p.profile_id,m.message_text,m.timestamp,m.message_id"
				+ " from messages m, profile p where (m.sender_id=p.profile_id and m.receiver_id=?) order by m.timestamp desc";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, profile_id);
			ResultSet rs = dbc.getData(ps);
			int cuurentUser = 0;
			while(rs.next()){
				if(cuurentUser != rs.getInt("profile_id")){
					cuurentUser = rs.getInt("profile_id");
					Notification n = new Notification();
					n.setNotificationText(rs.getString("first_name")+" "+rs.getString("last_name")+"<br>&nbsp;&nbsp;"+rs.getString("message_text"));
					n.setNotificationType("Message");
					n.setPicture(rs.getString("profile_pic"));
					n.setTimestamp(rs.getString("timestamp"));
					n.setUniqueId(rs.getInt("message_id"));
					messageNotificationList.add(n);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return messageNotificationList;
	}


	//TO BE SHIFTED TO FRIEND IMPL
	public boolean acceptFriendRequest(int uniqueId, int profile_id) {
		// TODO Auto-generated method stub

		DatabaseConnect dbc = new DatabaseConnect();

		Connection connection = DatabaseConnect.getConnection();
		String query="delete from friendrequest where (request_to=? and request_from=?)";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, profile_id);
			ps.setInt(2, uniqueId);
			dbc.updateData(ps);

			query = "insert into friends values(default, ?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, profile_id);
			ps.setInt(2, uniqueId);
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			dbc.updateData(ps);

			query = "insert into friends values(default, ?,?,?)";
			ps = connection.prepareStatement(query);
			ps.setInt(1, uniqueId);
			ps.setInt(2, profile_id);
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}


	}



	public boolean deleteFriendRequest(int uniqueId, int profile_id) {
		// TODO Auto-generated method stub

		DatabaseConnect dbc = new DatabaseConnect();

		Connection connection = DatabaseConnect.getConnection();
		String query="delete from friendrequest where (request_to=? and request_from=?)";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, profile_id);
			ps.setInt(2, uniqueId);
			dbc.updateData(ps);

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateFriendClickedTimestamp(int profileId) {
		// TODO Auto-generated method stub
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		
		
		String query = "update notifications_clicked set friendrequest=? where profile_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			ps.setInt(2, profileId);
			
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateMessageClickedTimestamp(int profileId) {
		// TODO Auto-generated method stub
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		
		
		String query = "update notifications_clicked set messages=? where profile_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			ps.setInt(2, profileId);
			
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateNotificationClicked(int profileId) {
		// TODO Auto-generated method stub
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = DatabaseConnect.getConnection();
		
		
		String query = "update notifications_clicked set notification=? where profile_id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			ps.setInt(2, profileId);
			
			dbc.updateData(ps);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	}

}
