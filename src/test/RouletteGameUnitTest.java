package test;

import static org.junit.Assert.*;

import org.junit.Test;

import meldrum.rouletteGame.PlayerDetailsWrapper;
import meldrum.rouletteGame.RouletteGame;

public class RouletteGameUnitTest {
	
	

	@Test
	public void testIfCorrectBetPlacedCorrectMoneyIsCalculated() {
		
		PlayerDetailsWrapper player = new PlayerDetailsWrapper();
		player.setBetValue(10);
		player.setPlacedSingleBet(5);
		player.setRouletteResult(5);
		
		RouletteGame.calculateResultOfRoll(player);
		
		assertTrue(player.getAwardedMoney() == 360);
	}
	
	@Test
	public void testIfIncorrectBetPlacedCorrectMoneyIsCalculated() {
		
		PlayerDetailsWrapper player = new PlayerDetailsWrapper();
		player.setBetValue(10);
		player.setPlacedSingleBet(10);
		player.setRouletteResult(5);
		
		RouletteGame.calculateResultOfRoll(player);
		
		assertTrue(player.getAwardedMoney() == 0);
	}
	


	@Test
	public void testIfCorrectEvensBetPlacedCorrectMoneyIsCalculated() {
		
		PlayerDetailsWrapper player = new PlayerDetailsWrapper();
		player.setBetValue(10);
		player.setPlacedGroupBet("evens");
		player.setRouletteResult(12);
		
		RouletteGame.calculateResultOfRoll(player);
		
		assertTrue(player.getAwardedMoney() == 20);
	}
	

	@Test
	public void testIfIncorrectEvensBetPlacedCorrectMoneyIsCalculated() {
		
		PlayerDetailsWrapper player = new PlayerDetailsWrapper();
		player.setBetValue(10);
		player.setPlacedGroupBet("evens");
		player.setRouletteResult(11);
		
		RouletteGame.calculateResultOfRoll(player);
		
		assertTrue(player.getAwardedMoney() == 0);
	}
	
	@Test
	public void testIfCorrectOddsBetPlacedCorrectMoneyIsCalculated() {
		
		PlayerDetailsWrapper player = new PlayerDetailsWrapper();
		player.setBetValue(10);
		player.setPlacedGroupBet("odds");
		player.setRouletteResult(11);
		
		RouletteGame.calculateResultOfRoll(player);
		
		assertTrue(player.getAwardedMoney() == 20);
	}
	

	@Test
	public void testIfIncorrectOddsBetPlacedCorrectMoneyIsCalculated() {
		
		PlayerDetailsWrapper player = new PlayerDetailsWrapper();
		player.setBetValue(10);
		player.setPlacedGroupBet("odds");
		player.setRouletteResult(12);
		
		RouletteGame.calculateResultOfRoll(player);
		
		assertTrue(player.getAwardedMoney() == 0);
	}
	
	@Test
	public void testThat00ResultsInALoss(){
		
		PlayerDetailsWrapper player = new PlayerDetailsWrapper();
		player.setBetValue(10);
		player.setPlacedSingleBet(5);
		player.setRouletteResult(-1);
		
		RouletteGame.calculateResultOfRoll(player);
		
		assertTrue(player.getAwardedMoney() == 0);
		
	}
}
