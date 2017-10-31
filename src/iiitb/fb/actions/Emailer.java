package iiitb.fb.actions;
import iiitb.fb.database.DatabaseConnect;
import iiitb.fb.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Emailer extends ActionSupport implements ModelDriven<User>{

   
	User user=new User();
   private String from="dipeshj29@gmail.com";
   private String password="dipeshjoshi29081991!";
   private String subject="Facebook Change password.";
   private String resendpassword;
   private String status;

   static Properties properties = new Properties();
   static
   {
      properties.put("mail.smtp.host", "smtp.gmail.com");
      properties.put("mail.smtp.socketFactory.port", "465");
      properties.put("mail.smtp.socketFactory.class",
                     "javax.net.ssl.SSLSocketFactory");
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.port", "465");
   }

   public String execute() 
   {
	   try {
	   DatabaseConnect db=new DatabaseConnect();
		String q="select upass from login where (email='"+user.getEmail()+"' and uname='"+user.getUserName()+"')";
		ResultSet rs=db.getData(q); 
	   
		if(rs.next())
		   {
			resendpassword=rs.getString("upass");
		   }
		else
		{
			status="You have not typed correct combination";
			return ERROR;
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   
	   
      try
      {
         Session session = Session.getDefaultInstance(properties,  
            new javax.mail.Authenticator() {
            protected PasswordAuthentication 
            getPasswordAuthentication() {
            return new 
            PasswordAuthentication(from, password);
            }});

         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO, 
            InternetAddress.parse(user.getEmail()));
         message.setSubject(subject);
         message.setText("Your password is:  "+resendpassword+"   " +
         		"Thank You!");
         Transport.send(message);
      }
      catch(Exception e)
      {
       e.printStackTrace();
         return ERROR;
      }
      status="Your password is sent to your Email.";
      return SUCCESS;
   }


   public static Properties getProperties() {
      return properties;
   }

   public static void setProperties(Properties properties) {
      Emailer.properties = properties;
   }


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}

public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


@Override
public User getModel() {
	return user;
}
}