package com.metacube.training.question1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Directory class storing information about a directory
 * 
 * @author admin
 *
 */
public class Directory {

	private  String name;
	private final Date dateOfCreation;
	private List<Directory> listOfSubDirectory;

	public Directory(String name, Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
		this.name = name;
		this.listOfSubDirectory = new ArrayList<Directory>();
	}

	public List<Directory> getListOfSubDirectory() {
		return listOfSubDirectory;
	}

	public void setListOfSubDirectory(List<Directory> listOfSubDirectory) {
		this.listOfSubDirectory = listOfSubDirectory;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name= name;
	}
	

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

}
