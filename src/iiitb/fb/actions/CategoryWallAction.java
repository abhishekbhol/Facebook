package iiitb.fb.actions;

import iiitb.fb.models.User;
import iiitb.fb.models.UserWallPost;
import iiitb.fb.models.impl.UpdateFriendsCat;
import iiitb.fb.models.impl.WallPostImpl;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryWallAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8844012838659629014L;
	private String category;
	private List<UserWallPost> wallPostsList;
	private String newName;
	private int check;
	private int pid;
	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public int getCheck() {
		return check;
	}


	public void setCheck(int check) {
		this.check = check;
	}


	public String execute(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user =(User)session.get("user");
		WallPostImpl wpi = new WallPostImpl();
		wallPostsList= wpi.getCategoryWallPosts(category, user.getProfile_id());
	    return SUCCESS;
	}
	
	
	public String deleteCategory(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user =(User)session.get("user");
		UpdateFriendsCat ufc=new UpdateFriendsCat();
		if(ufc.deleteCategory(user.getProfile_id(), category))
			return SUCCESS;
		else return ERROR;
		
	}
	
	
	public String renameCategory(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user =(User)session.get("user");
		UpdateFriendsCat ufc=new UpdateFriendsCat();
		if(ufc.renameCategory(user.getProfile_id(), newName ,category))
			return SUCCESS;
		else return ERROR;
		
	}
	
	public String isPresentInCategory(){
		check=0;
		UpdateFriendsCat ufc=new UpdateFriendsCat();
		if(ufc.checkInCategory(pid, category))
			check=1;
			return SUCCESS;
		
	}
	
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<UserWallPost> getWallPostsList() {
		return wallPostsList;
	}
	public void setWallPostsList(List<UserWallPost> wallPostsList) {
		this.wallPostsList = wallPostsList;
	}


	public String getNewName() {
		return newName;
	}


	public void setNewName(String newName) {
		this.newName = newName;
	}
	 
}
