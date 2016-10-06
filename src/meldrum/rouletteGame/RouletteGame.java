package meldrum.rouletteGame;
import java.util.Scanner;

public class RouletteGame {
	
	private static final String ODDS_BET = "odds";
	private static final String EVENS_BET = "evens";
	private static final int SINGLE_MULTIPLYER = 36;
	private static final int EVEN_ODD_MULTIPLYER = 2;
	private static Scanner input = new Scanner( System.in);

	public static void playARouletteRound(PlayerDetailsWrapper player){
		
		placeABet(player);
		
		player.setPlayersMoney(player.getPlayersMoney() - player.getBetValue());
			
		findTypeOfBetMade(player);
		
		player.setRouletteResult(randomInt(-1,36));
		
		calculateResultOfRoll(player);
		
		input.close();
		
	}
	
	public static void placeABet(PlayerDetailsWrapper player){
		
		System.out.println("you currently have £" + player.getPlayersMoney());
		System.out.println("Please enter your bet:");
		player.setBetValue(input.nextInt());
		try{
		Validator.checkIfAppropriateBetValue(player);
		}catch(RouletteGameException e){
			
			System.out.println("That was an incorrect amount to enter");
			placeABet(player);	
		}
		
	}
	
	public static void findTypeOfBetMade(PlayerDetailsWrapper player){
		
		String typeOfBet = "";
		
		
		while (!typeOfBet.equals("single")&&!typeOfBet.equals("group")){
			System.out.println("Please enter whether you would like to place a 'single' bet or a 'group' bet");
		    typeOfBet = input.next();
		    typeOfBet.toLowerCase();
		}
		
		if (typeOfBet.equals("single")){
		
			System.out.println("Please enter on which number you would like to place your chip");
		
			player.setPlacedSingleBet(input.nextInt());
			try{
			Validator.checkIfAppropriatePlacedSingleBet(player);
			} catch(RouletteGameException e){
				
				System.out.println("That was an incorrect roll to enter");
				findTypeOfBetMade(player);	
			}
		}
		if (typeOfBet.equals("group")){
			
			while (!player.getPlacedGroupBet().equals(ODDS_BET)&&!player.getPlacedGroupBet().equals(EVENS_BET)){
				
			System.out.println("Please enter either 'odds' or 'evens'");
			player.setPlacedGroupBet(input.next());
			}
		}
	}

	public static void calculateResultOfRoll(PlayerDetailsWrapper player){
		
		if(player.getRouletteResult()<=0){
			String roll="";
			if (player.getRouletteResult() == 0){
				roll = "0";
			}
			else {
				roll = "00";
			}
			player.setAwardedMoney(0);
			System.out.println("Unlucky! The wheel rolled a " + roll + ", the house always wins!");
			System.out.println("You now have £" + player.getPlayersMoney());
			
		}
		else if(player.getPlacedSingleBet() == player.getRouletteResult()){
			winningBetMadeResult(player, SINGLE_MULTIPLYER);
			
		}else if(player.getPlacedGroupBet().equals(EVENS_BET)&& player.getRouletteResult() % 2 == 0){
			
			winningBetMadeResult(player, EVEN_ODD_MULTIPLYER);
			
		}else if(player.getPlacedGroupBet().equals(ODDS_BET)&& player.getRouletteResult() % 2 == 1){
			
			winningBetMadeResult(player, EVEN_ODD_MULTIPLYER);
			
		}
		else{
			player.setAwardedMoney(0);
			System.out.println("Unlucky! The wheel rolled a " + player.getRouletteResult() + ", this means you lost your bet!");
			System.out.println("You now have £" + player.getPlayersMoney());
		}
		
	}
	
	public static void winningBetMadeResult(PlayerDetailsWrapper player, int multiplyer){
		
		player.setAwardedMoney(player.getBetValue() * multiplyer);
		player.setPlayersMoney(player.getPlayersMoney() + player.getAwardedMoney());
		
		System.out.println("Congratulations, the wheel rolled a "+ player.getRouletteResult() + ", this means you have won £" + player.getAwardedMoney());
		System.out.println("This means you now have £"+player.getPlayersMoney());
	}
	

	
    public static int randomInt(int min, int max) {

    	int n = min + (int) (Math.random() * ((max - min) + 1));

    	return n;
    }

}
