package com.semanticsquare.thrillio.controller;

import com.semanticsquare.thrillio.entities.BookMark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;

public class BookmarkController {
	private static  BookmarkController instance=new BookmarkController();
	private BookmarkController() {
		
	}
	public static BookmarkController getInstance() {
		return instance;
	}
	public void SaveUserBookMark(User user, BookMark bookmark) {
		BookmarkManager.getInstance().SaveUserBookmark(user,bookmark);
		
		
	}
	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, BookMark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);
		
	}
	public void share(User user, BookMark bookmark) {
		BookmarkManager.getInstance().share(user,bookmark);
		
	}

}
