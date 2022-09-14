package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Starting Amount? ");
		double startAmount = in.nextDouble();
		System.out.println("Win Chance? ");
		double winChance = in.nextDouble();
		System.out.println("Win Limit? ");
		double winLimit = in.nextDouble();
		System.out.println("Total Simulations? ");
		int totalSimulations = in.nextInt();
		
		double currentAmount = startAmount;
		int currentDay = 0;	
		int totalPlays = 0;
		
		double ruin = 0;
		double success = 0;
		
		while (currentDay < totalSimulations)
		{
			while (currentAmount > 0 && currentAmount < winLimit)
			{	
				if (Math.random() < winChance)
				{
					++currentAmount;
				}
				else
				{
					--currentAmount;
				}
				++totalPlays;
			}
			if (currentAmount == winLimit)
			{
				System.out.println("Day Number: " + ++currentDay);
				System.out.println("Total Plays: " + totalPlays);
				System.out.println("Success");
				currentAmount = startAmount;
				totalPlays = 0;
				++success;
			}
			if (currentAmount == 0)
			{
				System.out.println("Day Number: " + ++currentDay);
				System.out.println("Total Plays: " + totalPlays);
				System.out.println("Ruin");
				currentAmount = startAmount;
				totalPlays = 0;
				++ruin;
			}
		}
		double expectedruinrate;
		double ruinrate = (ruin) / (ruin + success);
		 
		if (winChance == 0.5)
		{
			expectedruinrate = 1 - (startAmount / winLimit);
		}
		else
		{
			expectedruinrate = (Math.pow(ruinrate, startAmount) - Math.pow(ruinrate, winLimit)) / (1 - Math.pow(ruinrate, winLimit)); 
		}
		
		System.out.println("Ruin Rate: " + ruinrate);
		System.out.println("Expected Ruin Rate: " + expectedruinrate);
	}
}
