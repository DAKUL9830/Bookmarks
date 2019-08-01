package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constant.BookGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import static org.junit.Assert.*;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test1
		
		Book book=BookmarkManager.getInstance().createBook(4000,	"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,	4.3);
		boolean isKidFriendlyEligible=book.isKidFriendlyEligible();
		assertFalse("For Philosophy Genre --isKidFriendlyeligible should return false",isKidFriendlyEligible);
		//Test 2
		book=BookmarkManager.getInstance().createBook(4000,	"Walden",1854,"Wilder Publications",new String[] {"Henry David Thoreau"},BookGenre.SELF_HELP,	4.3);
		isKidFriendlyEligible=book.isKidFriendlyEligible();
		assertFalse("For SelfHelp Genre --isKidFriendlyeligible should return false",isKidFriendlyEligible);
}
}