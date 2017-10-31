package iiitb.fb.models;

import java.util.Date;

public class Event {

	private int eventId;
	private int eventOwnerId;
	private String eventOwnerName;
	private String eventTitle;
	private String description;
	private String event_where ;
	private String eventDateHdr;
	private String eventTime;
	private Date eventDate;
	private Date eventStart ;
	private Date eventEnd;
	private String eventPhoto;
	private int isBirthday;
	
	public String getEventOwnerName() {
		return eventOwnerName;
	}
	public void setEventOwnerName(String eventOwnerName) {
		this.eventOwnerName = eventOwnerName;
	}
	
	public int getEventOwnerId() {
		return eventOwnerId;
	}
	public void setEventOwnerId(int eventOwnerId) {
		this.eventOwnerId = eventOwnerId;
	}
	
	
	public String getEventDateHdr() {
		return eventDateHdr;
	}
	public void setEventDateHdr(String eventDateHdr) {
		this.eventDateHdr = eventDateHdr;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	
	
	
	public int getIsBirthday() {
		return isBirthday;
	}
	public void setIsBirthday(int isBirthday) {
		this.isBirthday = isBirthday;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEvent_where() {
		return event_where;
	}
	public void setEvent_where(String event_where) {
		this.event_where = event_where;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public Date getEventStart() {
		return eventStart;
	}
	public void setEventStart(Date eventStart) {
		this.eventStart = eventStart;
	}
	public Date getEventEnd() {
		return eventEnd;
	}
	public void setEventEnd(Date eventEnd) {
		this.eventEnd = eventEnd;
	}
	public String getEventPhoto() {
		return eventPhoto;
	}
	public void setEventPhoto(String eventPhoto) {
		this.eventPhoto = eventPhoto;
	}
	
	
}
