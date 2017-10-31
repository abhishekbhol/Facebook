package iiitb.fb.models.impl;

import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.Poke;
import iiitb.fb.models.User;







import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PokeImpl {

	List<Poke> pokelist = new ArrayList<Poke>();

	public List<Poke> getPokelist(int user_id){

		try {
			DatabaseConnect db=new DatabaseConnect();

			//int profile_id = 2;

			//Actual Query
			//String query="SELECT * FROM facebook.poke where facebook.poke.poke_from ='"+user.getProfile_id()+"'";

			//Test Query
			//String query="SELECT poke.poke_id,poke.poke_from,poke.poke_to,poke.timestamp,poke.ispokeback,profile.first_name,profile.last_name,profile.profile_pic FROM facebook.poke, facebook.profile where poke.poke_id = profile.profile_id and ispokeback='0' and poke.poke_to ='"++"'";

			String query="SELECT poke.poke_id,poke.poke_from,poke.poke_to,poke.timestamp,poke.ispokeback,profile.first_name,profile.last_name,profile.profile_pic FROM facebook.poke, facebook.profile where poke.poke_from = profile.profile_id and ispokeback='0' and poke.poke_to ='"+user_id+"'";
			ResultSet rs=db.getData(query);
			while(rs.next())
			{
				Poke p=new Poke();
				p.setPokeID(rs.getInt("poke_id"));
				p.setPokeFrom(rs.getInt("poke_from"));
				p.setPokeTo(rs.getInt("poke_to"));


				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String str = rs.getString("timestamp");
				System.out.println("Date from system: "+str);
				String[] temp;
				temp = str.split(" ");
				Date startDate = formatter.parse(temp[0]);
				System.out.println("Start date: "+startDate);


				Date endDate = new Date();

				long diff = startDate.getTime() - endDate.getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000 * 30);

				System.out.println("Diff in days: "+ diffDays);

				//p.setTimestamp("about "+diffDays+" months ago");
				if(diffDays==0)
					p.setTimestamp("Poked today");
				else
					p.setTimestamp("about "+diffDays+" days ago");
				p.setIsPokeBack(rs.getInt("ispokeback"));
				p.setFromUserName(rs.getString("first_name")+" "+rs.getString("last_name"));
				p.setProfilePic(rs.getString("profile_pic"));
				pokelist.add(p);
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pokelist;
	}

	public int updatePokeBack(int poketo, int pokefrom)
	{
		System.out.println("In poke impl");
		//int profile_id = 2;//dummy profile id
		int returnval=0;

		DatabaseConnect db=new DatabaseConnect();
		String query;
		String now=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").format(System.currentTimeMillis());
		System.out.println("current date " + now );

		//System.out.println("Poke to: "+profile_id +" poke_from:"+pokefrom);
		query = "UPDATE facebook.poke SET ispokeback ='1' WHERE poke_from='"+pokefrom+"' and poke_to='"+poketo+"'";
		if(db.updateData(query)!=1)
		{
			System.out.println("Update success");
			returnval=1;
		}

		return returnval;
	}
	
	public boolean checkAlreadyPoked(int poketo, int pokefrom)
	{
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = dbc.getConnection();
		String query="SELECT * FROM facebook.poke where poke_from = '"+pokefrom+"' and poke_to='"+poketo+"' and ispokeback ='0'"  ;
		ResultSet rs=dbc.getData(query);
		boolean flag=false;
		try {
			if(rs.next())
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return flag;

	}

	public int insertpoke(int poketo, int pokefrom)
	{
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = dbc.getConnection();

		int flag=0;
		System.out.println("In insert poke");
		System.out.println("fromid"+pokefrom+"to id"+poketo);
		String query="SELECT * FROM facebook.poke where poke_from = '"+poketo+"' and poke_to='"+pokefrom+"' and ispokeback ='0' ";
		ResultSet rs=dbc.getData(query);

		try {
			if(rs.next())
			{
				if(deletePreviousPoke(poketo,pokefrom))
					System.out.println("Delete Success");
				
				query = "UPDATE facebook.poke SET ispokeback ='1' WHERE poke_from='"+poketo+"' and poke_to='"+pokefrom+"' and ispokeback ='0' ";
				if(dbc.updateData(query)!=1)
				{
					System.out.println("Update success in insert poke");
					
				}
//				flag=1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
//		query="SELECT * FROM facebook.poke where poke_from = '"+pokefrom+"' and poke_to='"+poketo+"'";
//		rs=dbc.getData(query);
//		try {
//			if(rs.next())
//			{
//				query = "UPDATE facebook.poke SET ispokeback ='0' WHERE poke_from='"+pokefrom+"' and poke_to='"+poketo+"'";
//				if(dbc.updateData(query)!=1)
//				{
//					System.out.println("Update success in insert poke");
//					
//				}
//				flag=1;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
		
		if(flag==0)
		{
			System.out.println("In insert if of poke");

			query = "INSERT INTO `facebook`.`poke` (`poke_from`, `poke_to`, `ispokeback`)"
					+ " values (?,?,?)";

			try {
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1,pokefrom);
				ps.setInt(2, poketo);
				ps.setInt(3, 0);

				dbc.updateData(ps);
				flag=1;
				System.out.println("insert success");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}

		}
		
		Poke p=new Poke();
		p.setPoketext("You have successfully poked back");
		
		return flag;
	}

	public boolean deletePoke(int poketo, int pokefrom)
	{
		System.out.println("In poke impl");
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = dbc.getConnection();
		//int poketo1 = 2;
		//System.out.println("Poketo "+poketo);
		String query = "Delete from facebook.poke where poke_from ='"+pokefrom+"' and poke_to='"+poketo+"'";

		try{
			dbc.updateData(query);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean deletePreviousPoke(int poketo, int pokefrom)
	{
		System.out.println("In poke impl");
		DatabaseConnect dbc = new DatabaseConnect();
		Connection connection = dbc.getConnection();
		//int poketo1 = 2;
		System.out.println("Poketo "+poketo+" pokefrom "+pokefrom);
		String query = "Delete from facebook.poke where poke_from ='"+poketo+"' and poke_to='"+pokefrom+"' and ispokeback ='1' ";

		try{
			dbc.updateData(query);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	

}
