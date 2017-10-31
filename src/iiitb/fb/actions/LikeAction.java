package iiitb.fb.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import iiitb.fb.models.Like;
import iiitb.fb.models.User;
import iiitb.fb.models.impl.LikeImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LikeAction extends ActionSupport implements ModelDriven<Like>{

	private static final long serialVersionUID = -1366018989206881211L;
	Like l = new Like();
	
	public String likeWallPost(){
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");

		LikeImpl li = new LikeImpl();
		//hardcodeds
		l.setProfileId(user.getProfile_id());
		l.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		if(li.likeWallPost(l)){
			return SUCCESS;
		}else{
			return ERROR;
			
		}
	}
	
	public String unlikeWallPost(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		
		LikeImpl li = new LikeImpl();
		l.setProfileId(user.getProfile_id());
		
		if(li.unlikeWallPost(l)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	@Override
	public Like getModel() {
		// TODO Auto-generated method stub
		return l;
	}
	
}
