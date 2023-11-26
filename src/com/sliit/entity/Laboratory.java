/*
 * Class Name : Laboratory
 * Entity class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : Bandara K. M. D. I.
 */

// package
package com.sliit.entity;

// imports

// class implementation
public class Laboratory {

    // properties
    private String id;
    private String purpose;
    private String location;
    private Teacher teacher;

    // default constructor
    public Laboratory() {
        id = null;
        purpose = null;
        location = null;
        teacher = null;
    }

    // overloaded constructor
    public Laboratory(String id, String purpose, String location, Teacher teacher) {
		this.id = id;
		this.purpose = purpose;
		this.location = location;
		this.teacher = teacher;
	}

    // getters and setters
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}