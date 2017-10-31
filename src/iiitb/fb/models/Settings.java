package iiitb.fb.models;

import java.util.ArrayList;

public class Settings {
	
	
	private String first_name;
	private String last_name;
	private String uname;
	private String email;
	private String password;
	private String sec_email;
	private String language;
	private String viewsetting;
	private String friendreqsetting;
	private String messagesetting;
	private FriendsCat catgname=new FriendsCat();
	private String error="";
		
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public FriendsCat getCatgname() {
		return catgname;
	}
	public void setCatgname(FriendsCat catgname) {
		this.catgname = catgname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSec_email() {
		return sec_email;
	}
	public void setSec_email(String sec_email) {
		this.sec_email = sec_email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getViewsetting() {
		return viewsetting;
	}
	public void setViewsetting(String viewsetting) {
		this.viewsetting = viewsetting;
	}
	public String getFriendreqsetting() {
		return friendreqsetting;
	}
	public void setFriendreqsetting(String friendreqsetting) {
		this.friendreqsetting = friendreqsetting;
	}
	public String getMessagesetting() {
		return messagesetting;
	}
	public void setMessagesetting(String messagesetting) {
		this.messagesetting = messagesetting;
	}
	
	
}
