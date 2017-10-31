package iiitb.fb.actions;

import iiitb.fb.models.Friend;
import iiitb.fb.models.User;
import iiitb.fb.models.impl.PeopleYouMayKnowImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PeopleYouMayKnowAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Map<String, Object> session=ActionContext.getContext().getSession();
	List<Friend> mayKnownPeople=new ArrayList<Friend>();
	
	public String peopleYouMayKnow()
	{
		PeopleYouMayKnowImpl pimpl=new PeopleYouMayKnowImpl();
		User user=(User)session.get("user");
		mayKnownPeople=pimpl.getPeoples(user);
		System.out.println("Inside peopleYouMayKnow ");
		System.out.println(mayKnownPeople.size());
		return SUCCESS;
	}

	
	
	public List<Friend> getMayKnownPeople() {
		return mayKnownPeople;
	}

	public void setMayKnownPeople(List<Friend> mayKnownPeople) {
		this.mayKnownPeople = mayKnownPeople;
	}
	
	
	
	
}
