package iiitb.fb.actions;

import iiitb.fb.models.UserLike;
import iiitb.fb.models.impl.WallPostImpl;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class LikeAjaxAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8264768548526244884L;
	private List<UserLike> likesList;
	private int wallPostId;
	public String loadLikes(){
		// to control the ajax call happening one after the other for unlike 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WallPostImpl wi = new WallPostImpl();
		likesList = new ArrayList<UserLike>();
		System.out.println(wallPostId);
		likesList = wi.getLikes(wallPostId);
		return "success";
	}
	public List<UserLike> getLikesList() {
		return likesList;
	}
	public void setLikesList(List<UserLike> likesList) {
		this.likesList = likesList;
	}
	public int getWallPostId() {
		return wallPostId;
	}
	public void setWallPostId(int wallPostId) {
		this.wallPostId = wallPostId;
	}
	
}
