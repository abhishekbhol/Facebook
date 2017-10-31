package iiitb.fb.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iiitb.fb.models.User;
import iiitb.fb.models.impl.UserImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BirthdayNotAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, Object> session=ActionContext.getContext().getSession();
	private int birthDayCount;
	List<User> todayBirthdayList =new ArrayList<User>();
	
	public String getTodaysBirthday()
	{
		UserImpl uimpl=new UserImpl();
		User user =new User();
		user=(User)session.get("user");
		todayBirthdayList=uimpl.getTodaysBirthDay(user);
		birthDayCount=todayBirthdayList.size();
		System.out.println("GOt Todays BirthDay.="+birthDayCount);
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getBirthDayCount() {
		return birthDayCount;
	}

	public void setBirthDayCount(int birthDayCount) {
		this.birthDayCount = birthDayCount;
	}

	public List<User> getTodayBirthdayList() {
		return todayBirthdayList;
	}

	public void setTodayBirthdayList(List<User> todayBirthdayList) {
		this.todayBirthdayList = todayBirthdayList;
	}
	
	
	
	
}
