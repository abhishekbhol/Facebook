package iiitb.fb.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iiitb.fb.models.*;
import iiitb.fb.models.impl.MessagePageImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MessagePage extends ActionSupport implements ModelDriven<MessageNameList>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		int i=0,size=0;
	int conversation_id;
	MessageNameList nm = new MessageNameList();
	List<MessageNameList> namelist=null ;
	MessagePageImpl mp = new MessagePageImpl();
	List<MessageNameList> conversation = null;
	String firstMessageName;
	int unreadMessages;
	public ArrayList<String> friendslist;
	public String receiver_name;
	
	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}

	public List<String> getFriendslist() {
		return friendslist;
	}

	public void setFriendslist(ArrayList<String> friendslist) {
		this.friendslist = friendslist;
	}

	public int getConversation_id() {
		return conversation_id;
	}

	public void setConversation_id(int conversation_id) {
		this.conversation_id = conversation_id;
	}

	public int getUnreadMessages() {
		return unreadMessages;
	}

	public void setUnreadMessages(int unreadMessages) {
		this.unreadMessages = unreadMessages;
	}

	public String getFirstMessageName() {
		return firstMessageName;
	}

	public void setFirstMessageName(String firstMessageName) {
		this.firstMessageName = firstMessageName;
	}

	public List<MessageNameList> getConversation() {
		return conversation;
	}

	public void setConversation(List<MessageNameList> conversation) {
		this.conversation = conversation;
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

	public String execute()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();

		firstMessageName = mp.getFirstChatName(profile_id);
		unreadMessages = mp.totalUnreadMessages(profile_id);
		
		friendslist = mp.getFriendsName(profile_id);
		//conversation id is the profile id of the person whom which we are having conversation
		conversation_id = mp.getFirstChatId(profile_id);
		conversation = new ArrayList<MessageNameList>();
		conversation = mp.getconversation(profile_id, conversation_id);
		namelist= new ArrayList<MessageNameList>();
		namelist = mp.getnames(profile_id);
		size = namelist.size();
		
		return SUCCESS;
	}



	public String findConv()
	{

		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();

		namelist= new ArrayList<MessageNameList>();
		namelist = mp.getnames(profile_id);
		conversation = new ArrayList<MessageNameList>();
		System.out.println("conversation id = "+conversation_id);
		conversation = mp.getconversation(profile_id, conversation_id);
		firstMessageName = mp.getChatPersonName(conversation_id);   // name over detailed msgs when user clicks on any name in his msglist
		/*size = conversation.size();
		while(i<size)
		{
			System.out.println(" name , convertation is  "+ conversation.get(i).getFirstname()+" "+ conversation.get(i).getConversation_body());
			i++;
		}*/

		return SUCCESS;
	}

	public String deleteConv()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		namelist= new ArrayList<MessageNameList>();
		System.out.println("conversation id = "+conversation_id);
	
		mp.deleteConversation(profile_id, conversation_id);
	//	System.out.println("monikaId in msg page"+ monikaId);
	//		mp.deleteConversation(profile_id, monikaId);

		firstMessageName = mp.getFirstChatName(profile_id);
		unreadMessages = mp.totalUnreadMessages(profile_id);

		conversation = new ArrayList<MessageNameList>();
		
		namelist = mp.getnames(profile_id);

		conversation_id = mp.getFirstChatId(profile_id);
		conversation = mp.getconversation(profile_id, conversation_id);
		return SUCCESS;
	}

	@Override
	public MessageNameList getModel() {
		// TODO Auto-generated method stub
		return nm;
	}

}
