package com.metacube.training.question3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CricketMatchTest {

	@Test
	public void testBowlersPositive()  {
		CricketMatch cricketMatch = new CricketMatch(12, 3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		List<Bowler> actualResult = cricketMatch.chooseBowler();
		List<Bowler> expectedResult = new ArrayList<Bowler>();
		expectedResult.add(new Bowler("a", 6));
		expectedResult.add(new Bowler("b", 1));
		expectedResult.add(new Bowler("a", 1));
		expectedResult.add(new Bowler("b", 1));
		expectedResult.add(new Bowler("a", 1));
		expectedResult.add(new Bowler("b", 1));
		expectedResult.add(new Bowler("c", 1));
		for (int count = 0; count < expectedResult.size(); count++) {
			assertEquals(expectedResult.get(count).getName(),
					actualResult.get(count).getName());
			assertEquals(expectedResult.get(count).getNumOfBalls(),
					actualResult.get(count).getNumOfBalls());
		}
	}

	@Test(expected = AssertionError.class)
	public void testInvalidArgumentsBallsToBePlayed()  {
		CricketMatch cricketMatch = new CricketMatch(-12, 3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		List<Bowler> actualResult = cricketMatch.chooseBowler();

	}

	@Test(expected = AssertionError.class)
	public void testInvalidArgumentsNumBowlers()  {
		CricketMatch cricketMatch = new CricketMatch(12, -3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		List<Bowler> actualResult = cricketMatch.chooseBowler();

	}

	@Test(expected = AssertionError.class)
	public void testInsufficientBalls()  {
		CricketMatch cricketMatch = new CricketMatch(14, 3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		List<Bowler> actualResult = cricketMatch.chooseBowler();

	}

	@Test(expected = AssertionError.class)
	public void testBowlersOutOfBound()  {
		CricketMatch cricketMatch = new CricketMatch(12, 3);
		Bowler bowler1 = new Bowler("a", 8);
		Bowler bowler2 = new Bowler("b", 3);
		Bowler bowler3 = new Bowler("c", 1);
		Bowler bowler4 = new Bowler("d", 1);
		cricketMatch.addBowler(bowler1);
		cricketMatch.addBowler(bowler2);
		cricketMatch.addBowler(bowler3);
		cricketMatch.addBowler(bowler4);
		List<Bowler> actualResult = cricketMatch.chooseBowler();

	}

}
