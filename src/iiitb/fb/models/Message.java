package iiitb.fb.models;

public class Message {
	
	private int sender_id;
	private int receiver_id;
	private String message_body;
	private int isRead;
	private String timestamp;
	private String receiver_name;
	private int visible1;
	private int visible2;
	
	
	public int getVisible1() {
		return visible1;
	}

	public void setVisible1(int visible1) {
		this.visible1 = visible1;
	}

	public int getVisible2() {
		return visible2;
	}

	public void setVisible2(int visible2) {
		this.visible2 = visible2;
	}

	public String getReceiver_name() {
		return receiver_name;
	}

	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}


	
	public int getSender_id() {
		return sender_id;
	}
	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}
	public int getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getMessage_body() {
		return message_body;
	}
	public void setMessage_body(String message_body) {
		this.message_body = message_body;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
