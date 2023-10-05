/*
 * Classname : Classroom
 * Entity class
 *
 * Version info : ~
 *
 * Copyright notice
 * Author Name : 
 * Author Reg No :
 */

// imports
public class Classroom {

    // properties
    private String id;
    private String teacherId;
    private String location;
    private int capacity;

    // default constructor
    public Classroom() {
        id = null;
        teacherId = null;
        location = null;
        capacity = 0;
    }

    // overloaded constructor
    public Classroom(String id, String teacherId, String location, int capacity) {
		super();
		this.id = id;
		this.teacherId = teacherId;
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

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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