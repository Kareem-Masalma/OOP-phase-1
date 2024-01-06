
/*
 Kareem Masalma.
 1220535.
 Project phase1.
 */

public class Person {
	private String ID;
	private String name;
	private int age;
	private String gender;
	private String address;
	private String contactInfo;

	// No argument constructor.
	public Person() {

	}

	// Arguments constructor.
	public Person(String iD, String name, int age, String gender, String address, String contactInfo) {
		ID = iD;
		this.name = name;
		this.age = age;
		if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Male")
				|| gender.equalsIgnoreCase("Female")) {
			this.gender = gender;
		} else
			System.out.println("Invalid gender input.");
		this.address = address;
		this.contactInfo = contactInfo;
	}

	// Setters and getters:
	public String getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("Male")
				|| gender.equalsIgnoreCase("Female")) {
			this.gender = gender;
		} else
			System.out.println("Invalid gender input.");
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	// To String to print the info about a person.
	@Override
	public String toString() {
		return "Person [ID=" + ID + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", contactInfo=" + contactInfo + "]";
	}

}
