package iiitb.fb.models;

public class Poke {
	
	private int pokeID;
	private int pokeFrom;
	private int pokeTo;
	private String timestamp;
	private int isPokeBack;
	private String fromUserName;
	private String profilePic;
	private String poketext;
	public String getPoketext() {
		return poketext;
	}


	public void setPoketext(String poketext) {
		this.poketext = poketext;
	}


	
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public int getPokeFrom() {
		return pokeFrom;
	}
	public void setPokeFrom(int pokeFrom) {
		this.pokeFrom = pokeFrom;
	}
	public int getPokeTo() {
		return pokeTo;
	}
	public void setPokeTo(int pokeTo) {
		this.pokeTo = pokeTo;
	}
	
	public int getPokeID() {
		return pokeID;
	}
	public void setPokeID(int pokeID) {
		this.pokeID = pokeID;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getIsPokeBack() {
		return isPokeBack;
	}
	public void setIsPokeBack(int isPokeBack) {
		this.isPokeBack = isPokeBack;
	}
	

}
