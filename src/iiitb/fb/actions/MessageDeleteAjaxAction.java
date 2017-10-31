package iiitb.fb.actions;

import iiitb.fb.models.MessageNameList;
import iiitb.fb.models.User;
import iiitb.fb.models.impl.MessagePageImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class MessageDeleteAjaxAction {
	
	String message_ids;
	int conversation_id;
	List<MessageNameList> conversation = null;
	List<MessageNameList> namelist = null;
	MessagePageImpl mp = new MessagePageImpl();
	String name;
	int id;
	
	
	
	public List<MessageNameList> getNamelist() {
		return namelist;
	}

	public void setNamelist(List<MessageNameList> namelist) {
		this.namelist = namelist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage_ids() {
		return message_ids;
	}

	public void setMessage_ids(String message_ids) {
		this.message_ids = message_ids;
	}

	public int getConversation_id() {
		return conversation_id;
	}

	public List<MessageNameList> getConversation() {
		return conversation;
	}

	public void setConversation(List<MessageNameList> conversation) {
		this.conversation = conversation;
	}

	public void setConversation_id(int conversation_id) {
		this.conversation_id = conversation_id;
	}
	
	public String deletemessagebutton()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		int profile_id = user.getProfile_id();
		
		conversation = new ArrayList<MessageNameList>();
		conversation = mp.getconversation(profile_id, conversation_id);
		id=conversation_id;
		return "success";
	}
	
	public String deletemessages()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		int profile_id = user.getProfile_id();
		
		//Array is sent from ajax as "," separated list
		String[] messageId = message_ids.split(",");
		//System.out.println("message length"+messageId.length);
		
		int i=0;
		while(i<messageId.length)
		{
			mp.deleteSelectedMessage(profile_id,Integer.parseInt(messageId[i]));
			i++;
		}
		
		conversation = new ArrayList<MessageNameList>();
		conversation = mp.getconversation(profile_id, conversation_id);
		id=conversation_id;
		return "success";
	}
	
	public String canceldeletemessages()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		int profile_id = user.getProfile_id();
		
		conversation = new ArrayList<MessageNameList>();
		conversation = mp.getconversation(profile_id, conversation_id);
		
		namelist = new ArrayList<MessageNameList>();
		namelist=mp.getnames(profile_id);
		
		name = mp.getChatPersonName(conversation_id);
		id = conversation_id;
		return "success";
	}

	
}
