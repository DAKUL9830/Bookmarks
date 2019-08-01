package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.entities.BookMark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;

public class Launch {
	private static User[] users;
	private static BookMark[] [] bookmarks;
	private static void loadData() {
		System.out.println("Loading data...");
		DataStore.loadData();
		users=UserManager.getInstance().getUsers();
		bookmarks=BookmarkManager.getInstance().getBookmarks();
		
		//System.out.println("Printing data....");
		//printUserData();
		//printBookmarkData();
	}

	private static void start() {
		//System.out.println("Bookmarking...");
		for(User user:users) {
			View.browse(user,bookmarks);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadData();
		start();

	}

	

	private static void printBookmarkData() {
		for(BookMark[] bookmarkList:bookmarks) {
			
		
		for(BookMark bookmark:bookmarkList) {
			System.out.println(bookmark);
		}
		}
	}

	private static void printUserData() {
		for(User user:users) {
		System.out.println(user);
		}
	}

}
