package com.simplilearn.SportyShoesWebapplication.entity;

import java.util.Date;

public class User {
	// properties
		private long id;
		private String username;
		private String password;
		private String role;
		private Date dateAdded;
		public User(long id, String username, String password, String role, Date dateAdded) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.role = role;
			this.dateAdded = dateAdded;
		}
		public User() {
			super();
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Date getDateAdded() {
			return dateAdded;
		}
		public void setDateAdded(Date dateAdded) {
			this.dateAdded = dateAdded;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
					+ ", dateAdded=" + dateAdded + "]";
		}
		
		

}
