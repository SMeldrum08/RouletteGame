package meldrum.rouletteGame;

public class Validator {
	
	public static void checkIfAppropriateBetValue(PlayerDetailsWrapper player) throws RouletteGameException{
		if(player.getBetValue() <= 0){
			throw new RouletteGameException("Please enter an appropriate bet value (greater than 0)");
		}
	}
	
	public static void checkIfAppropriatePlacedSingleBet(PlayerDetailsWrapper player) throws RouletteGameException{
		if(player.getPlacedSingleBet() <=0 || player.getPlacedSingleBet() >= 37){
			throw new RouletteGameException("Please place a bet on an appropriate pocket (1-36)");
		}
	}

}
