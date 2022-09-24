package manager;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.*;
import model.parents.*;
import model.prisms.*;
	/**
	 * The Manage class will handle the user input and invoking the wright methods
	 * @author Aiden
	 *
	 */
public class Manager {

	String searchType;
	String sortMethod;
	String file;
	Shape[] shapes;
	
	public Manager() {
		
	}
	/**
	 * Constructor of Manager that will accept the args array from the user input
	 * @param args
	 */
	public Manager(String[] args) {

		System.out.println("\n************************************************************************************************************");
		System.out.println("\t\tGroup 1: Assignment 1 - Sorting Shapes");
		System.out.println("************************************************************************************************************\n");

		// validate parameters
		checkArgs(args);

		// call loadFile to read our txt
		loadFile();

		/*
		 * testing only for(int i = 0; i<=50;i++) { System.out.println(shapes[i]); }
		 */
		
		try {
			System.out.println("Sorting started... please be patient...");
			for (int i = 1; i < 4; i++) {
				Thread.sleep(400);
				System.out.print("..");
				System.out.println("");
			}
		}catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		// invoke chosen sort method
		Utilities util = new Utilities();
		util.sortManager(searchType, sortMethod, shapes);

	}

	/**
	 * This method reads the text file specified from the run parameter
	 * 
	 * @author Aiden
	 */
	private void loadFile() {
		// load file animation
		try {
			System.out.println("\n\nLoading File \"" + file
					+ "\" (Please wait, this might take a while depending on dataset size)");
			for (int i = 1; i < 4; i++) {
				Thread.sleep(400);
				System.out.print("..");
				System.out.println("");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			File fileDir = new File(file);
			Scanner scan = new Scanner(fileDir);

			// defines shape array and its array size
			shapes = new Shape[scan.nextInt()];
			int i = 0;
			// will put data to array
			while (scan.hasNext()) {

				switch (scan.next()) {
				case "Cone":
					shapes[i] = new Cone(scan.nextDouble(), scan.nextDouble());
					i++;
					break;
				case "Cylinder":
					shapes[i] = new Cylinder(scan.nextDouble(), scan.nextDouble());
					i++;
					break;
				case "Pyramid":
					shapes[i] = new Pyramid(scan.nextDouble(), scan.nextDouble());
					i++;
					break;
				case "SquarePrism":
					shapes[i] = new Square(scan.nextDouble(), scan.nextDouble());
					i++;
					break;
				case "PentagonalPrism":
					shapes[i] = new Pentagonal(scan.nextDouble(), scan.nextDouble());
					i++;
					break;
				case "OctagonalPrism":
					shapes[i] = new Octagonal(scan.nextDouble(), scan.nextDouble());
					i++;
					break;
				case "TriangularPrism":
					shapes[i] = new Triangular(scan.nextDouble(), scan.nextDouble());
					i++;
					break;
				default:
					break;
				}
			}

			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("\nWe cannot find the file you specified: " + file + "\n");
			System.out.println("***Important*** If you are using Powershell YOU MUST enclose file location in quotation marks\n");
			System.out.println("Sample Parameter input for file:");
			System.out.println(
					"\"-f\", followed by the text file location in quotation (i.e. \"-f\"C:\\TEMP\\POLYFOR5.TXT\"\")");
			System.out.println("Please try again...\n");
			System.exit(0);
		} catch (InputMismatchException ime) {
			System.out.println(
					"There has been a problem reading your file, please make sure your data set follows the proper format");
			System.out.println(
					"First data of the file should indicate total number of shapes, Shape names are followed by 2 identifying data(double)");
			System.out.println(
					"Sample dataset: \n 3 Cone 1841.337 11221.988 Cone 9672.383 8328.983 TriangularPrism 30437.593 3615.132");
			System.exit(0);
		}

	}

	/**
	 * This method will validate the parameters from the cli
	 * 
	 * @param args
	 */
	private void checkArgs(String[] args) {
		// check if there is only 3 parameters
		/*if (args.length != 3) {
			invalidParam();
		}*/

		// check all parameters and assign
		for (int i = 0; i < args.length; i++) {
			assignArgs(i, args);
		}

		// check if any of the parameters are empty
		if (sortMethod == null || file == null || searchType == null) {
			invalidParam();
		}
		
		System.out.println("Sorting by: " + searchType.toLowerCase()
		+ " (\"h\"=height,\"v\"=volume,\"a\"=base area)");
		
		// check if search type is valid
		switch (searchType.toLowerCase()) {
		case "a":
			break;
		case "h":
			break;
		case "v":
			break;
		default:
			invalidParam();
		}
		
		System.out.println("Sorting method: " + sortMethod.toLowerCase()
		+ " (\"b\"=bubble,\"m\"=merge,\"s\"=selection,\"i\"=insert,\"q\"=quick,\"z\"=oddeven)");
		
		//check if sort method param is valid
		switch (sortMethod.toLowerCase()) {
		case "b":
			break;
		case "m":
			break;
		case "s":
			break;
		case "i":
			break;
		case "q":
			break;
		case "z":
			break;
		default:
			invalidParam();
		}
	}

	/**
	 * This method assigns our parameter variables (searchType,sortMethod,file)
	 * 
	 * @author Aiden
	 * @param x
	 * @param args
	 */
	private void assignArgs(int x, String[] args) {
		// System.out.println(args[x]);

		if (args[x].substring(0, 2).toLowerCase().equals("-s")) {
			sortMethod = args[x].substring(2).toLowerCase();
		}
		if (args[x].substring(0, 2).toLowerCase().equals("-t")) {
			searchType = args[x].substring(2).toLowerCase();
		}
		if (args[x].substring(0, 2).toLowerCase().equals("-f")) {
			file = args[x].substring(2).toLowerCase();
		}

	}

	/**
	 * This method displays to the user an invalid parameter message, it will help
	 * them make the right input next time
	 * 
	 * @author Aiden
	 */
	private void invalidParam() {
		System.out.println("\nInvalid parameters detected...\n");

		System.out.println("Provide 3 parameters using: ");
		System.out.println(
				"\"-t\", followed by shape property to be used with the sort (\"h\"=height,\"v\"=volume,\"a\"=base area) (i.e. \"-tv\" to sort by volume)\n");
		System.out.println(
				"\"-s\", followed by sort method to be used (\"b\"=bubble,\"m\"=merge,\"s\"=selection,\"i\"=insert,\"q\"=quick,\"z\"=oddeven) (i.e. \"-sb\" to sort using bubble sort)\n");
		System.out.println(
				"\"-f\", followed by the text file location in quotation (i.e. \"-f\"C:\\TEMP\\POLYFOR5.TXT\"\")\n");
		System.out.println("Parameters are case and order INSENSITIVE");
		System.out.println("Note: If you are using PowerShell .. file location must be enclosed with quotation marks (i.e. -f\"res\\polyfor1.txt\")");
		System.out.println("Please try again...\n");

		System.exit(0);
	}

	
}
