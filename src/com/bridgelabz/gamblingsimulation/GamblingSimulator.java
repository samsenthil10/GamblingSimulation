package com.bridgelabz.gamblingsimulation;

public class GamblingSimulator {

	public static final int STAKES_EVERYDAY = 100;
	public static final int STAKES_EVERYGAME = 1;
	public static final int WIN = 1;
	public static final int LOSE = 0;
	public static final int TOTAL_DAYS = 20;

	public static int everyGameBetOutcome(int cash) {
		int gameState = (int)Math.floor(Math.random()*10)%2;
		if(gameState == WIN) {
			cash++;
		}
		else if(gameState == LOSE) {
			cash--;
		}
		return cash;
	}

	public static int calculativeGambler(int netCash) {
		int min = (STAKES_EVERYDAY) - (50*STAKES_EVERYDAY/100);
		int max = (STAKES_EVERYDAY) + (50*STAKES_EVERYDAY/100);
		while (netCash >  min && netCash < max)
		{
			netCash = everyGameBetOutcome(netCash);
		}
		return netCash;
	}

	public static int everyMonthBetOutcome(int cash) {
		int netCash=0;
		for(int days=1; days <= TOTAL_DAYS; days++) {
			cash = STAKES_EVERYDAY;
			netCash+=calculativeGambler(cash);
		}
		return netCash;
	}

	public static void main(String[] args) {
		int netCash = STAKES_EVERYDAY;
		netCash = everyMonthBetOutcome(netCash);
		System.out.println(netCash);
	}	
}
