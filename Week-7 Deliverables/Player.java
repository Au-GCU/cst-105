/**
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 *            <p>
 *            This code was written by me for class - week 7.
 * @since 12-26-2018
 */
public class Player {

	private String fullName;
	private String collegeAcronym;
	private String position;
	private String collegeYear;
	private int jerseyNumber;
	private int weight;
	private int height;
	private int age;
	private int passingCompletions;
	private int passingAttempts;

	// constructors
	
	// with arguments
	public Player(String name, String college, String position, String collegeYear, int jerseyNumber, int weight,
			int height, int age, int passingCompletions, int passingAttempts) {

		this.fullName = name;
		this.collegeAcronym = college;
		this.position = position;
		this.collegeYear = collegeYear;
		this.jerseyNumber = jerseyNumber;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.passingCompletions = passingCompletions;
		this.passingAttempts = passingAttempts;

	}

	// without arguments
	public Player() {
		fullName = "";
		collegeAcronym = "";
		position = "";
		collegeYear = "";

	}

	// basic mutator
	public void setPlayer(String name, String college, String position) {
		this.fullName = name;
		this.collegeAcronym = college;
		this.position = position;
	}

	// other setter methods
	public void setFullname(String name) {
		this.fullName = name;
	}

	public void setCollegeName(String college) {
		this.collegeAcronym = college;
	}

	public void setPosition(String pos) {
		this.position = pos;
	}

	public void setCollegeYear(String year) {
		this.collegeYear = year;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setHeight(int height) {
		this.height = height;
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

	public String getCollege() {
		return collegeAcronym;
	}

	public String getPosition() {
		return position;
	}

	public String getCollegeYear() {
		return collegeYear;
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
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
	public double getBodyMassIndex() {
		// formula here is kg/m^2
		//convert pounds to kg
		double weightInKg = weight * 0.453592;
		
		//convert inches to meters
		double heightInMeters = height * 0.0254;
		
		// compute BMI
		double result = weightInKg / (Math.pow(heightInMeters, 2));
		return result;
	}

	public void printStats() {
		System.out.println(this.fullName + " from " + this.collegeAcronym + "\nPlayer is " + this.getHeight()
				+ " inches tall and " + this.getWeight() + " lbs\n" + this.getAge() + " years old");
	}

	@Override
	public String toString() {
		return "Player [fullName=" + fullName + ", collegeAcronym=" + collegeAcronym + ", position=" + position
				+ ", collegeYear=" + collegeYear + ", jerseyNumber=" + jerseyNumber + ", weight=" + weight + ", height="
				+ height + ", age=" + age + ", passingCompletions=" + passingCompletions + ", passingAttempts="
				+ passingAttempts + "]";
	}

}
