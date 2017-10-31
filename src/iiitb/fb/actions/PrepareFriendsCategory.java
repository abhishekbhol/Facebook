package iiitb.fb.actions;
import java.util.Map;

import iiitb.fb.models.FriendsCat;
import iiitb.fb.models.User;
import iiitb.fb.models.impl.UpdateFriendsCat;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PrepareFriendsCategory extends ActionSupport implements ModelDriven<FriendsCat>{

	/**
	 * 
	 */
	private String category;
	private String catName;
	public int[] getSelected() {
		return selected;
	}

	public void setSelected(int[] selected) {
		this.selected = selected;
	}



	private int selected[];
	private static final long serialVersionUID = 1L;
	FriendsCat obj=new FriendsCat();
		
	public String execute(){
		
		UpdateFriendsCat ufc=new UpdateFriendsCat();
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		
		/*
		 * get the category names of the current user....if user has no category add two default categories
		 */
		if(ufc.FetchFriendCatList(user.getProfile_id(), obj))
			return SUCCESS;
		else return ERROR;
		 
		 
	}
	
	public String updateCategory(){
		UpdateFriendsCat ufc=new UpdateFriendsCat();
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user =(User)session.get("user");
		if(ufc.addNewCategory(user.getProfile_id(), catName, selected))
			return SUCCESS;
		else return ERROR;
	}
	
	public String EditCategoryList(){
		UpdateFriendsCat ufc=new UpdateFriendsCat();
		Map<String,Object> session = ActionContext.getContext().getSession();
		User user =(User)session.get("user");
		boolean flag1=ufc.deleteCategory(user.getProfile_id(), category);
		boolean flag2=ufc.addNewCategory(user.getProfile_id(), category, selected);
		if(flag1 && flag2)
			return SUCCESS;
		else return ERROR;
	}
	
	
	
public FriendsCat getObj() {
		return obj;
	}

	public void setObj(FriendsCat obj) {
		this.obj = obj;
	}

@Override
public FriendsCat getModel() {
	// TODO Auto-generated method stub
	return obj;
  }



public String getCatName() {
	return catName;
}



public void setCatName(String catName) {
	this.catName = catName;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}






 
}