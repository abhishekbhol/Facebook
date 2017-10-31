package iiitb.fb.actions;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import java.util.Map;

import iiitb.fb.models.Profile;
import iiitb.fb.models.User;
import iiitb.fb.models.WorkEducation;
import iiitb.fb.models.impl.EditProfileImpl;
import iiitb.fb.models.impl.LoadProfileImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class EditProfileAction extends  ActionSupport implements ModelDriven<Profile> {

	
	
	/**
	 *
	 */

	private static final long serialVersionUID = 1L;
	private ArrayList<WorkEducation>  workneducation= new ArrayList<WorkEducation>();

	Profile pfobj= new Profile();
	EditProfileImpl pfimpl= new EditProfileImpl();
	 User user = new User();
	

	public String getProfiledetails() throws SQLException{
		
		
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		int profile_id=(Integer)session.get("currentProfile");
		System.out.println("currentProfile");
		//int login_id= (Integer)session.get("login_id");
		user = new LoadProfileImpl().getUser(profile_id);
	    pfobj=pfimpl.getEditProfileDetails(profile_id);
		
		return SUCCESS;
		
	}
		 
	

	public String updateWork()
	{
		
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int pid = user.getProfile_id();
		
	pfimpl.updateWorkDetails(pid, pfobj.getTitle(), pfobj.getDescription());
		return  SUCCESS;
	
	}
	 
	
	public String updateAgainWork()
	{
		
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int pid = user.getProfile_id();
		
	pfimpl.updateAgainWorkDetails(pid, pfobj.getTitle(), pfobj.getDescription());
		return  SUCCESS;
	
	}
	 
	
	public String deletework()
	{
		
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int pid = user.getProfile_id();
		
	pfimpl.deletework(pid, pfobj.getWorkeducation_id());
		return  SUCCESS;
	
	}
	 
	
	
	
	
	
	public String updateRelationshipStatus()
	
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int pid = user.getProfile_id();
		System.out.println(pfobj.getRelationshipStatus());
		pfimpl.updateRelationshipStatus(pid,pfobj.getRelationshipStatus() );
	  	
		return SUCCESS;
	}
	
	

	public String updateAboutMe()
	
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int pid = user.getProfile_id();
		System.out.println(pfobj.getAboutMe());
		pfimpl.updateAboutMeImpl(pid, pfobj.getAboutMe());
	  	
		return SUCCESS;
	}
	
	
public String updateFavQuote()
	
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		int pid = user.getProfile_id();
		System.out.println(pfobj.getFavQuote());
		pfimpl.updateFavQuoteImpl(pid,pfobj.getFavQuote());
	  	
		return SUCCESS;
	}
	
	
	
public String updateHomeTown()
{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	System.out.println(pfobj.getHomeTown());
	pfimpl.updateHomeTownImpl(pid,pfobj.getHomeTown());
	return SUCCESS;
}


public String updateCurrentCity()
{

	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	System.out.println(pfobj.getHomeTown());
	pfimpl.updateCurrentCityImpl(pid,pfobj.getCurrentCity());
	
	return SUCCESS;
}


public String updateGender()
{

	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	System.out.println(pfobj.getHomeTown());
	pfimpl.updateGenderImpl(pid,pfobj.getGender());
	
	return SUCCESS;
}



public String updateLanguage()
{
    
	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	
	pfimpl.updateLanguageImpl(pid,pfobj.getLanguageKnown());
	
	return SUCCESS;
}

	




public String updateInterestedIn()
{
	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	
	pfimpl.updateInterestedInImpl(pid,pfobj.getInterestedIn());
	
	return SUCCESS;
	
	
	
}


public String updateReligiousView()
{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	
	pfimpl.updateReligiousViewImpl(pid,pfobj.getReligiousView());
	
	return SUCCESS;
	
}

public String updatePoliticalView()
{

	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	
	pfimpl.updatePoliticalViewImpl(pid,pfobj.getPoliticalView());
	
	return SUCCESS;
	
}


public String updateEmailId()
{
	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	
	pfimpl.updateEmailIdImpl(pid,pfobj.getEmail());
	
	return SUCCESS;
	
}
public String updatePhoneNo()
{
	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	
	pfimpl.updatePhoneNoImpl(pid,pfobj.getPhoneNo());
	
	return SUCCESS;
	
}


public String deleteHomeTown()
{
	
	Map<String, Object> session = ActionContext.getContext().getSession();
	User user = (User)session.get("user");
	
	int pid = user.getProfile_id();
	
	pfimpl.deleteHomeTownImpl(pid,pfobj.getHomeTown());
	
	return SUCCESS;
	
}

@Override
	public Profile getModel() {
		// TODO Auto-generated method stub
		return pfobj;
	}





	public Profile getPfobj() {
		return pfobj;
	}





	public void setPfobj(Profile pfobj) {
		this.pfobj = pfobj;
	}





	public EditProfileImpl getPfimpl() {
		return pfimpl;
	}





	public void setPfimpl(EditProfileImpl pfimpl) {
		this.pfimpl = pfimpl;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<WorkEducation> getWorkneducation() {
		return workneducation;
	}


	public void setWorkneducation(ArrayList<WorkEducation> workneducation) {
		this.workneducation = workneducation;
	}

	
}
