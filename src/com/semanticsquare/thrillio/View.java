package com.semanticsquare.thrillio;

import com.semanticsquare.thrillio.constant.KidFriendlyStatus;
import com.semanticsquare.thrillio.constant.UserType;
import com.semanticsquare.thrillio.controller.BookmarkController;
import com.semanticsquare.thrillio.entities.BookMark;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.partner.Sharable;

public class View {
	public static void browse(User user,BookMark[] [] bookmarks) {
		System.out.println("\n"+ user.getEmail()+" is browsing item");
		
		int bookmarkCount =0;
		for(BookMark[] bookmarkList:bookmarks) {
			for(BookMark bookmark:bookmarkList) {
				//Bookmarkingg
				if(bookmarkCount<DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked=getBookmarkDecision(bookmark);
					if(isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().SaveUserBookMark(user,bookmark);
						System.out.println("New Item bookmarked --  "+bookmark);
					}
				}
				if(user.getUserType().equals(UserType.EDITOR)||user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					
					//mark as kid friendly
					if(bookmark.isKidFriendlyEligible()&&bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus=getKidFriendlyStatusDecision(bookmark);
						if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);
							
						}
					}
					
					//Sharing!
					if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)&& bookmark instanceof Sharable) {
						boolean isShared=getShareDecision();
						if(isShared) {
							BookmarkController.getInstance().share(user,bookmark);
						}
					}
				}
			}
		}
		
	}
private static boolean getShareDecision() {
	return Math.random()<0.5?true:false;
		
	}
private static String getKidFriendlyStatusDecision(BookMark bookmark) {
	return Math.random()<0.4?KidFriendlyStatus.APPROVED:( Math.random()>=0.4 && Math.random()<0.8)? KidFriendlyStatus.REJECTED: KidFriendlyStatus.UNKNOWN;
		
	}
/*public static void bookmark(User user,BookMark[] [] bookmarks) {
	System.out.println("\n"+ user.getEmail()+" is a boomark");
	for(int i=0;i< DataStore.USER_BOOKMARK_LIMIT;i++) {
		int typeOffset=(int)(Math.random()*DataStore.BOOKMARK_TYPES_COUNT);
		int bookmarkOffset=(int)(Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
		
		BookMark bookmark=bookmarks[typeOffset][bookmarkOffset];
		BookmarkController.getInstance().SaveUserBookMark(user,bookmark);
		System.out.println(bookmark);
	}
}*/

	private static boolean getBookmarkDecision(BookMark bookmark) {
		return Math.random()<0.5?true:false;
		
	}
}
