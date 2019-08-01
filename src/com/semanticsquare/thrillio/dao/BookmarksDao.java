package com.semanticsquare.thrillio.dao;

import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.entities.BookMark;
import com.semanticsquare.thrillio.entities.UserBookmark;

public class BookmarksDao {
	public BookMark[][] getBookmarks(){
		return DataStore.getBookmarks();
	}

	public void SaveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}

}
