package iiitb.fb.actions;

import iiitb.fb.models.User;
import iiitb.fb.models.impl.UpdateProfilePicImpl;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateProfilePicAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5766698769249388898L;
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;
	private HttpServletRequest serveletRequest;
	public String execute(){
		String filePath = "F:\\github_new\\fb\\Facebook\\WebContent\\asset\\images\\profilepics\\";
		System.out.println(filePath);
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		userImageFileName = user.getProfile_id()+".jpg";
		File fileToCreate = new File(filePath, this.userImageFileName);

		try {
			FileUtils.copyFile(this.userImage, fileToCreate);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		UpdateProfilePicImpl upi = new UpdateProfilePicImpl();
		if(upi.updateDatabaseProfilePic(user.getProfile_id())){
			user.setProfilePic("/Facebook/asset/images/profilepics/"+user.getProfile_id()+".jpg");
			session.put("user", user);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public String updateCoverPicture(){
		String filePath = "F:\\github_new\\fb\\Facebook\\WebContent\\asset\\images\\profilepics\\";
		System.out.println(filePath);
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		userImageFileName = user.getProfile_id()+"_cover.jpg";
		File fileToCreate = new File(filePath, this.userImageFileName);

		try {
			FileUtils.copyFile(this.userImage, fileToCreate);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		UpdateProfilePicImpl upi = new UpdateProfilePicImpl();
		if(upi.updateDatabaseCoverPic(user.getProfile_id())){
			
			user.setCoverpicFileName("/Facebook/asset/images/profilepics/"+user.getProfile_id()+"_cover.jpg");
			session.put("user", user);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	public File getUserImage() {
		return userImage;
	}


	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}


	public String getUserImageContentType() {
		return userImageContentType;
	}


	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}


	public String getUserImageFileName() {
		return userImageFileName;
	}


	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}


	public HttpServletRequest getServeletRequest() {
		return serveletRequest;
	}


	public void setServeletRequest(HttpServletRequest serveletRequest) {
		this.serveletRequest = serveletRequest;
	}


	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.serveletRequest = arg0;
	}

}
