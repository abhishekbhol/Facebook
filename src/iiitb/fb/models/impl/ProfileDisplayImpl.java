package iiitb.fb.models.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.WorkEducation;



 
public class ProfileDisplayImpl {

	//Function to get all the work eductation title and detail for Profile id

	
    ResultSet result1= null;
	
	Connection con = null; 

	List<WorkEducation> listofeducationdetails=new ArrayList<WorkEducation>();




	public List<WorkEducation> getWorkEducationData(int pid) throws SQLException {
		// TODO Auto-generated method stub
		
		
		
		String edudata="  select distinct  workeducation_title,description from  workeducation  WHERE profile_id='"+pid+"'";
		
		DatabaseConnect obj= new DatabaseConnect();   // object of database_connect
		
		
		con=obj.getConnection();   // establish the database connection 
		System.out.println("Connection Successful");
		
		ResultSet result1=obj.getData(edudata);   // get data
		
		System.out.println("gotdata");
		
	
		while(result1.next())
		{
			
			    WorkEducation weobj1=new WorkEducation();
				weobj1.setWorkeducation_title(result1.getString("workeducation_title"));
				
				weobj1.setDescription(result1.getString("description"));
			
		        listofeducationdetails.add(weobj1);
		}
		
	
		

		
		return listofeducationdetails ;
	}




	
	

}
