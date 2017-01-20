package com.petermyers.gc.battle;

import java.text.DecimalFormat;

public class BattleSimulator {
	
	void runStatistics() {
		// run simulation about 10,000 times
		int simulationCount = 0;
		int numNeverLostAShip = 0;
		int numWon = 0;
		int numLostAShip = 0;
		String formattedString;
		Fleet yourFleet = getYourFleet();
		Fleet enemyFleet = getEnemyFleet();
		int yourFleetInitialSize = yourFleet.getShips().size();
		
		for (; simulationCount < 10000; simulationCount++) {
			// should be arbitrary who attacks who
			yourFleet.attack(enemyFleet);
			if (yourFleet.getShips().size() < yourFleetInitialSize) {
				numLostAShip++;
			} else {
				numNeverLostAShip++;
			}
			if (enemyFleet.getShips().isEmpty()) {
				numWon++;
			}
			// initialize fleet again
			yourFleet = getYourFleet();
			enemyFleet = getEnemyFleet();
		}
		
		System.out.println("Simulations: " + simulationCount);
		System.out.println("Flawless Simulations: " + numNeverLostAShip);
		System.out.println("Not Flawless: " + numLostAShip);
		formattedString = new DecimalFormat("#0.0%").format((double) numNeverLostAShip / (double) simulationCount);
		System.out.println("% Of Time: " + formattedString);
		System.out.println();
		
		System.out.println("Number of Wins: " + numWon);
		System.out.println("Number of Losses: " + (simulationCount - numWon));
		formattedString = new DecimalFormat("#0.0%").format((double) numWon / (double) simulationCount);
		System.out.println("% Won: " + formattedString);
	}
	
	public Fleet getYourFleet() {
		// Your Fleet
		Ship yourShip1 = new Ship(10, 25, 40);
		Ship yourShip2 = new Ship(10, 25, 40);
		Ship yourShip3 = new Ship(10, 25, 40);
		Ship yourShip4 = new Ship(10, 25, 40);
		Ship yourShip5 = new Ship(10, 25, 40);
		Fleet yourFleet = new Fleet();
		yourFleet.addShip(yourShip1);
		yourFleet.addShip(yourShip2);
		yourFleet.addShip(yourShip3);
		yourFleet.addShip(yourShip4);
		yourFleet.addShip(yourShip5);
		return yourFleet;
	}
	
	public Fleet getEnemyFleet() {
		// Enemy Fleet
		Ship enemyShip1 = new Ship(10, 0, 40);
		Ship enemyShip2 = new Ship(10, 0, 40);
		Ship enemyShip3 = new Ship(10, 0, 40);
		Ship enemyShip4 = new Ship(10, 0, 40);
		Ship enemyShip5 = new Ship(10, 0, 40);
		Fleet enemyFleet = new Fleet();
		enemyFleet.addShip(enemyShip1);
		enemyFleet.addShip(enemyShip2);
		enemyFleet.addShip(enemyShip3);
		enemyFleet.addShip(enemyShip4);
		enemyFleet.addShip(enemyShip5);
		return enemyFleet;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// no need to reset the health back to normal in this program.
		// assume one type of defense only, and it is the optimal defense.
		// assume total attack / (defense + health) is the order of attacking and prioritization
		
		BattleSimulator battleSimulation = new BattleSimulator();
		battleSimulation.runStatistics();
		
	}
	
}
