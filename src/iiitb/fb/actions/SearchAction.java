package iiitb.fb.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iiitb.fb.models.Friend;
import iiitb.fb.models.User;
import iiitb.fb.models.impl.SearchImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private List<Friend> searchResult=new ArrayList<Friend>();
	
	public String search()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		SearchImpl simpl=new SearchImpl();
		searchResult=simpl.searchresult(name,user.getProfile_id());
		System.out.println(name);
		
		for(int i=0;i<searchResult.size();i++)
		{
		System.out.println(searchResult.get(i).getFname());
		System.out.println(searchResult.get(i).getLname());
		System.out.println(searchResult.get(i).getFriendprofilepic());
		System.out.println(searchResult.get(i).getProfile_id());
		}
		return SUCCESS;
	}


	public List<Friend> getSearchResult() {
		return searchResult;
	}


	public void setSearchResult(List<Friend> searchResult) {
		this.searchResult = searchResult;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
