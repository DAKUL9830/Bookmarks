package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;
import static org.junit.Assert.*;
class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		//test 1: porn in url --false
		WebLink webLink=BookmarkManager.getInstance().createWebLink(2000,	"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",	"http://www.javaworld.com");
		boolean isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertFalse("For porn in url--isKidFriendlyEligible must be return false",isKidFriendlyEligible);
		//Test2 :porn in title--false
		
		webLink=BookmarkManager.getInstance().createWebLink(2000,	"Taming porn, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
		isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertFalse("For porn in title--isKidFriendlyEligible must be return false",isKidFriendlyEligible);
		
		//test 3 adult in host--false
		
		webLink=BookmarkManager.getInstance().createWebLink(2000,	"Taming tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.adult.com");
		isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertFalse("For adult in host--isKidFriendlyEligible must be return false",isKidFriendlyEligible);
		
		
		//test 4 adult in url,but not in host--true
		
		webLink=BookmarkManager.getInstance().createWebLink(2000,	"Taming tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",	"http://www.javaworld.com");
		isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertTrue("For adult in url,but not host part--isKidFriendlyEligible must be return true",isKidFriendlyEligible);
		
		
		//test5 adult in title only  --true;
		
		webLink=BookmarkManager.getInstance().createWebLink(2000,	"Taming adult, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",	"http://www.javaworld.com");
		isKidFriendlyEligible=webLink.isKidFriendlyEligible();
		assertTrue("For adult in title--isKidFriendlyEligible must be return true",isKidFriendlyEligible);
		
	}

}
