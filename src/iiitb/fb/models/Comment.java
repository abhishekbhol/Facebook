package iiitb.fb.models;

public class Comment {
		private int wallPostId;
		private int profileId;
		private String commentText;
		private String timestamp;
		private String visibility;
		
		
		public int getWallPostId() {
			return wallPostId;
		}
		public void setWallPostId(int wallPostId) {
			this.wallPostId = wallPostId;
		}
		public int getProfileId() {
			return profileId;
		}
		public void setProfileId(int profileId) {
			this.profileId = profileId;
		}
		public String getCommentText() {
			return commentText;
		}
		public void setCommentText(String commentText) {
			this.commentText = commentText;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timstamp) {
			this.timestamp = timstamp;
		}
		public String getVisibility() {
			return visibility;
		}
		public void setVisibility(String visibility) {
			this.visibility = visibility;
		}
}
