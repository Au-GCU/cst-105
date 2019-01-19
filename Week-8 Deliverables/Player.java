/**
 * @author Jack Hall
 * @course CST-105
 * @professor Amr Elchouemi
 *            <p>
 *            This code was written by me for class - week 7.
 * @since 12-26-2018
 */
public abstract class Player {

	private String fullName;
	private String collegeAcronym;
	private String position;
	private String collegeYear;
	private int jerseyNumber;
	private int weight;
	private int height;
	private int age;
	private int seasonsPlayed;

	// constructors

	// with arguments
	public Player(String name, String college, String position, String collegeYear, int jerseyNumber, int weight,
			int height, int age, int seasonsPlayed) {

		this.fullName = name;
		this.collegeAcronym = college;
		this.position = position;
		this.collegeYear = collegeYear;
		this.jerseyNumber = jerseyNumber;
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.seasonsPlayed = seasonsPlayed;

	}

	// without arguments
	public Player() {
		this(null, null, null, null, 0, 0, 0, 0, 0);
		// does this add 2 to playerCount if I leave in playerCount++?
	}

	// basic mutator / multi-parameter setter
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

	public void setSeasonsPlayed(int seasonsPlayed) {
		this.seasonsPlayed = seasonsPlayed;
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

	public int getNumber() {
		return jerseyNumber;
	}

	public int getSeasonsPlayed() {
		return seasonsPlayed;
	}

	public double getBodyMassIndex() {
		// formula here is kg/m^2
		// convert pounds to kg
		double weightInKg = weight * 0.453592;

		// convert inches to meters
		double heightInMeters = height * 0.0254;

		// compute BMI
		double result = weightInKg / (Math.pow(heightInMeters, 2));
		return result;
	}

	// overridden toString method including all data fields
	@Override
	public String toString() {
		return "Player [fullName=" + fullName + ", collegeAcronym=" + collegeAcronym + ", position=" + position
				+ ", collegeYear=" + collegeYear + ", jerseyNumber=" + jerseyNumber + ", weight=" + weight + ", height="
				+ height + ", age=" + age + "]";
	}

}
