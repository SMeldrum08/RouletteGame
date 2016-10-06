package test;

import org.junit.Test;

import meldrum.rouletteGame.PlayerDetailsWrapper;
import meldrum.rouletteGame.RouletteGameException;
import meldrum.rouletteGame.Validator;

public class ValidatorUnitTest {

	@Test(expected=RouletteGameException.class)
	public void shoulfThrowRouletteExceptionWhenInvalidPocketChosen() throws RouletteGameException {
	    PlayerDetailsWrapper player = new PlayerDetailsWrapper();
	    player.setBetValue(-5);
	    Validator.checkIfAppropriateBetValue(player);
	    
	}
	
	@Test(expected=RouletteGameException.class)
	public void shoulfThrowRouletteExceptionWhenInvalidBetChosen() throws RouletteGameException {
	    PlayerDetailsWrapper player = new PlayerDetailsWrapper();
	    player.setPlacedSingleBet(-5);
	    Validator.checkIfAppropriatePlacedSingleBet(player);
	    
	}

}
