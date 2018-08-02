package com.countries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

	// create file if it doesn't exist
	public static void createFile() {
		//String dir = "resources";
		String fileName = "countries.txt";
		Path filePath = Paths.get(fileName);

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File was created successfully!");
			} catch (IOException e) {
				System.out.println("Something went wrong!");
			}
		}
	}

	// store list of countries
	public static void writeToFile(String countryName) { // method can also take in String dir, String fileName
		//String dir = "resources";
		String fileName = "countries.txt";

		Path writeFile = Paths.get(fileName);

		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));

			outW.println(countryName);
			outW.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found!");
		}
	}

	// read countries from file into ArrayList
	public static ArrayList<String> readFromFile() {
		ArrayList<String> countryList = new ArrayList<>();

		//String dir = "resources";
		String fileName = "Countries.txt";
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();
		//Scanner scan = new Scanner(file);

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

			//while (scan.hasNextLine()) {  // TODO: see if Scanner avoids null line issue
				while (line != null) {
				line = reader.readLine();
				countryList.add(line);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		} 
		//scan.close();
		return countryList;
	}
}
