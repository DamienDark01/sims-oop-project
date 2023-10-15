/*
 * Class Name : Student
 * Entity class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// package
package com.sliit.entities;

// imports

// class implementation
public class Student {

	// properties
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String contact;
	private String email;
	private String gender;
	private Classroom classroom;

    // default constructor
    public Student() {
        id = null;
        firstName = null;
        lastName = null;
        address = null;
        contact = null;
        email = null;
        gender = null;
        classroom = null;
    }

	// overloaded constructor
	public Student(String id, String firstName, String lastName, String address, String contact, String email, String gender, Classroom classroom) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.gender = gender;
		this.classroom = classroom;
	}

	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

}