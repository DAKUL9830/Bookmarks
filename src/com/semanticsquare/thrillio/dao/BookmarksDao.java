package com.semanticsquare.thrillio.dao;

import java.util.List;

import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.entities.BookMark;
import com.semanticsquare.thrillio.entities.UserBookmark;

public class BookmarksDao {
	public List<List<BookMark>> getBookmarks(){
		return DataStore.getBookmarks();
	}

	public void SaveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}

}
