/**
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 * <p>
 * This code was written by me for class - week 7.
 * @since 12-26-2018
 */
public class Player {

	private String fullName;
	private String collegeAcronym;
	private String position;
	private String collegeYear;
	private int jerseyNumber;
	private int weightInPounds;
	private int heightInInches;
	private int age;
	private int passingCompletions;
	private int passingAttempts;

	// constructor
	public Player(String name, String college) {

		fullName = name;
		collegeAcronym = college;

	}

	public Player() {
		// no arguments?
	}

	// setter methods
	public void setPosition(String pos) {
		this.position = pos;
	}

	public void setCollegeYear(String year) {
		this.collegeYear = year;
	}

	public void setWeight(int weight) {
		this.weightInPounds = weight;
	}

	public void setHeight(int height) {
		this.heightInInches = height;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setNumber(int number) {
		this.jerseyNumber = number;
	}

	public void setPassingCompletions(int completions) {
		this.passingCompletions = completions;
	}

	public void setPassingAttempts(int attempts) {
		this.passingAttempts = attempts;
	}

	// getter methods
	public String getPlayerName() {
		return fullName;
	}

	public String getPosition() {
		return position;
	}

	public String getCollegeYear() {
		return collegeYear;
	}

	public int getWeight() {
		return weightInPounds;
	}

	public int getHeight() {
		return heightInInches;
	}

	public int getAge() {
		return age;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public int getPassingCompletions() {
		return passingCompletions;
	}

	public int getPassingAttempts() {
		return passingAttempts;
	}

	public double getPercentageCompletions() {
		double result = (1.0 * passingCompletions) / passingAttempts * 100.0;
		return result;
	}

	public void printStats() {
		System.out.println(this.fullName + " from " + this.collegeAcronym + "\nPlayer is " + this.getHeight()
				+ " inches tall and " + this.getWeight() + " lbs\n" + this.getAge() + " years old");
	}

	@Override
	public String toString() {
		return "Player [fullName=" + fullName + ", collegeAcronym=" + collegeAcronym + ", position=" + position
				+ ", collegeYear=" + collegeYear + ", jerseyNumber=" + jerseyNumber + ", weightInPounds="
				+ weightInPounds + ", heightInInches=" + heightInInches + ", age=" + age + ", passingCompletions="
				+ passingCompletions + ", passingAttempts=" + passingAttempts + "]";
	}
	
}
