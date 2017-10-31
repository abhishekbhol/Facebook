package iiitb.fb.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import iiitb.fb.models.User;
import iiitb.fb.models.UserWallPost;
import iiitb.fb.models.WallPost;
import iiitb.fb.models.impl.WallPostImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class WallPostAjaxAction extends ActionSupport implements ModelDriven<UserWallPost>{
//
	private static final long serialVersionUID = 7692234736372795694L;
	UserWallPost uwp = new UserWallPost();
	private int postToId;
	public String addWallPost(){
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		System.out.println("You are posting on : "+postToId);
		WallPostImpl wpi = new WallPostImpl();
		//hardcoded replace with session
		WallPost wp =new WallPost();
		wp.setPostFrom(user.getProfile_id());
		wp.setPostTo(postToId);
		wp.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		wp.setWallPostText(uwp.getWallPostText());
		wp.setEventId(uwp.getEventId());
		System.out.println(uwp.getWallPostText());
		
		int status = wpi.addWallPost(wp);
		if(status > 0){
			//hardcoded apply session
			uwp.setPostFromName(user.getFname()+" "+user.getLname());
			uwp.setPostFrom(user.getProfile_id());
			uwp.setPostTo(wp.getPostTo());
			uwp.setPostToName(wpi.getPostToName(wp.getPostTo()));
			uwp.setWallPostText(wp.getWallPostText());
			uwp.setWallPostId(status);
			uwp.setPostFromPicture(user.getProfilePic());
			return SUCCESS;
		}else{
			return ERROR;
		}
	}


	public UserWallPost getUwp() {
		return uwp;
	}

	public void setUwp(UserWallPost uwp) {
		this.uwp = uwp;
	}

	@Override
	public UserWallPost getModel() {
		// TODO Auto-generated method stub
		return uwp;
	}


	public int getPostToId() {
		return postToId;
	}


	public void setPostToId(int postToId) {
		this.postToId = postToId;
	}
	

}
