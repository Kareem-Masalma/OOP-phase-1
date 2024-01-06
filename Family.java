
/*
 Kareem Masalma.
 1220535.
 Project phase1.
 */
import java.util.*;

public class Family {
	private String familyName;
	ArrayList<Person> members = new ArrayList<>();
	ArrayList<Person> parents = new ArrayList<>();

	// No argument constructor.
	public Family() {

	}

	// constructor with argument.
	public Family(String familyName) {
		this.familyName = familyName;
	}

	// A method to add a new member to a family.
	public boolean addMember(Person member, String role) {
		for (int i = 0; i < members.size(); i++) { // To check if the entered ID is already exist.
			if (members.get(i).getID().equals(member.getID())) {
				System.out.println("ID already exists.");
				return false;
			}
		}
		// To check if the person is a mother or a father to add to members ArrayList and parents ArrayList.
		if (role.equalsIgnoreCase("Mom") || role.equalsIgnoreCase("Dad") || role.equalsIgnoreCase("Mother")
				|| role.equalsIgnoreCase("Father")) {
			parents.add(member);
			members.add(member);
			return true;
			// To check if the person is a son or a daughter to add to members ArrayList only.
		} else if (role.equalsIgnoreCase("Son") || role.equalsIgnoreCase("Daughter")) {
			members.add(member);
			return true;
		} else {
			return false;
		}
	}

	// A method to remove a member.
	public boolean removeMember(Person member) {
		if (member == null)
			return false;
		// A loop to search for the member.
		for (int i = 0; i < members.size(); i++) {
			// If the ID exists the member will be removed from the ArrayList members.
			if (members.get(i).getID().equals(member.getID())) {
				members.remove(i);
				return true; // return true if the member is successfully removed
			}
		}
		return false; // If the member was not found it will return false.
	}

	// return all the members in the ArrayList.
	public ArrayList<Person> getMembers() {
		return members;
	}

	// A method to add a parent to the parents ArrayList.
	public void addParent(Person parent) {
		// A loop to check if the parent already added to parents ArrayList.
		for (int i = 0; i < parents.size(); i++) {
			if (parents.get(i).getID().equals(parent.getID())) {
				System.out.println("The parent with this ID already exists.");
				return;
			}
		}
		parents.add(parent);
		members.add(parent);
		System.out.println("Parent added successfully.");
	}

	// A method to remove a parent.
	public boolean removeParent(Person parent) {
		boolean flag = false;
		if (parent == null)
			return false;
		// Remove the parent from parents ArrayList.
		for (int i = 0; i < parents.size(); i++) {
			if (parents.get(i).getID().equals(parent.getID())) {
				parents.remove(i);
				flag = true;
			}
		}

		// Remove the parent from parents ArrayList.
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getID().equals(parent.getID())) {
				members.remove(i);
				flag = true;
			}
		}
		return flag;
	}

	// Setters and getters:
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public ArrayList<Person> getParents() {
		return parents;
	}

	// toString method to get the info about the family and its members.
	@Override
	public String toString() {
		return "Family [Family Name=" + familyName + ", members=" + members + "]";
	}

	// Overridden method to check if 2 families are equal by the number of the
	// martyrs.
	@Override
	public boolean equals(Object obj) {
		int mar = 0;
		int marFam = 0;
		// To check the number of the martyrs in the family.
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i) instanceof Martyr) {
				mar++;
			}
		}

		// check the number of the martyrs in the sent family.
		if (obj instanceof Family) { // To check if the obj is a Family.
			int size = ((Family) obj).members.size();
			for (int i = 0; i < size; i++) {
				if (((Family) obj).members.get(i) instanceof Martyr) {
					marFam++;
				}
			}
		}
		if (mar == marFam)
			return true;
		else
			return false;
	}
}