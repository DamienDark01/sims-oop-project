/*
 * Class Name : Classroom
 * Entity class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// package
package project;

// imports
public class Classroom {

    // properties
    private String id;
    private Teacher teacher;
    private String location;
    private int capacity;

    // default constructor
    public Classroom() {
        id = null;
        teacher = null;
        location = null;
        capacity = 0;
    }

    // overloaded constructor
    public Classroom(String id, Teacher teacher, String location, int capacity) {
		this.id = id;
		this.teacher = teacher;
		this.location = location;
		this.capacity = capacity;
	}

    // getters and setters
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}