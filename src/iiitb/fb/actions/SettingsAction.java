package iiitb.fb.actions;

import java.util.Map;

import iiitb.fb.models.*;
import iiitb.fb.models.impl.SettingsImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SettingsAction  extends ActionSupport implements ModelDriven<Settings>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SettingsImpl si = new SettingsImpl();
	Settings s = new Settings();
	String full_name;
	String new_password;
	
	

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public Settings getS() {
		return s;
	}

	public void setS(Settings s) {
		this.s = s;
	}

	

	public String execute()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		
		
		return SUCCESS;
	}
	
	public String getPrivacySetting(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		s = si.getPrivacySettings(profile_id);
		/*for(int i=0;i<s.getCatgname().getCatList().size();i++)
			System.out.println("catg name in action:"+s.getCatgname().getCatList().get(i));*/
		return SUCCESS;
	}
		
	
	public String getGeneralSetting(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		s = si.getGeneralSettings(profile_id);
		System.out.println("in setting action first name is " +s.getFirst_name());
		System.out.println("in setting action email is " +s.getEmail());
		System.out.println("in setting action upass is " +s.getPassword());
		System.out.println("in setting action uname is " +s.getUname());		
		return SUCCESS;
	}
	
	
	public String updateViewSetting()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		
		si.updateViewSetting(profile_id, s.getViewsetting());
		return SUCCESS;
	}
	
	public String updateFriendreqSetting()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		
		si.updateFriendreqSetting(profile_id, s.getFriendreqsetting());
		return SUCCESS;
	}
	
	
	public String updateMsgSetting()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		
		si.updateMsgSetting(profile_id, s.getMessagesetting());
		return SUCCESS;
	}
	
	
	public String updateName()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		System.out.println("in setting action updateName first name : "+s.getFirst_name());
		System.out.println("in setting action updateName last name : "+s.getLast_name());

		si.updateName(profile_id, s.getFirst_name(), s.getLast_name());
		return SUCCESS;
	}
	
	public String updateUserName()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		//System.out.println("username"+s.getUname());
		String err=si.updateUserName(profile_id, s.getUname());
		s.setError(err);
		System.out.println("error:"+s.getError());
		return SUCCESS;
	}
	
	public String updateEmail()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		
		si.updateEmail(profile_id, s.getSec_email());
	//	System.out.println("after update uname"+s.getUname());
		return SUCCESS;
	}
	
	
	public String removeEmail()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
		
		si.removeEmail(profile_id);
	//	System.out.println("after update uname"+s.getUname());
		return SUCCESS;
	}
	
	
	public String updatePass()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
	
		System.out.println("current pass:"+s.getPassword()+"new: "+new_password);
		String pass=si.updatePass(profile_id, s.getPassword(),new_password);
		s.setPassword(pass);
		System.out.println("pass after update"+pass);
		return SUCCESS;
	}
	
	public String updateLang()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int profile_id = user.getProfile_id();
	
		si.updateLang(profile_id, s.getLanguage());
		return SUCCESS;
	}
	
	
	
	@Override
	public Settings getModel() {
		// TODO Auto-generated method stub
		return s;
	}

}
