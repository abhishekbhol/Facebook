package iiitb.fb.actions;

import java.sql.SQLException;import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import iiitb.fb.models.Profile;
import iiitb.fb.models.WorkEducation;
import iiitb.fb.models.impl.ProfileDisplayImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProfileDisplay extends  ActionSupport implements ModelDriven<WorkEducation> {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Profile pfobj= new Profile();
	private List<WorkEducation> listofeducationdetails = new ArrayList<WorkEducation>();
	WorkEducation weobj=new WorkEducation();
	ResultSet rs=null;

	public String geteducationdetails() throws SQLException{
		
		ProfileDisplayImpl pfimpl= new ProfileDisplayImpl();
		
		//Map<String,Object> session = ActionContext.getContext().getSession();
		//int profile_id=(Integer)session.get("profile_id");
		//int login_id= (Integer)session.get("login_id");
		System.out.println(" call back");	
		listofeducationdetails=pfimpl.getWorkEducationData(1);
			
	    Iterator<WorkEducation> itr=listofeducationdetails.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next().getWorkeducation_title());
		}
		
		
		
		return SUCCESS;
		}
		 
	
	
	 
	
	@Override
	public WorkEducation getModel() {
		// TODO Auto-generated method stub
		return null;
	}



	public Profile getPfobj() {
		return pfobj;
	}



	public void setPfobj(Profile pfobj) {
		this.pfobj = pfobj;
	}



	public WorkEducation getWeobj() {
		return weobj;
	}



	public void setWeobj(WorkEducation weobj) {
		this.weobj = weobj;
	}



	public List<WorkEducation> getListofeducationdetails() {
		return listofeducationdetails;
	}

    

	public void setListofeducationdetails1(List<WorkEducation> listofeducationdetails1) {
		this.listofeducationdetails = listofeducationdetails1;
	}

 
}
