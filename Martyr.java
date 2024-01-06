
/*
 Kareem Masalma.
 1220535.
 Project phase1.
 */

public class Martyr extends Person {
	private String dateOfMartydom;
	private String causeOfDeath;
	private String placeOfDeath;

	// No argument constructor.
	public Martyr() {

	}

	// constructor with argument for super class and subclass.
	public Martyr(String dateOfMartydom, String causeOfDeath, String placeOfDeath, String iD, String name, int age,
			String gender, String address, String contactInfo) {
		super(iD, name, age, gender, address, contactInfo);
		this.dateOfMartydom = dateOfMartydom;
		this.causeOfDeath = causeOfDeath;
		this.placeOfDeath = placeOfDeath;
	}

	// Setters and getters:
	public String getDateOfMartydom() {
		return dateOfMartydom;
	}

	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	public String getPlaceOfDeath() {
		return placeOfDeath;
	}

	public void setDateOfMartydom(String dateOfMartydom) {
		this.dateOfMartydom = dateOfMartydom;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}

	public void setPlaceOfDeath(String placeOfDeath) {
		this.placeOfDeath = placeOfDeath;
	}

	// toString method to show the info about a martyr.
	@Override
	public String toString() {
		return "Martyr [Date of Martydom=" + dateOfMartydom + ", Cause of Death=" + causeOfDeath + ", Place of Death="
				+ placeOfDeath + ", ID()=" + getID() + ", Name()=" + getName() + ", Age()=" + getAge() + ", Gender()="
				+ getGender() + ", Address()=" + getAddress() + ", Contact Info()=" + getContactInfo() + "]";
	}

}
