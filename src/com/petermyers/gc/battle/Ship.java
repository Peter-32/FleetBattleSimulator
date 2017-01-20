package com.petermyers.gc.battle;

public class Ship {

	private double	attack;
	private double	defense;
	private double	health;
	private double	remainingDefense;
	private boolean	alive;
	private double	priority;

	/**
	 * @return the priority
	 */
	public double getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *                the priority to set
	 */
	public void setPriority(double priority) {
		this.priority = priority;
	}

	/**
	 * @return the alive
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive
	 *                the alive to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * @return the attack
	 */
	public double getAttack() {
		return attack;
	}

	/**
	 * @param attack
	 *                the attack to set
	 */
	public void setAttack(double attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public double getDefense() {
		return defense;
	}

	/**
	 * @param defense
	 *                the defense to set
	 */
	public void setDefense(double defense) {
		this.defense = defense;
	}

	/**
	 * @return the health
	 */
	public double getHealth() {
		return health;
	}

	/**
	 * @param health
	 *                the health to set
	 */
	public void setHealth(double health) {
		if (health <= 0) {
			this.health = 0;
			this.setAlive(false);
		} else {
			this.health = health;
		}

	}

	/**
	 * @return the remainingDefense
	 */
	public double getRemainingDefense() {
		return remainingDefense;
	}

	/**
	 * @param remainingDefense
	 *                the remainingDefense to set
	 */
	public void setRemainingDefense(double remainingDefense) {
		this.remainingDefense = remainingDefense;
	}

	Ship(double attack, double defense, double health) {
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		this.remainingDefense = defense;
		this.priority = attack / (defense + health);
		this.alive = true;
	}

	public void fire(Ship enemyShip) {
		// find the attack and defense of the ships
		double remainingDefense = enemyShip.getRemainingDefense();

		// roll to see what the attackPower and defensePower will be.
		// They are discrete,

		int attackPower = (int) (Math.random() * this.attack + 1); // 2 attack ranges from 0 to 2
		int defensePower = (int) (Math.random() * enemyShip.getRemainingDefense() + 1);

		// calculate net damage
		int netDamage = Math.min(attackPower - defensePower, 0);

		// damage the defense (or health)
		if (netDamage == 0) { // If 0 damage do nothing
		} else if (remainingDefense >= netDamage) { // lower defense but doesn't drain defense entirely
			enemyShip.setRemainingDefense(remainingDefense - netDamage);
		} else if (remainingDefense == 0) { // defense drained entirely already. Lower health.
			enemyShip.setHealth(enemyShip.getHealth() - netDamage);
		} else { // drain defense to zero. Lower health.
			enemyShip.setHealth(enemyShip.getHealth() + remainingDefense - netDamage);
			enemyShip.setRemainingDefense(0);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ship [attack=" + attack + ", defense=" + defense + ", health=" + health + ", remainingDefense=" + remainingDefense + ", alive=" + alive + ", priority=" + priority + "]";
	}

}
