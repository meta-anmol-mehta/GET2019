package com.metacube.training.question1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * class to create a virtual command prompt
 * 
 * @author admin
 *
 */
public class VirtualCommandPrompt {

	static List<Directory> listOfDirectory = new ArrayList<Directory>();
	static String path = ".\\";

	/**
	 * method to implement the virtual command prompt
	 */
	public static void virtualCommandPrompt() {
		Directory root = new Directory("Root:", new Date());
		listOfDirectory.add(root);
		Scanner scanner = new Scanner(System.in);
		System.out.println("***Welcome to Virtual Command Prompt***");
		String signature = "Root:\\";
		System.out.print(signature + ">");
		Directory currentDirectory = root;

		while (true) {
			String commandLine = scanner.nextLine();
			String[] commandWords = commandLine.split(" ");

			switch (commandWords[0]) {

			case "mkdir":
				if (commandWords.length >= 2) {
					boolean flag = false;
					for (Directory directory : currentDirectory
							.getListOfSubDirectory()) {
						if (directory.getName().equals(commandWords[1])) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						Directory newDirectory = new Directory(commandWords[1],
								new Date());
						listOfDirectory.add(newDirectory);
						currentDirectory.getListOfSubDirectory().add(
								newDirectory);
					} else
						System.out.println(signature
								+ ">A subdirectory or file " + commandWords[1]
								+ " already exists.");
				} else
					System.out.println(signature
							+ ">The syntax of the command is incorrect.");
				System.out.print(signature + ">");
				break;

			case "cd":
				if (commandWords.length >= 2) {
					if (findPath(currentDirectory, commandWords[1]) != null) {
						for (Directory directory : listOfDirectory) {
							if (directory.getName().equals(commandWords[1])) {
								currentDirectory = directory;
								if (signature.charAt(signature.length() - 1) != '\\')
									signature += "\\";
								signature += currentDirectory.getName();
								break;
							}
						}
					} else {
						System.out.println(signature
								+ "> No such directory exists");
					}
				} else
					System.out.println(signature
							+ ">The syntax of the command is incorrect.");
				System.out.print(signature + ">");
				break;

			case "bk":
				if (currentDirectory.getName() != "R:") {
					String[] directories = signature.split("\\\\");
					for (Directory directory : listOfDirectory) {
						if (directory.getName().equals(
								directories[directories.length - 2]))
							currentDirectory = directory;
					}
					signature = "R:";
					for (int i = 1; i < directories.length - 1; i++) {
						signature += "\\" + directories[i];
					}
				}
				System.out.print(signature + ">");
				break;

			case "ls":
				for (Directory subDirectory : currentDirectory
						.getListOfSubDirectory()) {
					System.out.println(subDirectory.getDateOfCreation() + " "
							+ subDirectory.getName());
				}
				System.out.println(currentDirectory.getListOfSubDirectory()
						.size() + " Folder(s)");
				System.out.print(signature + ">");
				break;

			case "find":
				path = ".\\";
				String directoryPath = findPath(currentDirectory,
						commandWords[1]);
				if (directoryPath != null) {
					StringBuilder pathToFind = new StringBuilder(directoryPath);
					pathToFind.deleteCharAt(pathToFind.length() - 1);
					System.out.println(pathToFind);
				} else
					System.out.println(signature + ">Directory not found");
				System.out.print(signature + ">");
				break;

			case "tree":
				System.out.println(".");
				printTree(currentDirectory, 0);
				System.out.print(signature + ">");
				break;

			case "exit":
				System.exit(0);

			default:
				System.out.println(signature + ">Command does not exist");
				System.out.print(signature + ">");

			}
		}
	}

	/**
	 * method to find the path of the given directory
	 * 
	 * @param currentDirectory
	 * @param directoryToBeSearched
	 * @return path
	 */
	private static String findPath(Directory currentDirectory,
			String directoryToBeSearched) {
		boolean found = false;
		if (currentDirectory.getName().equals(directoryToBeSearched)) {
			found = true;
		} else {
			for (Directory directory : currentDirectory.getListOfSubDirectory()) {
				path += directory.getName() + "\\";

				if (findPath(directory, directoryToBeSearched) != null) {
					found = true;
					break;
				} else {
					String[] directories = path.split("\\\\");
					path = ".\\";
					for (int i = 1; i < directories.length - 2; i++) {
						path += "\\" + directories[i];
					}
				}
			}

		}

		if (found) {
			return path;
		} else
			return null;
	}

	/**
	 * method to display the tree of the given directory
	 * 
	 * @param currentDirectory
	 * @param nesting
	 *            is the level of the subfolder
	 */
	private static void printTree(Directory currentDirectory, int nesting) {
		Iterator<Directory> iterator = currentDirectory.getListOfSubDirectory()
				.iterator();
		while (iterator.hasNext()) {
			for (int i = 0; i < nesting; i++)
				System.out.print("\u2502    ");
			Directory subDirectory = iterator.next();
			if (iterator.hasNext())
				System.out.println("\u251c\u2500\u2500"
						+ subDirectory.getName());
			else
				System.out.println("\u2514\u2500\u2500"
						+ subDirectory.getName());

			if (subDirectory.getListOfSubDirectory().size() != 0) {
				printTree(subDirectory, nesting + 1);
			}
		}

	}
}