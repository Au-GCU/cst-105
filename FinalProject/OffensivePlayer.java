/**
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 *            <p>
 *            This code was written by me for class - week 7.
 * @since 01-10-2019
 */
package sample;
public class OffensivePlayer extends Player {
	private int passingCompletions;
	private int passingAttempts;
	private int touchdowns;
	private int interceptions;
	private int yards;

	/**
	 * Full argument constructor
	 * 
	 * @param name
	 * @param college
	 * @param position
	 * @param year
	 * @param jersey
	 * @param weight
	 * @param height
	 * @param age
	 * @param seasons
	 * @param passingCompletions
	 * @param passingAttempts
	 * @param touchdowns
	 * @param interceptions
	 * @param yards
	 */
	public OffensivePlayer(String name, String college, String position, String year, int jersey, int weight,
			int height, int age, int seasons, int passingCompletions, int passingAttempts, int touchdowns,
			int interceptions, int yards) {
		super(name, college, position, year, jersey, weight, height, age, seasons);
		// TODO Auto-generated constructor stub
		this.passingCompletions = passingCompletions;
		this.passingAttempts = passingAttempts;
		this.touchdowns = touchdowns;
		this.interceptions = interceptions;
		this.yards = yards;

	}

	/**
	 * No argument constructor
	 */
	public OffensivePlayer() {
		this(null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	}

	// setters
	public void setPassingCompletions(int completions) {
		this.passingCompletions = completions;
	}

	public void setPassingAttempts(int attempts) {
		this.passingAttempts = attempts;
	}

	public void setTouchdowns(int touchdowns) {
		this.touchdowns = touchdowns;
	}

	public void setInterceptions(int interceptions) {
		this.interceptions = interceptions;
	}

	public void setYards(int yards) {
		this.yards = yards;
	}

	// getters
	public int getPassingCompletions() {
		return passingCompletions;
	}

	public int getPassingAttempts() {
		return passingAttempts;
	}

	public int getTouchdowns() {
		return touchdowns;
	}

	public int getInterceptions() {
		return interceptions;
	}

	public int getYards() {
		return yards;
	}
	/**
	 * Calculates percentage of passing completions
	 * @return result
	 */
	public double getPercentageCompletions() {
		double result = (1.0 * passingCompletions) / passingAttempts * 100.0;
		return result;
	}
	
	/**
	 *  Overidden toString method that includes super.toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "\nas OffensivePlayer [passingCompletions=" + passingCompletions
				+ ", passingAttempts=" + passingAttempts + ", touchdowns=" + touchdowns + ", interceptions="
				+ interceptions + ", yards=" + yards + "]";
	}

}
