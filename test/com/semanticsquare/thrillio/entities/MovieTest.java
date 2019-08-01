package com.semanticsquare.thrillio.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.semanticsquare.thrillio.constant.BookGenre;
import com.semanticsquare.thrillio.constant.MovieGenre;
import com.semanticsquare.thrillio.managers.BookmarkManager;
import static org.junit.Assert.*;
class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test 1
		Movies movies=BookmarkManager.getInstance().createMovies(3000,"Citizen Kane",	1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"}	,MovieGenre.HORROR,	8.5);
		boolean isKidFriendlyEligible=movies.isKidFriendlyEligible();
		assertFalse("For Horror Genre--isKidFriendlyEligible should return false",isKidFriendlyEligible);
		
		//Test 2
		
		movies=BookmarkManager.getInstance().createMovies(3000,"Citizen Kane",	1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"}	,MovieGenre.THRILLERS,	8.5);
		isKidFriendlyEligible=movies.isKidFriendlyEligible();
		assertFalse("For Thrillers Genre--isKidFriendlyEligible should return false",isKidFriendlyEligible);
		
		
	}

}
