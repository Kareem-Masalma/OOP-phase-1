
/*
 Kareem Masalma.
 1220535.
 Project phase1.
 */
import java.util.*;

public class Manager {
	private ArrayList<Family> families = new ArrayList<>();

	// Add a new Family to the families ArrayList.
	public boolean addFamily(Family family) {
		// A loop to check if the family already exists.
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).getFamilyName().equalsIgnoreCase(family.getFamilyName()))
				return false;
		}
		families.add(family);
		return true;
	}

	// A method to update a family.
	public boolean updateFamily(String familyName, Family updatedFamily) {
		// A loop to search a family.
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).getFamilyName().equalsIgnoreCase(familyName)) {
				families.set(i, updatedFamily);
				return true;
			}
		}
		// The method will return false if the family don't exist.
		return false;
	}

	// Delete a family from the ArrayList.
	public boolean deleteFamily(String familyName) {
		// A loop to search the family.
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).getFamilyName().equalsIgnoreCase(familyName)) {
				families.remove(i);
				return true;
			}
		}
		// The method will return false if the family don't exist.
		return false;
	}

	// A method to search for a family by its name.
	public Family searchByName(String familyName) {
		// A loop to search for the family and return the Family if it's found.
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).getFamilyName().equalsIgnoreCase(familyName))
				return families.get(i);
		}
		// The method will return null if the family was not found.
		return null;
	}

	// A method to search a Person by their ID.
	public Person searchPersonByID(String ID) {
		// A loop to search the family that contains the person in the families ArrayList.
		for (int i = 0; i < families.size(); i++) {
			// A nested loop to search for the Person inside every family until it's found.
			for (int j = 0; j < families.get(i).members.size(); j++) {
				// To check if the ID's are equal between the inserted ID and the Person's IDs.
				if (families.get(i).members.get(j).getID().equals(ID)) {
					return families.get(i).members.get(j);
				}
			}
		}
		return null;
	}

	// This method to calculate the total number of martyrs in all families.
	public int calculateTotalMatyrs() {
		int n = 0;  // A counter.
		// A loop to go through all families.
		for (int i = 0; i < families.size(); i++) {
			// A nested loop to go through all members.
			for (int j = 0; j < families.get(i).members.size(); j++) {
				// To check if the person found is a Martyr or alive.
				if (families.get(i).members.get(j) instanceof Martyr)
					n++;
			}
		}
		return n;
	}

	// A method to calculate the total number of orphans in all families.
	public int calculateTotalOrphans() {
		int orph = 0;  // A counter.
		// A loop to go through all families.
		for (int i = 0; i < families.size(); i++) {
			// A nested loop to check all parents.
			for (int j = 0; j < families.get(i).parents.size() - 1; j++) {
				// To check if both parents are martyrs to add all the members as orphans.
				if (families.get(i).parents.get(j) instanceof Martyr
						&& families.get(i).parents.get(j + 1) instanceof Martyr) {
					orph += families.get(i).members.size();
				}
			}
		}
		return (orph - calculateTotalMatyrs());
	}

	// A method to calculate the total number of alive persons in all families.
	public int calculateTotalLivePersons() {
		int liv = 0;  // A counter.
		// A loop to go through all families.
		for (int i = 0; i < families.size(); i++) {
			// A nested loop to go through all members.
			for (int j = 0; j < families.get(i).members.size(); j++) {
				// To check if the person is a live person.
				if (families.get(i).members.get(j) instanceof LivePerson)
					liv++;
			}
		}
		return liv;
	}

	// A method to calculate the martyrs, orphans and alive people in a certain family.
	public ArrayList<Integer> calculateFamilyStatistics(String familyName) {
		if (searchByName(familyName) == null) {
			return null;
		}
		// Defining an ArrayList of Integers to save the statistics inside it.
		ArrayList<Integer> stat = new ArrayList<>();
		int mar = 0;  // Martyrs counter.
		int orph = 0;  // Orphans counter.
		int liv = 0;  // Alive persons counter.
		// A loop to go through all families,
		for (int i = 0; i < families.size(); i++) {
			// To check if the inserted family is found.
			if (families.get(i).getFamilyName().equalsIgnoreCase(familyName)) {
				// A nested loop to calculate the martyrs inside the family. 
				for (int j = 0; j < families.get(i).members.size(); j++) {
					if (families.get(i).members.get(j) instanceof Martyr) {
						mar++;
					}
				}

				// A nested loop to calculate the number of orphans inside the family.
				for (int j = 0; j < families.get(i).parents.size() - 1; j++) {
					if (families.get(i).parents.get(j) instanceof Martyr
							&& families.get(i).parents.get(j + 1) instanceof Martyr) {
						orph += families.get(i).members.size();
						for (int k = 0; k < families.get(i).members.size(); k++) {
							// If any of the children are Martyrs it won't be included as orphan.
							if (families.get(i).members.get(k) instanceof Martyr)
								orph--;
						}
					}
				}

				// A nested loop to calculate the number of alive persons inside the family.
				for (int j = 0; j < families.get(i).members.size(); j++) {
					if (families.get(i).members.get(j) instanceof LivePerson) {
						liv++;
					}
				}
			}
		}
		// Adding the number of martyrs, orphans and alive people to the ArrayList. 
		stat.add(mar);
		stat.add(orph);
		stat.add(liv);
		// Returning the ArrayList.
		return stat;
	}
	
	// A method to calculate the number of martyrs, orphans and alive people in all families.
	public ArrayList<Integer> calculateGlobalStatistics() {
		// Invoking methods that calculated total martyrs, orphans and alive people and store them in variables.
		int mar = calculateTotalMatyrs();
		int orph = calculateTotalOrphans();
		int liv = calculateTotalLivePersons();
		// Defining an ArrayList to store the statistics.
		ArrayList<Integer> stat = new ArrayList<>();
		// Adding the numbers to the ArrayList.
		stat.add(mar);
		stat.add(orph);
		stat.add(liv);
		// Returning the ArrayList.
		return stat;
	}

	// toString method to return a family info.
	@Override
	public String toString() {
		return "Manager [families=" + families + "]";
	}

}
