package iiitb.fb.models.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Profile;
import iiitb.fb.models.WorkEducation;

 
public class EditProfileImpl {

	Profile pfobj= new Profile();
    ResultSet result1= null;
    ResultSet result2= null;
    ResultSet result3= null;
	Connection con = null; 

	private ArrayList<WorkEducation> listofeducationdetails=new ArrayList<WorkEducation>();  
	
	
	
	
	
	public Profile getEditProfileDetails(int pid) throws SQLException {
		// TODO Auto-generated method stub
	
		//code to store data in profile workeducation object

		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		
		String edudata="  select  workeducation_id,workeducation_title,description,start_date,end_date from  workeducation  WHERE profile_id='"+pid+"'";
		
		ResultSet result1=obj.getData(edudata);   // get data
		
		while(result1.next())
		{
			
			    WorkEducation weobj=new WorkEducation();
				weobj.setWorkeducation_title(result1.getString("workeducation_title"));
				
				weobj.setDescription(result1.getString("description"));
                weobj.setStart_date(result1.getString("start_date"));
				
				weobj.setEnd_date(result1.getString("end_date"));
				weobj.setWorkeducation_id(result1.getInt("workeducation_id"));
		        listofeducationdetails.add(weobj);
		}
		
	    // add arraylist to profile obj
		pfobj.setWorkexlist(listofeducationdetails);
		
		String profiledata= "select * from  profile WHERE profile_id='"+pid+"'";

		ResultSet result2=obj.getData(profiledata);
		
		while(result2.next())
		{
			
		pfobj.setFirstName(result2.getString("first_name"));
		pfobj.setLastName(result2.getString("last_name"));
		pfobj.setBirthday(result2.getString("birthday"));
		pfobj.setGender(result2.getString("gender"));
		pfobj.setHomeTown(result2.getString("hometown"));
		pfobj.setCurrentCity(result2.getString("current_city"));
		pfobj.setPhoneNo(result2.getString("phone_no"));
		pfobj.setRelationshipStatus(result2.getString("relationship_status"));
		pfobj.setAboutMe(result2.getString("about_me"));
		pfobj.setFavQuote(result2.getString("fav_quote"));
		
		pfobj.setInterestedIn(result2.getString("interested_in"));
		pfobj.setReligiousView(result2.getString("religious_view"));
		pfobj.setPoliticalView(result2.getString("political_view"));
		pfobj.setLanguageKnown(result2.getString("language_known"));
		
		pfobj.setProfessionalSkill(result2.getString("professional_skill"));
		
		}
		
		String email= "select email from login,profile where login.login_id= profile.login_id and  profile_id='"+pid+"'";

		ResultSet result3=obj.getData(email);
		
		while(result3.next())
		{
		pfobj.setEmail(result3.getString("email"));
		}
		
		return pfobj;	
	}

	public Profile getPfobj() {
		return pfobj;
	}

	public void setPfobj(Profile pfobj) {
		this.pfobj = pfobj;
	}

	public boolean updateWorkDetails(int pid, String title, String desc) {
		// TODO Auto-generated method stub
		

		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="Insert into workeducation ( profile_id,workeducation_title, description) values ('"+pid+"','"+title+"','"+desc+"') ";
	
		
		
		obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true; 
	}

	public boolean updateRelationshipStatus(int pid, String relationshipStatus) {

		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set relationship_status='"+ relationshipStatus +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true; 
		
		
	}

	public boolean updateAboutMeImpl(int pid, String aboutMe) {
		// TODO Auto-generated method stub
         DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set about_me='"+ aboutMe +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true; 
	}

	public boolean updateFavQuoteImpl(int pid, String favQuote) {
		// TODO Auto-generated method stub
        DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set fav_quote='"+ favQuote +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		return true;
	}

	public boolean updateHomeTownImpl(int pid, String homeTown) {
		
		
		 DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
			
			
			con=obj.getConnection();   // establish the database connection 
			
			try{
			String edudata="update profile set hometown='"+ homeTown  +"' where  profile_id='"+ pid+"'";
		    obj.updateData(edudata);   // get data
			}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
		
		return true;
	}

	public boolean updateCurrentCityImpl(int pid, String currentCity) {
		// TODO Auto-generated method stub
		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set current_city='"+ currentCity  +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	
	return true;
	}

	public boolean updateGenderImpl(int pid, String gender) {
		// TODO Auto-generated method stub
           DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set gender='"+ gender  +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
		return true;
		
		
	}

	public boolean updateLanguageImpl(int pid, String languageKnown) {
		// TODO Auto-generated method stub
         DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set language_known='"+ languageKnown +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
		return true;
	}

	public boolean updateInterestedInImpl(int pid, String interestedIn) {
		// TODO Auto-generated method stub
DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set interested_in='"+interestedIn +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
		return true;
		
		
		
	}

	public boolean updateReligiousViewImpl(int pid, String religiousView) {
		// TODO Auto-generated method stub
         DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set religious_view='"+ religiousView +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
		return true;
		
	}

	public boolean updatePoliticalViewImpl(int pid, String politicalView) {
		// TODO Auto-generated method stub
        DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set political_view='"+ politicalView +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
		return true;
	}

	public boolean updateEmailIdImpl(int pid, String email) {
		// TODO Auto-generated method stub
		 DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
			
			
			con=obj.getConnection();   // establish the database connection 
			
			try{
				
			String edudata="update login,profile set login.email='"+email +"' where profile.login_id= login.login_id and  profile_id='"+ pid+"'";
		    obj.updateData(edudata);   // get data
			}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		
			
			return true;
	}

	public boolean updatePhoneNoImpl(int pid, String phoneNo) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
        DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set phone_no='"+ phoneNo +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
		return true;
		
	}

	public boolean deleteHomeTownImpl(int pid, String homeTown) {
		// TODO Auto-generated method stub
DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update profile set hometown='"+ homeTown +"' where  profile_id='"+ pid+"'";
	    obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
		
		return true;
	}

	public boolean updateAgainWorkDetails(int pid, String title, String description) {
		
DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="update  workeducation set  description = '"+description+"' where profile_id ='"+pid+"' and workeducation_title ='"+title+"' ";
		
	
		
		
		obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true; 
		
		// TODO Auto-generated method stub
	
	}

	public boolean deletework(int pid, int id) {
		
       DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		try{
		String edudata="delete from  workeducation where  profile_id ='"+pid+"' and workeducation_id ='"+id+"' ";
		
	
		
		
		obj.updateData(edudata);   // get data
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
		// TODO Auto-generated method stub
		
	}

	
	             
	//Function to get all the work eductation title and detail for Profile id

	
    /*ResultSet result1= null;
	
	Connection con = null; 

	private List<WorkEducation> listofeducationdetails=new ArrayList<WorkEducation>();
	



	public List<WorkEducation> getWorkEducationData(int pid) throws SQLException {
		// TODO Auto-generated method stub

		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		
		String edudata="  select distinct  workeducation_title,description from  workeducation  WHERE profile_id='"+pid+"'";
		
		
		
		ResultSet result1=obj.getData(edudata);   // get data
		
		
		
	
		while(result1.next())
		{
			
			    WorkEducation weobj1=new WorkEducation();
				weobj1.setWorkeducation_title(result1.getString("workeducation_title"));
				
				weobj1.setDescription(result1.getString("description"));
			
		        listofeducationdetails.add(weobj1);
		}
		
	
		

		
		return listofeducationdetails ;
	}




	public String getRelationshipStatus(int pid) {
		// TODO Auto-generated method stub
		
		String R_status="";
		try {
		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
   		
		
		con=obj.getConnection();   // establish the database connection 
		
		
		String data="  select relationship_status from profile  WHERE profile_id='"+pid+"'";
		
		
		
		ResultSet result=obj.getData(data);   // get data
		
		
			while(result.next())
			{
				R_status=result.getString("relationship_status");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		return R_status;
	}




	public String getAboutMe(int pid) {
		// TODO Auto-generated method stub
		
		String about_me="";
		try {
		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
   		
		
		con=obj.getConnection();   // establish the database connection 
		
		
		String aboutme="  select about_me from profile  WHERE profile_id='"+pid+"'";
		
		
		
		ResultSet result=obj.getData(aboutme);   // get data
		
		
			while(result.next())
			{
				about_me=result.getString("about_me");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		return about_me;
		
		
	
	}




	public String getFavQuote(int pid) {
		// TODO Auto-generated method stub
		String fav_quote="";
		try {
		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
   		
		
		con=obj.getConnection();   // establish the database connection 
		
		
		String data="  select fav_quote from profile  WHERE profile_id='"+pid+"'";
		
		
		
		ResultSet result=obj.getData(data);   // get data
		
		
			while(result.next())
			{
				fav_quote=result.getString("fav_quote");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		return fav_quote;
	}




	public List<WorkEducation>  getPlacesLived(int pid) throws SQLException {
		
		List<WorkEducation> listofplaceslived = new ArrayList<WorkEducation>();     
		

		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		
		String edudata="select hometown,current_city from profile  WHERE profile_id='"+pid+"'";
		
		
		
		ResultSet result1=obj.getData(edudata);   // get data
		
		System.out.print("data fethed");
		
	
	
		while(result1.next())
		{
			   WorkEducation weobj=new WorkEducation();
			
				weobj.setHomeTown(result1.getString("hometown"));
				//System.out.print(result1.getString("hometown"));
				
				weobj.setCurrentCity(result1.getString("current_city"));
				//System.out.print(result1.getString("current_city"));
				
		 listofplaceslived.add(weobj);
		}
		

		
		return listofplaceslived;
		
	}




	




	public List<WorkEducation> getBasicContactInfo(int pid) throws SQLException {
		// TODO Auto-generated method stub
		List<WorkEducation> listofbasicinformation = new ArrayList<WorkEducation>();
	    
		
			

		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		
		
		String edudata="select * from profile  WHERE profile_id='"+pid+"'";
		
		
		
		ResultSet result1=obj.getData(edudata);   // get data
		
		
	
	
		while(result1.next())
		{
			  
			WorkEducation weobj=new WorkEducation();
				weobj.setBirthday(result1.getString("birthday"));
				
				weobj.setLanguageKnown(result1.getString("language_known"));
				
				
				weobj.setInterestedIn(result1.getString("interested_in"));
				weobj.setReligiousView(result1.getString("religious_view"));
				weobj.setPoliticalView(result1.getString("political_view"));
				weobj.setGender(result1.getString("gender"));
				listofbasicinformation.add(weobj);
		}
		

		
		return listofbasicinformation;
	
	}*/
	
	// new code

	










	
	

}
