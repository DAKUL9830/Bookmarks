package com.semanticsquare.thrillio;

import java.util.ArrayList;
import java.util.List;

import com.semanticsquare.thrillio.constant.Gender;
import com.semanticsquare.thrillio.entities.BookMark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import com.semanticsquare.thrillio.managers.UserManager;
import com.semanticsquare.thrillio.util.IOUtil;
public class DataStore {
	
	public static List<User>users=new ArrayList<>();
	public static List<User> getUsers() {
		return users;
	}
	private static List<List<BookMark>>bookmarks=new ArrayList<>();
	public static List<List<BookMark>> getBookmarks() {
		return bookmarks;
	}
	private static List<UserBookmark>userBookmarks=new ArrayList<>();
	


public static void loadData() {
	loadUsers();
	loadWeblinks();
	loadBooks();
	loadMovies();
}
private static  void loadUsers() {
	
	List<String> data=new ArrayList<>();
	IOUtil.read(data, "User");
	
	for (String row : data) {
		String[] values = row.split("\t");
		
		int gender = Gender.MALE;
		if (values[5].equals("f")) {
			gender = Gender.FEMALE;
		} else if (values[5].equals("t")) {
			gender = Gender.TRANSGENDER;
		}
			
		User user = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
		users.add(user);
	}
}
private static void loadWeblinks() {
	
	List<String>data = new ArrayList<>();
	IOUtil.read(data, "WebLink");
	//int colNum = 0;
	List<BookMark>bookmarklist=new ArrayList<>();
	for (String row : data) {
		String[] values = row.split("\t");
		
		BookMark bookmark= BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]/*, values[4]*/);
		bookmarklist.add(bookmark);
	}
	bookmarks.add(bookmarklist);
}
private static void loadBooks() {
	
	List<String>data = new ArrayList<>();
	IOUtil.read(data, "Book");
	
	List<BookMark>bookmarklist=new ArrayList<>();
	for (String row : data) {
		String[] values = row.split("\t");
		String[] authors = values[4].split(",");
		BookMark bookmark = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
		bookmarklist.add(bookmark);
	}
	bookmarks.add(bookmarklist);
}
private static void  loadMovies() {
	
	List<String>data = new ArrayList<>();
	IOUtil.read(data, "Movie");
	List<BookMark>bookmarklist=new ArrayList<>();
	for (String row : data) {
		String[] values = row.split("\t");
		String[] cast = values[3].split(",");
		String[] directors = values[4].split(",");
		BookMark bookmark= BookmarkManager.getInstance().createMovies(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6]));
		bookmarklist.add(bookmark);
	}
	bookmarks.add(bookmarklist);
}
public static void add(UserBookmark userBookmark) {
userBookmarks.add(userBookmark);

	
}
}