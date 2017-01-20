package com.petermyers.gc.battle;

public class BattleSimulator {
	
	void pctChanceNoCasualtiesYouAreFirstToAttack(Fleet yourFleet, Fleet enemyFleet) {
		// run simulation about 10,000 times
		int simulationCount = 0;
		int numSimulationsGood = 0;
		int numSimulationsBad = 0;
		
		yourFleet.attack(enemyFleet);
		
		System.out.println("Good Simulations: " + numSimulationsGood);
		System.out.println("Bad Simulations: " + numSimulationsBad);
		System.out.println("% Chance Good: " + numSimulationsGood / (numSimulationsGood + numSimulationsBad));
	}
	
	public Fleet getYourFleet() {
		// Fleet 1
		Ship yourShip1 = new Ship(5, 0, 5);
		Ship yourShip2 = new Ship(1, 0, 5);
		Fleet yourFleet = new Fleet();
		yourFleet.addShip(yourShip1);
		yourFleet.addShip(yourShip2);
		return yourFleet;
	}
	
	public Fleet getEnemyFleet() {
		// Fleet 2
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
