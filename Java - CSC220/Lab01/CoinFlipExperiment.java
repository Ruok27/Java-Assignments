package lab01;

public class CoinFlipExperiment {
	public static void 
	main(String[] args) {
		
		
		int amount  = coinFlipExperiment();
		System.out.println("Win/Loss amount: " + amount);
		
	}	
	
	
	
	static public int coinFlipExperiment()
	{
		
		int winnings = 0;
		int i = 0;
		double flip = Math.random();
		
		
		
		while (i < 100){		
			
		if (flip < 0.505) {
		//heads
		++winnings;
		}
		
		else {
		//tails
		--winnings;
		} 
		flip = Math.random();
		i++;
		
		
						}
		
		
		
		return winnings;

		}
	
		
	}
	
	
	 

