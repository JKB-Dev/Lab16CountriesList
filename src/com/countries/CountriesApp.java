package com.countries;

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		
		// initialize file if it doesn't already exist
		CountriesTextFile.createFile();

		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Countries Maintenance Application!");

		// display and loop user menu
		boolean cont = true;
		while (cont == true) {

			int choice = Validator.getInt(scan, "\n1) See the list of countries\n"
							+ "2) Add a country\n" + "3) Exit\n" + "\nEnter menu number: ", 1, 3);
			
			// display countries saved in countries.txt
			if (choice == 1) {
				for (String str : CountriesTextFile.readFromFile()) {
					System.out.println(str);
				}

			// prompt user to enter country and add to file
			} else if (choice == 2) {
				String countryName = Validator.getString(scan, "Enter country: ");
				CountriesTextFile.writeToFile(countryName);
				System.out.println("This country has been saved!");

			// exit loop and terminate
			} else if (choice == 3) {
				cont = false;
			}
		}

		System.out.println("\nGoodbye!");
		scan.close();
	}
}
