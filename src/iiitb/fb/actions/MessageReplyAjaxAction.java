package iiitb.fb.actions;

import iiitb.fb.models.Message;
import iiitb.fb.models.MessageNameList;
import iiitb.fb.models.Profile;
import iiitb.fb.models.User;
import iiitb.fb.models.impl.ComposeImpl;
import iiitb.fb.models.impl.MessagePageImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class MessageReplyAjaxAction {
	
	
	Message m=new Message();
	ComposeImpl cm = new ComposeImpl();
	List<MessageNameList> namelist=null ;
	MessagePageImpl mp = new MessagePageImpl();
	
	int conversation_id;
	String conversation_body;
	String firstname;
	String lastname;
	String profile_pic;
	String time;
	
	
	public List<MessageNameList> getNamelist() {
		return namelist;
	}

	public void setNamelist(List<MessageNameList> namelist) {
		this.namelist = namelist;
	}

	public MessagePageImpl getMp() {
		return mp;
	}

	public void setMp(MessagePageImpl mp) {
		this.mp = mp;
	}

	public Message getM() {
		return m;
	}

	public void setM(Message m) {
		this.m = m;
	}

	public ComposeImpl getCm() {
		return cm;
	}

	public void setCm(ComposeImpl cm) {
		this.cm = cm;
	}

	public int getConversation_id() {
		return conversation_id;
	}

	public void setConversation_id(int conversation_id) {
		this.conversation_id = conversation_id;
	}

	public String getConversation_body() {
		return conversation_body;
	}

	public void setConversation_body(String conversation_body) {
		this.conversation_body = conversation_body;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String addConversation()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();

		System.out.println("in ajax new fn conversation_body : "+ conversation_body);
		System.out.println("in ajax new fn conversation_id : "+conversation_id);
		
		m.setMessage_body(conversation_body);
		m.setIsRead(0);
		m.setReceiver_id(conversation_id);
		m.setSender_id(profile_id);
		m.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		m.setVisible1(profile_id);
		m.setVisible2(conversation_id);
		
		if(cm.sendReply(m))
		{
			System.out.println("in ajax fn and message is added to the db");
			Profile p = cm.getProfileInfo(profile_id);
			
			firstname = p.getFirstName();
			lastname = p.getLastName();
			profile_pic = p.getProfilePic();
			time = m.getTimestamp().substring(0, 19).replace(".", ":");
			
		}	
		else
		{
			System.out.println("in ajax fn and message is NOT added to the db");
		}

		namelist= new ArrayList<MessageNameList>();
		namelist = mp.getnames(profile_id);
		
		for(int i=0;i<namelist.size();i++)
		{
		System.out.println("in message delete ajax namelist is "+namelist.get(i).getFirstname());
		}
		return "success";
	}
	
		
}
