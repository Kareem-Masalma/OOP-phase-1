
/*
 Kareem Masalma.
 1220535.
 Project phase1.
 */
import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Manager manager = new Manager();
		Family family = new Family("Masalma");
		manager.addFamily(family);
		System.out.println(manager);
		Family family2 = new Family("A");
		manager.updateFamily(family.getFamilyName(), family2);
		System.out.println(manager);
		Person person = new Person("1", "Ahmad",25, "Male", "Gaza", "0599");
		System.out.println(family2.addMember(person, "son"));
		System.out.println(family2);
		Person parent = new Person("2", "Mohammad", 40, "Male", "Ramallah", "056");
		family2.addParent(parent);
		System.out.println(family2);
		family2.removeMember(person);
		System.out.println(family2);
		
		Family fam1 = new Family("A");
		Family fam2 = new Family("B");
		fam1.addMember(new Martyr("1/1/2020", "Bombing", "Gaza", "5", "Ahmad", 20, "Male", "Gaza", "05991"), "Son");
//		fam1.addMember(new Martyr("1/1/2020", "Bombing", "Gaza", "6", "Maha", 25, "Female", "Gaza", "05992"), "Daughter");
		fam2.addMember(new Martyr("2/11/2023", "Bombing", "Gaza", "7", "Hanaa", 40, "Female", "Gaza", "0593"), "Mom");
		System.out.println(fam1.equals(fam2));
		System.out.println(manager.deleteFamily(fam1.getFamilyName()));
		
		in.close();
//		int ope;
//		// A loop to keep showing the menu to the user until they choose to exit.
//		while (true) {
//			mainMenu();
//			ope = in.nextInt();
//			if (ope == 1) {
//				while (true) {
//					managerMenu();
//					ope = in.nextInt();
//					if (ope == 1) {
//						// Inserting the info about the family that the user want to add.
//						System.out.println("Enter the name of the family:");
//						String family = in.next();
//						if (manager.addFamily(new Family(family)))
//							System.out.println("Family added successfully.");
//						else
//							System.out.println("Problem occured.");
//					} else if (ope == 2) {
//						// Entering the info about a family to update an existing family.
//						System.out.println("Enter the name of the family you want to update:");
//						String oldName = in.next();
//						System.out.println("Enter the new name:");
//						String newName = in.next();
//						if (manager.updateFamily(oldName, new Family(newName)))
//							System.out.println("Family updated successfully.");
//						else
//							System.out.println("Problem occured.");
//					} else if (ope == 3) {
//						// Deleting a family.
//						System.out.println("Enter the name of the family you want to delete:");
//						String name = in.next();
//						if (manager.deleteFamily(name))
//							System.out.println("Family deleted successfully.");
//						else
//							System.out.println("Problem occured.");
//					} else if (ope == 4) {
//						// Searching a family by the name.
//						System.out.println("Enter the name of the family to search:");
//						String name = in.next();
//						System.out.println(manager.searchByName(name).toString());
//					} else if (ope == 5) {
//						// Searching a person by the ID.
//						System.out.println("Enter the ID for the person you want to search.");
//						String id = in.next();
//						if (manager.searchPersonByID(id) == null) {
//							System.out.println("Person not found.");
//							continue;
//						}
//						System.out.println(manager.searchPersonByID(id).toString());
//					} else if (ope == 6) {
//						// Showing the statistics of a certain family entered by the user.
//						System.out.println("Enter the name of the family:");
//						String family = in.next();
//						if (manager.calculateFamilyStatistics(family) == null) {
//							System.out.println("Family was not found.");
//							continue;
//						}
//						System.out.println("Martyrs, orphans, alive:");
//						System.out.println(manager.calculateFamilyStatistics(family));
//					} else if (ope == 7) {
//						System.out.println("Enter the first family:");
//						String fam1 = in.next();
//						Family family1 = manager.searchByName(fam1);
//						if (family1 == null) {
//							System.out.println("Family not found, try again.");
//							continue;
//						}
//						System.out.println("Enter the second family:");
//						String fam2 = in.next();
//						Family family2 = manager.searchByName(fam2);
//						if (family2 == null) {
//							System.out.println("Family not found, try again.");
//							continue;
//						}
//						if (family1.equals(family2))
//							System.out.println(family1.getFamilyName() + " equals " + family2.getFamilyName()
//									+ " both have the same number of martyrs.");
//						else
//							System.out.println(family1.getFamilyName() + " does not equal " + family2.getFamilyName()
//									+ " they do not have the same number of martyrs.");
//					} else if (ope == 8) {
//						// Exiting to the main menu.
//						break;
//					} else {
//						System.out.println("Invalid input.");
//					}
//				}
//			} else if (ope == 2) {
//				// Entering a family to edit on.
//				System.out.println("Enter the name of the family you want to edit on:");
//				String fam = in.next();
//				Family family = manager.searchByName(fam);
//				if (family == null) {
//					System.out.println("Family was not foound, try again.");
//					continue;
//				}
//				while (true) {
//					familyMenu();
//					ope = in.nextInt();
//					if (ope == 1) {
//						// Adding a member.
//						System.out.println("Enter the ID:");
//						String ID = in.next();
//						System.out.println("Enter the name:");
//						String name = in.next();
//						System.out.println("Enter the age:");
//						int age = in.nextInt();
//						System.out.println("Enter the gender");
//						String gender = in.next();
//						System.out.println("Enter the address:");
//						String address = in.next();
//						System.out.println("Enter contact information:");
//						String contantInfo = in.next();
//						System.out.println("Enter family role:");
//						String role = in.next();
//						System.out.println("Alive or martyr?");
//						String life = in.next();
//						// Checking if the member is alive or a martyr.
//						if (life.equalsIgnoreCase("Alive")) {
//							if (family.addMember(new LivePerson(ID, name, age, gender, address, contantInfo), role))
//								System.out.println("Member is added succussfully.");
//							else
//								System.out.println("Member was not added.");
//						} else if (life.equalsIgnoreCase("Martyr")) {
//							System.out.println("Enter the date of Martydom:");
//							String dateOfMardateOfMartydom = in.next();
//							System.out.println("Enter the cause of the death:");
//							String causeOfdeath = in.next();
//							System.out.println("Enter the place of death:");
//							String placeOfDeath = in.next();
//							if (family.addMember(new Martyr(dateOfMardateOfMartydom, causeOfdeath, placeOfDeath, ID,
//									name, age, gender, address, contantInfo), role)) {
//								System.out.println("Maryter added successfully.");
//							} else
//								System.out.println("Member was not added.");
//						} else {
//							System.out.println("Invalid input.");
//						}
//
//					} else if (ope == 2) {
//						// Deleting a member.
//						System.out.println("Enter the ID:");
//						String ID = in.next();
//						Person p = manager.searchPersonByID(ID);
//						if (family.removeMember(p))
//							System.out.println("Member removed successfully.");
//						else
//							System.out.println("Member was not found.");
//					} else if (ope == 3) {
//						// Adding a parent.
//						System.out.println("Enter the ID:");
//						String ID = in.next();
//						System.out.println("Enter the name:");
//						String name = in.next();
//						System.out.println("Enter the age:");
//						int age = in.nextInt();
//						System.out.println("Enter the gender");
//						String gender = in.next();
//						if (!(gender.contains("Male") || gender.contains("Female") || gender.equalsIgnoreCase("Male")
//								|| gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("M")
//								|| gender.equalsIgnoreCase("F"))) {
//							System.out.println("Invalid gender input");
//							continue;
//						}
//						System.out.println("Enter the address:");
//						String address = in.next();
//						System.out.println("Enter contact information:");
//						String contantInfo = in.next();
//						// To check if alive or martyr.
//						System.out.println("Alive or martyr?");
//						String life = in.next();
//						if (life.equalsIgnoreCase("Alive")) {
//							family.addParent(new LivePerson(ID, name, age, gender, address, contantInfo));
//						} else if (life.equalsIgnoreCase("Martyr")) {
//							System.out.println("Enter the date of Martydom:");
//							String dateOfMardateOfMartydom = in.next();
//							System.out.println("Enter the cause of the death:");
//							String causeOfdeath = in.next();
//							System.out.println("Enter the place of death:");
//							String placeOfDeath = in.next();
//							family.addParent(new Martyr(dateOfMardateOfMartydom, causeOfdeath, placeOfDeath, ID, name,
//									age, gender, address, contantInfo));
//						} else
//							System.out.println("Invalid input.");
//
//					} else if (ope == 4) {
//						// Remove a parent.
//						System.out.println("Enter the ID:");
//						String ID = in.next();
//						Person p = manager.searchPersonByID(ID);
//						if (family.removeParent(p))
//							System.out.println("Parent removed successfully.");
//						else
//							System.out.println("Parent was not found.");
//					} else if (ope == 5) {
//						// Exiting to the main menu.
//						break;
//					} else
//						System.out.println("Invalid input.");
//				}
//			} else if (ope == 3) {
//				// Showing global calculation for families statistics.
//				System.out.println("Martyrs, orphans, alive:");
//				System.out.println(manager.calculateGlobalStatistics());
//			} else if (ope == 4) {
//				// Exiting the program.
//				System.out.println("Exiting program.");
//				break;
//			} else
//				System.out.println("Invalid input.");
//		}
//		in.close();
	}

	// A method to show the user what to choose to Edit on.
	public static void mainMenu() {
		System.out.println("Enter option for the operation:");
		System.out.println("1. Edit on Manager.");
		System.out.println("2. Edit on Family.");
		System.out.println("3. Calculate global statistic.");
		System.out.println("4. Exit program.");
		System.out.println("Enter option:");
	}

	// A method to show the operations the user can do on manager.
	public static void managerMenu() {
		System.out.println("Enter option for the operation:");
		System.out.println("1. Add a family.");
		System.out.println("2. Update a family.");
		System.out.println("3. Delete a family.");
		System.out.println("4. Search a family.");
		System.out.println("5. Search a person.");
		System.out.println("6. Calculate family statistic.");
		System.out.println("7. Compare two families.");
		System.out.println("8. Exit to main menu.");
		System.out.println("Enter option:");
	}

	// A method to show the operations the user can do on a certain family.
	public static void familyMenu() {
		System.out.println("Enter option for the operation:");
		System.out.println("1. Add member.");
		System.out.println("2. Remove member.");
		System.out.println("3. Add Parent.");
		System.out.println("4. Remove parent.");
		System.out.println("5. Exit to main menu.");
		System.out.println("Enter option:");
	}
}
