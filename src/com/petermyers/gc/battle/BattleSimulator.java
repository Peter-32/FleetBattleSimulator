package com.petermyers.gc.battle;

import java.text.DecimalFormat;

public class BattleSimulator {
	
	void pctChanceNoCasualtiesYouAreFirstToAttack(Fleet yourFleet, Fleet enemyFleet) {
		// run simulation about 10,000 times
		int simulationCount = 0;
		int numSimulationsGood = 0;
		int numSimulationsBad = 0;
		int yourFleetInitialSize = yourFleet.getShips().size();
		
		for (; simulationCount < 10000; simulationCount++) {
			// should be arbitrary who attacks who
			yourFleet.attack(enemyFleet);
			if (yourFleet.getShips().size() < yourFleetInitialSize) {
				numSimulationsBad++;
			} else {
				numSimulationsGood++;
			}
		}
		
		System.out.println("Simulations: " + simulationCount);
		System.out.println("Good Simulations: " + numSimulationsGood);
		System.out.println("Bad Simulations: " + numSimulationsBad);
		String chanceGood = new DecimalFormat("#0.0%").format(numSimulationsGood / (numSimulationsGood + numSimulationsBad));
		System.out.println("% Chance Good: " + chanceGood);
	}
	
	public Fleet getYourFleet() {
		// Your Fleet
		Ship yourShip1 = new Ship(5, 0, 5);
		Ship yourShip2 = new Ship(1, 0, 5);
		Fleet yourFleet = new Fleet();
		yourFleet.addShip(yourShip1);
		yourFleet.addShip(yourShip2);
		return yourFleet;
	}
	
	public Fleet getEnemyFleet() {
		// Enemy Fleet
		Ship enemyShip1 = new Ship(1, 0, 5);
		Ship enemyShip2 = new Ship(1, 0, 5);
		Fleet enemyFleet = new Fleet();
		enemyFleet.addShip(enemyShip1);
		enemyFleet.addShip(enemyShip2);
		return enemyFleet;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// no need to reset the health back to normal in this program.
		// assume one type of defense only, and it is the optimal defense.
		// assume total attack / (defense + health) is the order of attacking and prioritization
		
		BattleSimulator battleSimulation = new BattleSimulator();
		Fleet yourFleet = battleSimulation.getYourFleet();
		Fleet enemyFleet = battleSimulation.getEnemyFleet();
		battleSimulation.pctChanceNoCasualtiesYouAreFirstToAttack(yourFleet, enemyFleet);
		
	}
	
}
