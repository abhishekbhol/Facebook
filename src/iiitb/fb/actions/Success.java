package iiitb.fb.actions;

import iiitb.fb.models.User;
import iiitb.fb.models.impl.UserImpl;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Success extends ActionSupport implements CookiesAware{

	private static final long serialVersionUID = -4193421785406064309L;

	private ArrayList<String> yearList;
	private ArrayList<String> monthList;
	private ArrayList<String> dayList;
	private Map<String, String> cookie;
	private String details;
	private HttpServletRequest request;

	public String execute(){
		//	Cookie[] cooks = request.getCookies();
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(details != null){
			System.out.println(details);
			UserImpl ui = new UserImpl();
			User temp = new User();
			if(!details.equalsIgnoreCase("")){
				System.out.println((cookie.get("details").split(","))[0]+"   &   "+(cookie.get("details").split(","))[1]);
				temp.setUserName(cookie.get("details").split(",")[0]);
				temp.setPassword(cookie.get("details").split(",")[1]);
				User user=ui.loginCheck(temp);
				if(user==null)
				{
					System.out.println();
					yearList = new ArrayList<String>();
					monthList = new ArrayList<String>();
					dayList = new ArrayList<String>();
					for(int i = 2014; i>= 1905; i--){
						String tmp=Integer.toString(i);
						yearList.add(tmp);
					}

					for(int i=1;i<=31;i++)
					{
						String tmp=Integer.toString(i);
						dayList.add(tmp);
					}

					for(int i=1;i<=12;i++)
					{
						String tmp=String.valueOf(i);
						monthList.add(tmp);
					}

					return "homePage";
				}
				else
				{	
					session.put("user", user);
					return SUCCESS;
				}
			}
		}
		yearList = new ArrayList<String>();
		monthList = new ArrayList<String>();
		dayList = new ArrayList<String>();
		for(int i = 2014; i>= 1905; i--){
			String tmp=Integer.toString(i);
			yearList.add(tmp);
		}

		for(int i=1;i<=31;i++)
		{
			String tmp=Integer.toString(i);
			dayList.add(tmp);
		}

		for(int i=1;i<=12;i++)
		{
			String tmp=String.valueOf(i);
			monthList.add(tmp);
		}

		return "homePage";



	}

	public String profile()
	{
		return SUCCESS;
	}

	public String forgotPassword()
	{
		return SUCCESS;
	}



	public ArrayList<String> getMonthList() {
		return monthList;
	}

	public void setMonthList(ArrayList<String> monthList) {
		this.monthList = monthList;
	}

	public ArrayList<String> getDayList() {
		return dayList;
	}

	public void setDayList(ArrayList<String> dayList) {
		this.dayList = dayList;
	}

	public ArrayList<String> getYearList() {
		return yearList;
	}

	public void setYearList(ArrayList<String> yearList) {
		this.yearList = yearList;
	}


	public Map<String, String> getCookie() {
		return cookie;
	}

	public void setCookie(Map<String, String> cookie) {
		this.cookie = cookie;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setCookiesMap(Map<String, String> arg0) {
		// TODO Auto-generated method stub
		this.cookie = arg0;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}



}
