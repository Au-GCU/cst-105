/**
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 *            <p>
 *            This code was written by me for class - week 7.
 * @since 01-10-2019
 */
package sample;
public class DefensivePlayer extends Player {
	private int tackles;
	private int sacks;
	private int forcedFumbles;
	private int interceptions;
	
	/**
	 * Full argument constructor
	 * @param name
	 * @param college
	 * @param position
	 * @param year
	 * @param jersey
	 * @param weight
	 * @param height
	 * @param age
	 * @param seasons
	 * @param tackles
	 * @param sacks
	 * @param forcedFumbles
	 * @param interceptions
	 */
	public DefensivePlayer(String name, String college, String position, String year, int jersey, int weight, int height, int age, int seasons, int tackles, int sacks, int forcedFumbles, int interceptions) {
		super(name, college, position, year, jersey, weight, height, age, seasons);
		// TODO Auto-generated constructor stub
		this.tackles = tackles;
		this.sacks = sacks;
		this.forcedFumbles = forcedFumbles;
		this.interceptions = interceptions;

	}
	/**
	 * No arg constructor
	 */
	public DefensivePlayer() {
		this(null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	// getters
	public int getTackles() {
		return tackles;
	}

	public void setTackles(int tackles) {
		this.tackles = tackles;
	}

	public int getSacks() {
		return sacks;
	}
	
	// setters
	public void setSacks(int sacks) {
		this.sacks = sacks;
	}

	public int getForcedFumbles() {
		return forcedFumbles;
	}

	public void setForcedFumbles(int forcedFumbles) {
		this.forcedFumbles = forcedFumbles;
	}

	public int getInterceptions() {
		return interceptions;
	}

	public void setInterceptions(int interceptions) {
		this.interceptions = interceptions;
	}
	
	/**
	 * Overidden toString method that includes super.toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nas DefensivePlayer [tackles=" + tackles + ", sacks=" + sacks + ", forcedFumbles=" + forcedFumbles
				+ ", interceptions=" + interceptions + "]";
	}
}
