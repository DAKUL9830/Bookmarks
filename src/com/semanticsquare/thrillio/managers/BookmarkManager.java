package com.semanticsquare.thrillio.managers;

import com.semanticsquare.thrillio.dao.BookmarksDao;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.BookMark;
import com.semanticsquare.thrillio.entities.Movies;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.entities.UserBookmark;
import com.semanticsquare.thrillio.entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager instance=new BookmarkManager();
	private static BookmarksDao dao=new BookmarksDao();
	private BookmarkManager() {
		
	}
	public static BookmarkManager getInstance() {
		return instance;
	}
	public Movies createMovies(long id, String title,int releaseYear,String[] cast,String[] directors,String genre,double imdbRating) {
		Movies movies=new Movies();
		movies.setId(id);
		movies.setTitle(title);
		//movies.setProfileUrl(profileUrl);
		movies.setReleaseYear(releaseYear);
		movies.setCast(cast);
		movies.setDirectors(directors);
		movies.setGenre(genre);
		movies.setImdbRating(imdbRating);
		return movies;
	}
	public Book createBook(long id,String title,int publicationYear,String publisher,String[]authors,String genre,double amazonRating) {
		Book book=new Book();
		book.setId(id);
		book.setTitle(title);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);
		return book;
		
	}
	public WebLink createWebLink(long id,String title,String url,String host) {
		WebLink webLink =new WebLink();
		webLink.setId(id);
		webLink.setTitle(title);
		webLink.setUrl(url);
		webLink.setHost(host);
		return webLink;
		
	}
	public BookMark[][] getBookmarks(){
		return dao.getBookmarks();
	}
	public void SaveUserBookmark(User user, BookMark bookmark) {
		UserBookmark userBookmark=new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		dao.SaveUserBookmark(userBookmark);
		
	}
	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, BookMark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Kid -Friendly status "+ kidFriendlyStatus+", Marked by "+user.getEmail()+"  "+bookmark);
		
	}
	public void share(User user, BookMark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Data to be shared...");
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
		}else if(bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getItemData());
		}
		
	}

}
