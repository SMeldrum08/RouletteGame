package meldrum.rouletteGame;

public class PlayerDetailsWrapper {
	
	int playersMoney = 100;
	int betValue;
	int placedSingleBet;
	String placedGroupBet = "";
	int rouletteResult;
	int awardedMoney;
	
	public int getPlayersMoney() {
		return playersMoney;
	}
	public void setPlayersMoney(int playersMoney) {
		this.playersMoney = playersMoney;
	}
	public int getBetValue() {
		return betValue;
	}
	public void setBetValue(int betValue) {
		this.betValue = betValue;
	}
	public int getPlacedSingleBet() {
		return placedSingleBet;
	}
	public void setPlacedSingleBet(int placedBet) {
		this.placedSingleBet = placedBet;
	}
	public String getPlacedGroupBet() {
		return placedGroupBet;
	}
	public void setPlacedGroupBet(String placedGroupBet) {
		this.placedGroupBet = placedGroupBet;
	}
	public int getRouletteResult() {
		return rouletteResult;
	}
	public void setRouletteResult(int rouletteResult) {
		this.rouletteResult = rouletteResult;
	}
	public int getAwardedMoney() {
		return awardedMoney;
	}
	public void setAwardedMoney(int awardedMoney) {
		this.awardedMoney = awardedMoney;
	}

}
