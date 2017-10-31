package iiitb.fb.actions;


import java.text.DateFormat;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import iiitb.fb.models.*;
import iiitb.fb.models.impl.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Compose extends ActionSupport implements ModelDriven<Message> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Message m=new Message();

	int conversation_id;
	String receiver_fullname;
	MessageNameList nm = new MessageNameList();
	List<MessageNameList> namelist=null ;
	MessagePageImpl mp = new MessagePageImpl();
	List<MessageNameList> conversation = null;
	String firstMessageName;
	int unreadMessages;
	

	public String getReceiver_fullname() {
		return receiver_fullname;
	}

	public void setReceiver_fullname(String receiver_fullname) {
		this.receiver_fullname = receiver_fullname;
	}

	public Message getM() {
		return m;
	}

	public void setM(Message m) {
		this.m = m;
	}

	
	

	public int getConversation_id() {
		return conversation_id;
	}

	public void setConversation_id(int conversation_id) {
		this.conversation_id = conversation_id;
	}

	public MessageNameList getNm() {
		return nm;
	}

	public void setNm(MessageNameList nm) {
		this.nm = nm;
	}

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

	public List<MessageNameList> getConversation() {
		return conversation;
	}

	public void setConversation(List<MessageNameList> conversation) {
		this.conversation = conversation;
	}

	public String getFirstMessageName() {
		return firstMessageName;
	}

	public void setFirstMessageName(String firstMessageName) {
		this.firstMessageName = firstMessageName;
	}

	public int getUnreadMessages() {
		return unreadMessages;
	}

	public void setUnreadMessages(int unreadMessages) {
		this.unreadMessages = unreadMessages;
	}

	
	
	public String sendReplyMsg(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();

		
		m.setReceiver_name(receiver_fullname);
		System.out.println("reply msg conv id"+conversation_id);
		System.out.println("reply msg body"+m.getMessage_body());
		ComposeImpl cm = new ComposeImpl();
		DateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		System.out.println(date.toString());
		m.setIsRead(0);
		m.setSender_id(profile_id);
		m.setTimestamp(dateFormat.format(date));
		m.setReceiver_id(conversation_id);
		m.setVisible1(profile_id);
		m.setVisible2(conversation_id);
		
		if(cm.sendReply(m))
		{
			firstMessageName = mp.getFirstChatName(profile_id);
			unreadMessages = mp.totalUnreadMessages(profile_id);
			
		    conversation = new ArrayList<MessageNameList>();
			namelist= new ArrayList<MessageNameList>();
			namelist = mp.getnames(profile_id);
			
			conversation_id = mp.getFirstChatId(profile_id);
			System.out.println("in reply msg conversation id = "+conversation_id);
			conversation = mp.getconversation(profile_id, conversation_id);
			System.out.println("in reply msg first conv name - "+firstMessageName);
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
		
		
		
	}
	
	
	public String execute()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();

		ComposeImpl cm = new ComposeImpl();
		System.out.println("in compose execute tt receiver fullname :" + receiver_fullname);
		System.out.println("in compose execute tt message body :" + m.getMessage_body());

		
		DateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		System.out.println(date.toString());
		m.setReceiver_name(receiver_fullname);
		m.setIsRead(0);
		m.setSender_id(profile_id);
		m.setTimestamp(dateFormat.format(date));
		m.setVisible1(profile_id);
		
		if(cm.sendMessage(m))
		{
			firstMessageName = mp.getFirstChatName(profile_id);
			unreadMessages = mp.totalUnreadMessages(profile_id);
			
		    conversation = new ArrayList<MessageNameList>();
			namelist= new ArrayList<MessageNameList>();
			namelist = mp.getnames(profile_id);
			
			conversation_id = mp.getFirstChatId(profile_id);
		
			System.out.println("conversation id = "+conversation_id);
			conversation = mp.getconversation(profile_id, conversation_id);
			System.out.println("first conv name - "+firstMessageName);
			System.out.println("total unread msg - "+unreadMessages);
			//System.out.println("monika-id - "+monikaId);
			return SUCCESS;
		}
		else
			return ERROR;
	
	}
	

	@Override
	public Message getModel() {
		// TODO Auto-generated method stub
		return m;
	}

}
