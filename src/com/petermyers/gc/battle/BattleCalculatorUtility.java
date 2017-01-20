package com.petermyers.gc.battle;

public class BattleCalculatorUtility {
	
	/**
	 * Sorts the fleet. Highest priority to attack and be attacked is first.
	 * 
	 * @param fleet
	 *                the fleet list to sort
	 */
	public static void sortFleetByPrioritization(Fleet fleet) {
		
		// sort descending
		fleet.getShips().sort((s1, s2) -> {
			return Double.compare(s2.getPriority(), s1.getPriority());
		});
	}
	
	public static void removeFirstShipFromFleetIfDestroyed(Fleet fleet) {
		if (!fleet.getShips().get(0).isAlive()) { // if first ship is not alive
			fleet.removeShip(fleet.getShips().get(0)); // remove it
		}
	}
}