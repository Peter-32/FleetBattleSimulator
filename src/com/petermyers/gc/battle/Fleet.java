package com.petermyers.gc.battle;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
	
	private ArrayList<Ship> ships;
	
	public Fleet() {
		super();
		this.ships = new ArrayList<Ship>();
	}
	
	/**
	 * @return the ships
	 */
	public List<Ship> getShips() {
		return ships;
	}
	
	/**
	 * @param ship
	 *                the ship to add
	 */
	public void addShip(Ship ship) {
		ships.add(ship);
	}
	
	/**
	 * @param ship
	 *                the ship to remove
	 */
	public void removeShip(Ship ship) {
		ships.remove(ship);
	}
	
	/**
	 * 
	 * @param enemyFleet
	 *                the fleet being attacked
	 */
	public void attack(Fleet enemyFleet) {
		int i = 0, j = 0;
		// establish ordering of attacking and defending
		BattleCalculatorUtility.sortFleetByPrioritization(this);
		BattleCalculatorUtility.sortFleetByPrioritization(enemyFleet);
		
		// check to see if any fleets are completely destroyed
		while (!this.getShips().isEmpty() && !enemyFleet.getShips().isEmpty()) {
			
			// loop through each ship
			
			for (i = 0, j = 0; i < this.getShips().size() && j < enemyFleet.getShips().size(); i++, j++) {
				// both ships fire at the target
				// first at the first index always (it is sorted for highest priority)
				// don't evaluate if a ship is destroyed until after each ship has a chance to fire
				this.getShips().get(i).fire(enemyFleet.getShips().get(0));
				enemyFleet.getShips().get(j).fire(this.getShips().get(0));
				
				// check if a ship has been destroyed
				BattleCalculatorUtility.removeFirstShipFromFleetIfDestroyed(this);
				BattleCalculatorUtility.removeFirstShipFromFleetIfDestroyed(enemyFleet);
				
				if (this.getShips().isEmpty() || enemyFleet.getShips().isEmpty()) {
					return;
				}
			}
			// finish looping through any remaining ships that haven't fired
			for (; i < this.getShips().size(); i++) {
				this.getShips().get(i).fire(enemyFleet.getShips().get(0));
				BattleCalculatorUtility.removeFirstShipFromFleetIfDestroyed(enemyFleet);
				if (enemyFleet.getShips().isEmpty()) {
					return;
				}
			}
			for (; j < enemyFleet.getShips().size(); j++) {
				enemyFleet.getShips().get(j).fire(this.getShips().get(0));
				BattleCalculatorUtility.removeFirstShipFromFleetIfDestroyed(this);
				if (this.getShips().isEmpty()) {
					return;
				}
			}
			// round is over, start a new round???
		}
		
		// evaluate the damage after both have a chance to fire
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Fleet [ships=\n");
		for (Ship ship : ships) {
			sb.append(ship.toString());
			sb.append("\n");
		}
		sb.append("]");
		
		return sb.toString();
	}
	
}
