package iiitb.fb.actions;

import java.util.List;
import java.util.Map;

import iiitb.fb.models.Poke;
import iiitb.fb.models.User;
import iiitb.fb.models.impl.PokeImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PokeAction extends ActionSupport implements ModelDriven<Poke> {

	List<Poke> pokelist;

	private int pokefromid;
	
	Poke p = new Poke();
	
	public Poke getP() {
		return p;
	}


	public void setP(Poke p) {
		this.p = p;
	}


	public int getPokefromid() {
		return pokefromid;
	}


	public void setPokefromid(int pokefromid) {
		this.pokefromid = pokefromid;
	}


	public List<Poke> getPokelist() {
		return pokelist;
	}


	public void setPokelist(List<Poke> pokelist) {
		this.pokelist = pokelist;
	}


	public String getUserPokeList()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");


		PokeImpl poke = new PokeImpl();
		pokelist=poke.getPokelist(user.getProfile_id());

		System.out.println("Poke list");
		for(int i=0; i<pokelist.size();i++)
		{
			System.out.println("Poke id"+pokelist.get(i).getPokeID());
			System.out.println("Poke to"+pokelist.get(i).getPokeTo());
			System.out.println("Poke from"+pokelist.get(i).getPokeFrom());
			System.out.println("Poke timestamp"+pokelist.get(i).getTimestamp());
			System.out.println("Poke from name: "+pokelist.get(i).getFromUserName());
			System.out.println("Poke from pic: "+pokelist.get(i).getProfilePic());

		}
		return SUCCESS;

	}

	public String pokeBack()
	{
		System.out.println("Poke from id in poke action: "+pokefromid);
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");

		PokeImpl poke = new PokeImpl();
		System.out.println("Calling poke impl in poke back");

		int status=	poke.insertpoke( pokefromid,user.getProfile_id());
		if(status==1)
			return ERROR;

		return SUCCESS;

	}

	public String deletePoke()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		PokeImpl poke = new PokeImpl();
		System.out.println("Calling poke impl in delete poke");
		
		if(poke.deletePoke(user.getProfile_id(),pokefromid ))
			return SUCCESS;
		else 
			return ERROR;
	}
	
	public String poke()
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		PokeImpl poke = new PokeImpl();
		
		int poketo=(int)session.get("currentProfile");
		
		
				
		if(!poke.checkAlreadyPoked(poketo,user.getProfile_id() ))
		{
			System.out.println("Calling poke impl in poke");
			int status=poke.insertpoke(poketo,user.getProfile_id());
			System.out.println("status: "+status);
			if(status==1)
			{
				p.setPoketext("You have successfully Poked");
				return SUCCESS;
			}
			else
				return ERROR;	
				
		}
		else 
		{
			p.setPoketext("User have not responded to your last poke");
			return SUCCESS;	
		}
		
		
	}

	@Override
	public Poke getModel() {
		// TODO Auto-generated method stub
		return p;
	}

}
