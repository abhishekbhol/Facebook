package iiitb.fb.actions;

import java.util.List;
import java.util.Map;

import iiitb.fb.models.User;
import iiitb.fb.models.UserWallPost;
import iiitb.fb.models.WallPost;
import iiitb.fb.models.impl.WallPostImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WallPostAction extends ActionSupport implements ModelDriven<WallPost>{
//
	private static final long serialVersionUID = 1L;
	
	WallPost wp = new WallPost();
	private List<UserWallPost> wallPostsList;
	private User user;

	
	public String deleteWallPost(){
		WallPostImpl wpi = new WallPostImpl();
		
		if(wpi.deleteWallPost(wp)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	//loadung a wallpost
	public String getWallPosts(){
		
		WallPostImpl wpi = new WallPostImpl();
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = (User)session.get("user");
		
		//hardcoded replace with session
		wallPostsList = wpi.getWallPosts(user.getProfile_id());
		System.out.println("WallPostAction");
		return SUCCESS;
	}
	@Override
	public WallPost getModel() {
		// TODO Auto-generated method stub
		return wp;
	}
	public WallPost getWp() {
		return wp;
	}
	public void setWp(WallPost wp) {
		this.wp = wp;
	}

	public List<UserWallPost> getWallPostsList() {
		return wallPostsList;
	}

	public void setWallPostsList(List<UserWallPost> wallPostsList) {
		this.wallPostsList = wallPostsList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
