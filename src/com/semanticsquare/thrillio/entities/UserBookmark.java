package com.semanticsquare.thrillio.entities;

public class UserBookmark {
	private User user;
	private BookMark bookmark;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BookMark getBookmark() {
		return bookmark;
	}
	public void setBookmark(BookMark bookmark) {
		this.bookmark = bookmark;
	}
	@Override
	public String toString() {
		return "UserBookmark [user=" + user + ", bookmark=" + bookmark + "]";
	}

}
