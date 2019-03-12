package com.metacube.training.question3;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to add bowlers to the list and to order them such that
 * Virat Kohli won't win the match
 * 
 * @author Admin
 *
 */
public class CricketMatch {

	private List<Bowler> bowlersList = new ArrayList<Bowler>();
	private List<Bowler> bowlerOrder = new ArrayList<Bowler>();
	private int numOfBallsToBePlayed;
	private int numOfBowlers;

	
	public CricketMatch(int numOfBallsToBePlayed, int numOfBowlers)
			 {
		if (!(numOfBallsToBePlayed <= 0 || numOfBowlers <= 0)) {
			this.numOfBallsToBePlayed = numOfBallsToBePlayed;
			this.numOfBowlers = numOfBowlers;
		}
		else {
			throw new AssertionError("Balls cannot be negative");
		}
	}

	/**
	 * Method to add bowlers to the bowlersList
	 * 
	 * @param bowler
	 *            object consisting of bowler's details
	 * @throws AssertionError
	 *             if number of bowlers exceed the given size
	 */
	public void addBowler(Bowler bowler)  {
		if (bowlersList.size() < this.numOfBowlers) {
			this.bowlersList.add(bowler);
		} else {
			throw new AssertionError("Cannot add more bowlers");
		}
	}

	/**
	 * Method to make bowlers order so as to win the match
	 * 
	 * @return the ordered list of the bowlers
	 * @throws Assertionerror
	 *             if number of balls to be played by the player exceeds the sum
	 *             total balls of all the bowlers
	 */
	public List<Bowler> chooseBowler()  {

		int totalBalls = totalBalls();
		int maxBallsPerBowler;
		if (totalBalls < numOfBallsToBePlayed) {
			throw new AssertionError(
					"Number of balls to be thrown is less than number of balls to be "
							+ "played by the player");
		}
		while (totalBalls != 0) {
			maxBallsPerBowler = maxBalls();
			Bowler bowler = bowlersList.get(maxBallsPerBowler);
			if (bowlerOrder.size() == 0) {
				bowlerOrder.add(new Bowler(bowler.getName(), 1));
			} else {
				int previousIndex = bowlerOrder.size() - 1;
				Bowler previousBowler = bowlerOrder.get(previousIndex);
				if (previousBowler.getName().equals(bowler.getName())) {
					int ballsPlayed = bowlerOrder.get(previousIndex)
							.getNumOfBalls();
					bowlerOrder.get(previousIndex).setNumOfBalls(
							ballsPlayed + 1);
				} else {
					bowlerOrder.add(new Bowler(bowler.getName(), 1));
				}
			}
			bowler.setNumOfBalls(bowler.getNumOfBalls() - 1);
			totalBalls--;
		}

		return bowlerOrder;
	}

	/**
	 * Helper method to find the total sum of the balls of all the bowlers
	 * 
	 * @return totalBalls
	 */
	private int totalBalls() {
		int totalBalls = 0;
		for (Bowler bowler : bowlersList) {
			totalBalls += bowler.getNumOfBalls();
		}
		return totalBalls;
	}

	/**
	 * Helper method to find the index of the bowler who has maximum balls left
	 * to bowl
	 * 
	 * @return index of the bowler
	 */
	private int maxBalls() {
		int max = 0;
		int index = 0;
		int count = 0;
		for (Bowler bowler : bowlersList) {
			if (max < bowler.getNumOfBalls()) {
				max = bowler.getNumOfBalls();
				index = count;
			}
			count++;
		}
		return index;
	}

}
