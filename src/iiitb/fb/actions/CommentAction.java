package iiitb.fb.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import iiitb.fb.models.Comment;
import iiitb.fb.models.User;
import iiitb.fb.models.UserComment;
import iiitb.fb.models.impl.CommentImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommentAction extends ActionSupport implements ModelDriven<UserComment>{
	

	private static final long serialVersionUID = 7575276917783741387L;
	UserComment uc = new UserComment();
	
	public String commentWallPost(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");

		CommentImpl ci = new CommentImpl();
		Comment c = new Comment();
		c.setProfileId(user.getProfile_id());
		c.setTimestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		c.setVisibility("Public");
		c.setCommentText(uc.getCommentText());
		c.setWallPostId(uc.getWallPostId());
		System.out.println("Wall Post Id: "+uc.getWallPostId());
		
		if(ci.commentWallPost(c)){
			uc.setFullName(user.getFname()+" "+user.getLname());
			uc.setProfileId(user.getProfile_id());
			uc.setProfilePicture(user.getProfilePic());
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	@Override
	public UserComment getModel() {
		// TODO Auto-generated method stub
		return uc;
	}

}
